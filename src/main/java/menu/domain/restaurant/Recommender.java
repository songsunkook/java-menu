package menu.domain.restaurant;

import menu.domain.restaurant.menu.Category;
import menu.domain.restaurant.menu.Menu;
import menu.domain.coach.Coach;
import menu.util.MenuRandomUtil;

public class Recommender {

    private final CategoryHistory categoryHistory = new CategoryHistory();
    private final MenuRandomUtil menuRandomUtil = new MenuRandomUtil();

    public Category selectCategory() {
        Category result;
        do {
            result = menuRandomUtil.selectCategory();
        } while (categoryHistory.canProvide(result));
        categoryHistory.add(result);
        return result;
    }

    public Menu selectMenu(Category category, Coach coach) {
        Menu result;
        do {
            result = menuRandomUtil.selectMenu(category);
        } while (coach.isAte(result));
        return result;
    }
}
