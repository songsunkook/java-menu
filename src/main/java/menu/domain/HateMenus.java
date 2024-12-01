package menu.domain;

import static menu.constant.MenuConstant.MAXIMUM_HATE_MENU_COUNT;
import static menu.constant.MenuConstant.MINIMUM_HATE_MENU_COUNT;
import static menu.exception.ExceptionMessage.HATE_MENU_COUNT_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.List;

public class HateMenus {

    private final List<Menu> hateMenus = new ArrayList<>();

    public void add(Menu menu) {
        hateMenus.add(menu);
        validateHateMenuCount();
    }

    private void validateHateMenuCount() {
        if (hateMenus.size() < MINIMUM_HATE_MENU_COUNT || hateMenus.size() > MAXIMUM_HATE_MENU_COUNT) {
            throw new IllegalArgumentException(HATE_MENU_COUNT_OUT_OF_RANGE.getMessage());
        }
    }

    public void reset() {
        hateMenus.clear();
    }
}
