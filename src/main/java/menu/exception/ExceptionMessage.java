package menu.exception;

public enum ExceptionMessage {
    COACH_NAME_OUT_OF_RANGE("코치 이름은 2글자 이상 4글자 이하여아 합니다."),
    HATE_MENU_COUNT_OUT_OF_RANGE("먹지 못하는 메뉴는 최소 0개, 최대 2개여야 합니다."),
    MENU_NAME_NOT_FOUND("메뉴를 찾을 수 없습니다."),
    COACH_NAME_NOT_FOUND("코치를 찾을 수 없습니다."),
    COACH_COUNT_OUT_OF_RANGE("먹지 못하는 메뉴는 최소 0개, 최대 2개여야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해주세요.";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(PREFIX + message + POSTFIX, args);
    }
}
