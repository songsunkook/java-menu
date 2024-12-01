package menu.controller;

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
            String coachName = menuService.nextCoach();
            OutputView.inputHateMenus(coachName);
            menuService.setHateMenus(coachName, InputView.menuNames());
        }

        OutputView.result(menuService.result());
    }
}
