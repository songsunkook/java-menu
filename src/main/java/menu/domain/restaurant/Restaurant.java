package menu.domain.restaurant;

import java.util.ArrayList;
import java.util.List;

import menu.domain.restaurant.menu.Category;
import menu.domain.restaurant.menu.Menu;
import menu.domain.coach.Coach;

public class Restaurant {

    private final Recommender recommender = new Recommender();
    private final List<Category> providedCategories = new ArrayList<>();

    public List<Category> getProvidedCategories() {
        return new ArrayList<>(providedCategories);
    }

    public Category nextCategory() {
        Category category = recommender.selectCategory();
        providedCategories.add(category);
        return category;
    }

    public Menu nextMenuForCoach(Category category, Coach coach) {
        return recommender.selectMenu(category, coach);
    }
}
