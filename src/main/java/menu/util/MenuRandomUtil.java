package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class MenuRandomUtil {

    public Category selectCategory() {
        return Category.values()[Randoms.pickNumberInRange(1, 5) - 1];
    }
}
