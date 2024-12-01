package menu.util;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.restaurant.menu.Category;
import menu.domain.restaurant.menu.Menu;

public class MenuRandomUtil {

    private static final int MINIMUM_CATEGORY_NUMBER = 1;
    private static final int MAXIMUM_CATEGORY_NUMBER = Category.values().length;

    public Category selectCategory() {
        return Category.values()[Randoms.pickNumberInRange(MINIMUM_CATEGORY_NUMBER, MAXIMUM_CATEGORY_NUMBER)
            - MINIMUM_CATEGORY_NUMBER];
    }

    public Menu selectMenu(Category category) {
        List<String> shuffledMenuNames = Randoms.shuffle(
            Menu.getMenusByCategory(category).stream().map(Menu::getName).collect(Collectors.toList()));
        return Menu.from(shuffledMenuNames.get(0));
    }
}
