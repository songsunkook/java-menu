package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final List<Category> providedCategories = new ArrayList<>();

    public void provideCategory(Category category) {
        providedCategories.add(category);
    }

    public List<Category> getProvidedCategories() {
        return new ArrayList<>(providedCategories);
    }
}
