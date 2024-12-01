package menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Recommender;

class RecommenderTest {

    @Test
    void 추천할_카테고리를_무작위로_정한다() {
        Recommender recommender = new Recommender();
        Category category = recommender.selectCategory();
    }

    @Test
    void 같은_카테고리는_최대_2회까지만_고를_수_있다() {
        Recommender recommender = new Recommender();
        Map<Category, Integer> result = new EnumMap<>(Category.class);
        for (int i = 0; i < 5; i++) {
            Category category = recommender.selectCategory();
            result.put(category, result.getOrDefault(category, 0) + 1);
        }
        assertThat(result.values().stream().anyMatch(count -> count > 2)).isFalse();
    }

    @Test
    void 각_코치가_먹을_메뉴를_추천한다() {
        Recommender recommender = new Recommender();
        Category category = recommender.selectCategory();
        Coach coach = new Coach("포비");
        recommender.selectMenu(category, coach);
    }

    @Test
    void 각_코치에게_한_주에_중복되지_않는_메뉴를_추천해야_한다() {
        Recommender recommender = new Recommender();
        Category category = Category.KOREAN_FOOD;
        Coach coach = new Coach("포비");
        Menu 비빔밥 = Menu.from("비빔밥");
        coach.eat(비빔밥);
        for (int i = 0; i < 100; i++) {
            assertThat(recommender.selectMenu(category, coach)).isNotEqualTo(비빔밥);
        }
    }
}
