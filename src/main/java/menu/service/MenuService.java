package menu.service;

import java.util.List;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Recommender;
import menu.domain.Restaurant;
import menu.dto.ResultResponse;

public class MenuService {

    private Coaches coaches;
    private Restaurant restaurant = new Restaurant();
    private final Recommender recommender = new Recommender();

    public void setCoaches(List<String> names) {
        coaches = new Coaches(names);
    }

    public boolean hasNextCoach() {
        return coaches.hasNext();
    }

    public Coach nextCoach() {
        return coaches.getNext();
    }

    public void setHateMenus(String coachName, List<String> menuNames) {
        Coach coach = coaches.from(coachName);
        try {
            menuNames.stream()
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
            while (hasNextCoach()) {
                Coach coach = nextCoach();
                coach.eat(recommender.selectMenu(category, coach));
            }
        }
        return ResultResponse.of(coaches, restaurant);
    }
}
