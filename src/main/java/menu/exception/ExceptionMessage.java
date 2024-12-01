package menu.exception;

import menu.constant.MenuConstant;

public enum ExceptionMessage {
    COACH_NAME_OUT_OF_RANGE(String.format("코치 이름은 %d글자 이상 %d글자 이하여야 합니다.",
        MenuConstant.MINIMUM_COACH_NAME_LENGTH, MenuConstant.MAXIMUM_COACH_NAME_LENGTH)),
    HATE_MENU_COUNT_OUT_OF_RANGE(String.format("먹지 못하는 메뉴는 최소 %d개, 최대 %d개여야 합니다.",
        MenuConstant.MINIMUM_HATE_MENU_COUNT, MenuConstant.MAXIMUM_HATE_MENU_COUNT)),
    COACH_COUNT_OUT_OF_RANGE(String.format("코치는 최소 %d명, 최대 %d명이어야 합니다.",
        MenuConstant.MINIMUM_COACH_COUNT, MenuConstant.MAXIMUM_COACH_COUNT)),
    MENU_NAME_NOT_FOUND("메뉴를 찾을 수 없습니다."),
    COACH_NAME_NOT_FOUND("코치를 찾을 수 없습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해주세요.";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message + POSTFIX;
    }
}
