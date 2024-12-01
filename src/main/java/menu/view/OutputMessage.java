package menu.view;

public enum OutputMessage {
    START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH_NAMES("\n코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_HATE_MENUS("\n%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("\n메뉴 추천 결과입니다."),
    RESULT_HEADER("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    RESULT_CATEGORIES("[ 카테고리 | %s ]"),
    RESULT_COACH_MENUS("[ %s | %s ]"),
    FINISH("\n추천을 완료했습니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
