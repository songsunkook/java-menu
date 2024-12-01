package menu.view;

import menu.dto.CoachNameResponse;
import menu.dto.ResultResponse;

public class OutputView {

    public static void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void inputCoachNames() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void inputHateMenus(CoachNameResponse response) {
        System.out.println("\n" + response.getCoachName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void result(ResultResponse response) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        String categories = String.join(" | ", response.getCategoryNames());
        System.out.println(String.format("[ 카테고리 | %s ]", categories));

        response.getCoachMenus().forEach(innerCoachMenu -> {
            String menus = String.join(" | ", innerCoachMenu.getMenus());
            System.out.println(String.format("[ %s | %s ]", innerCoachMenu.getCoachName(), menus));
        });

        System.out.println("\n추천을 완료했습니다.");
    }

    public static void exception(Exception e) {
        System.out.println(e.getMessage());
    }
}
