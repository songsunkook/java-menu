package menu.domain;

import menu.util.MenuRandomUtil;

public class Recommander {

    private final MenuRandomUtil menuRandomUtil = new MenuRandomUtil();

    public Category selectCategory() {
        return menuRandomUtil.selectCategory();
    }

    public Menu selectMenu(Category category) {
        return menuRandomUtil.selectMenu(category);
    }
}
