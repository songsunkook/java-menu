package menu.controller;

import java.util.function.Consumer;

import menu.domain.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService = new MenuService();

    public void run() {
        process(this::start);
        process(this::setUpCoaches);
        process(this::setUpHateMenus);
        process(this::result);
    }

    private void start() {
        OutputView.start();
    }

    private void setUpCoaches() {
        OutputView.inputCoachNames();
        menuService.setCoaches(InputView.coachNames());
    }

    private void setUpHateMenus() {
        while (menuService.hasNextCoach()) {
            Coach coach = menuService.nextCoach();
            process(this::setUpHateMenu, coach);
        }
    }

    private void setUpHateMenu(Coach coach) {
        OutputView.inputHateMenus(coach);
        menuService.setHateMenus(coach.getName(), InputView.menuNames());
    }

    private void result() {
        OutputView.result(menuService.result());
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.exception(e);
            process(action);
        }
    }

    private void process(Consumer<Coach> action, Coach args) {
        try {
            action.accept(args);
        } catch (IllegalArgumentException e) {
            OutputView.exception(e);
            process(action, args);
        }
    }
}
