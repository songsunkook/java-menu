package menu.domain;

import static menu.constant.MenuConstant.MAXIMUM_COACH_NAME_LENGTH;
import static menu.constant.MenuConstant.MINIMUM_COACH_NAME_LENGTH;
import static menu.exception.ExceptionMessage.COACH_NAME_OUT_OF_RANGE;

public class Name {

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MINIMUM_COACH_NAME_LENGTH || name.length() > MAXIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(COACH_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    public String get() {
        return name;
    }
}
