package menu.domain;

import java.util.EnumMap;
import java.util.Map;

import menu.util.MenuRandomUtil;

public class Recommender {

    private final MenuRandomUtil menuRandomUtil = new MenuRandomUtil();

    Map<Category, Integer> recommendedCategories = new EnumMap<>(Category.class);

    public Category selectCategory() {
        Category result;
        do {
            result = menuRandomUtil.selectCategory();
        } while (validateSelectedCategoryCount(result));
        recommendedCategories.put(result, recommendedCategories.getOrDefault(result, 0) + 1);
        return result;
    }

    private boolean validateSelectedCategoryCount(Category result) {
        return recommendedCategories.getOrDefault(result, 0) + 1 > 2;
    }

    public Menu selectMenu(Category category, Coach coach) {
        Menu result;
        do {
            result = menuRandomUtil.selectMenu(category);
        } while (coach.isAte(result));
        return result;
    }
}
