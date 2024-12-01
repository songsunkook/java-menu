package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Menu;

public class MenuRandomUtil {

    public Category selectCategory() {
        return Category.values()[Randoms.pickNumberInRange(1, 5) - 1];
    }

    public Menu selectMenu(Category category) {
        return Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);
    }
}
