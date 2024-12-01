package menu.controller;

import java.util.function.Consumer;

import menu.dto.response.CoachNameResponse;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();

    public void run() {
        process(this::start);
        process(this::setUpCoaches);
        process(this::setUpHateMenus);
        process(this::result);
    }

    private void start() {
        outputView.start();
    }

    private void setUpCoaches() {
        outputView.inputCoachNames();
        menuService.setUp(InputView.coachNames());
    }

    private void setUpHateMenus() {
        while (menuService.hasNextCoach()) {
            CoachNameResponse response = menuService.nextCoach();
            process(this::setUpHateMenu, response);
        }
    }

    private void setUpHateMenu(CoachNameResponse response) {
        outputView.inputHateMenus(response);
        menuService.setHateMenus(response.getCoachName(), InputView.menuNames());
    }

    private void result() {
        outputView.result(menuService.result());
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.exception(e);
            process(action);
        }
    }

    private void process(Consumer<CoachNameResponse> action, CoachNameResponse arg) {
        try {
            action.accept(arg);
        } catch (IllegalArgumentException e) {
            outputView.exception(e);
            process(action, arg);
        }
    }
}
