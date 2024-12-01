package menu.domain.restaurant;

import static menu.constant.MenuConstant.MAXIMUM_DUPLICATE_CATEGORY;

import java.util.EnumMap;
import java.util.Map;

import menu.domain.restaurant.menu.Category;

public class CategoryHistory {

    public static final int DEFAULT_VALUE = 0;
    public static final int INCREASE_UNIT = 1;

    private final Map<Category, Integer> categoryHistory = new EnumMap<>(Category.class);

    public void add(Category category) {
        categoryHistory.put(category, categoryHistory.getOrDefault(category, DEFAULT_VALUE) + INCREASE_UNIT);
    }

    public boolean canProvide(Category category) {
        return categoryHistory.getOrDefault(category, DEFAULT_VALUE) + INCREASE_UNIT > MAXIMUM_DUPLICATE_CATEGORY;
    }
}
