package menu.domain.restaurant;

import java.util.EnumMap;
import java.util.Map;

import menu.domain.restaurant.menu.Category;

public class CategoryHistory {

    private final Map<Category, Integer> categoryHistory = new EnumMap<>(Category.class);

    public void add(Category category) {
        categoryHistory.put(category, categoryHistory.getOrDefault(category, 0) + 1);
    }

    public boolean canProvide(Category category) {
        return categoryHistory.getOrDefault(category, 0) + 1 > 2;
    }
}
