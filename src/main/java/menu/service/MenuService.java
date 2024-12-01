package menu.service;

import static menu.constant.MenuConstant.OPERATING_DAYS;

import java.util.stream.IntStream;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.restaurant.Restaurant;
import menu.domain.restaurant.menu.Menu;
import menu.dto.request.CoachNamesRequest;
import menu.dto.request.MenuNamesRequest;
import menu.dto.response.CoachNameResponse;
import menu.dto.response.ResultResponse;

public class MenuService {

    private Coaches coaches;
    private Restaurant restaurant;

    public void setUp(CoachNamesRequest request) {
        coaches = new Coaches(request.getCoachNames());
        restaurant = new Restaurant();
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
        IntStream.range(0, OPERATING_DAYS)
            .boxed()
            .map(i -> restaurant.nextCategory())
            .forEach(category -> {
                coaches.resetIterator();
                while (coaches.hasNext()) {
                    Coach coach = coaches.getNext();
                    coach.eat(restaurant.nextMenuForCoach(category, coach));
                }
            });
        return ResultResponse.of(coaches, restaurant);
    }
}
