package menu.view;

import static menu.view.OutputMessage.*;

import menu.dto.response.CoachNameResponse;
import menu.dto.response.ResultResponse;

public class OutputView {

    private static final String DELIMITER = " | ";

    private StringBuilder buffer = new StringBuilder();

    public void start() {
        printDirect(START.getMessage());
    }

    public void inputCoachNames() {
        printDirect(INPUT_COACH_NAMES.getMessage());
    }

    public void inputHateMenus(CoachNameResponse response) {
        printDirect(INPUT_HATE_MENUS.getMessage(response.getCoachName()));
    }

    public void result(ResultResponse response) {
        print(RESULT.getMessage());
        print(RESULT_HEADER.getMessage());

        String categories = String.join(DELIMITER, response.getCategoryNames());
        print(RESULT_CATEGORIES.getMessage(categories));

        response.getCoachMenus().forEach(innerCoachMenu -> {
            String menus = String.join(DELIMITER, innerCoachMenu.getMenus());
            print(RESULT_COACH_MENUS.getMessage(innerCoachMenu.getCoachName(), menus));
        });

        print(FINISH.getMessage());
        flush();
    }

    public void exception(Exception e) {
        print(e.getMessage());
    }

    private void flush() {
        System.out.print(buffer);
        buffer = new StringBuilder();
    }

    private void print(String content) {
        buffer.append(content);
    }

    private void printDirect(String content) {
        print(content);
        flush();
    }
}
