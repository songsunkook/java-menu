package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Recommender;
import menu.domain.Restaurant;
import menu.dto.CoachNameResponse;
import menu.dto.CoachNamesRequest;
import menu.dto.MenuNamesRequest;
import menu.dto.ResultResponse;

public class MenuService {

    private Coaches coaches;
    private Restaurant restaurant = new Restaurant();
    private final Recommender recommender = new Recommender();

    public void setCoaches(CoachNamesRequest request) {
        coaches = new Coaches(request.getCoachNames());
    }

    public boolean hasNextCoach() {
        return coaches.hasNext();
    }

    public CoachNameResponse nextCoach() {
        return CoachNameResponse.from(coaches.getNext());
    }

    public void setHateMenus(String coachName, MenuNamesRequest request) {
        Coach coach = coaches.from(coachName);
        try {
            request.getMenuNames().stream()
                .filter(menuName -> !menuName.isEmpty())
                .map(Menu::from)
                .forEach(coach::addHateMenu);
        } catch (IllegalArgumentException e) {
            coach.resetHateMenu();
            throw e;
        }
    }

    public ResultResponse result() {
        for (int i = 0; i < 5; i++) {
            Category category = recommender.selectCategory();
            restaurant.provideCategory(category);
            coaches.resetIterator();
            while (coaches.hasNext()) {
                Coach coach = coaches.getNext();
                coach.eat(recommender.selectMenu(category, coach));
            }
        }
        return ResultResponse.of(coaches, restaurant);
    }
}
