package menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import menu.domain.Category;
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
        Menu menu = recommender.selectMenu(category);
    }
}
