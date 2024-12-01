package menu.controller;

import menu.domain.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService = new MenuService();

    public void run() {
        OutputView.start();

        OutputView.inputCoachNames();
        menuService.setCoaches(InputView.coachNames());

        while (menuService.hasNextCoach()) {
            Coach coach = menuService.nextCoach();
            OutputView.inputHateMenus(coach);
            menuService.setHateMenus(coach.getName(), InputView.menuNames());
        }

        OutputView.result(menuService.result());
    }
}
