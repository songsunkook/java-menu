package menu.util;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.restaurant.menu.Category;
import menu.domain.restaurant.menu.Menu;

public class MenuRandomUtil {

    public Category selectCategory() {
        return Category.values()[Randoms.pickNumberInRange(1, 5) - 1];
    }

    public Menu selectMenu(Category category) {
        List<String> shuffledMenuNames = Randoms.shuffle(
            Menu.getMenusByCategory(category).stream().map(Menu::getName).collect(Collectors.toList()));
        return Menu.from(shuffledMenuNames.get(0));
    }
}
