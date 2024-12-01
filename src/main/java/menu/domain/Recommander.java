package menu.domain;

import menu.util.MenuRandomUtil;

public class Recommander {

    private final MenuRandomUtil menuRandomUtil = new MenuRandomUtil();

    public Category selectCategory() {
        return menuRandomUtil.selectCategory();
    }
}
