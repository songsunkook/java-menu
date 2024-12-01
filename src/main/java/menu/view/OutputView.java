package menu.view;

import static menu.view.OutputMessage.*;

import menu.dto.response.CoachNameResponse;
import menu.dto.response.ResultResponse;

public class OutputView {

    private static final String DELIMITER = " | ";

    public static void start() {
        System.out.println(START.getMessage());
    }

    public static void inputCoachNames() {
        System.out.println(INPUT_COACH_NAMES.getMessage());
    }

    public static void inputHateMenus(CoachNameResponse response) {
        System.out.println(INPUT_HATE_MENUS.getMessage(response.getCoachName()));
    }

    public static void result(ResultResponse response) {
        System.out.println(RESULT.getMessage());
        System.out.println(RESULT_HEADER.getMessage());

        String categories = String.join(DELIMITER, response.getCategoryNames());
        System.out.println(RESULT_CATEGORIES.getMessage(categories));

        response.getCoachMenus().forEach(innerCoachMenu -> {
            String menus = String.join(DELIMITER, innerCoachMenu.getMenus());
            System.out.println(RESULT_COACH_MENUS.getMessage(innerCoachMenu.getCoachName(), menus));
        });

        System.out.println(FINISH.getMessage());
    }

    public static void exception(Exception e) {
        System.out.println(e.getMessage());
    }
}
