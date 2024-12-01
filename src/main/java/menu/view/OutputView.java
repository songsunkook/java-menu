package menu.view;

public class OutputView {

    public static void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void inputHateMenus() {
        System.out.println("토미(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void result() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        // TODO: 카테고리, 메뉴 출력
    }
}
