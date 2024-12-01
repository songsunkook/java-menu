package menu;

import org.junit.jupiter.api.Test;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Recommander;

class RecommenderTest {

    @Test
    void 추천할_카테고리를_무작위로_정한다() {
        Recommander recommander = new Recommander();
        Category category = recommander.selectCategory();
    }

    @Test
    void 각_코치가_먹을_메뉴를_추천한다() {
        Recommander recommander = new Recommander();
        Category category = recommander.selectCategory();
        Menu menu = recommander.selectMenu(category);
    }
}
