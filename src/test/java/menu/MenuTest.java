package menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import menu.domain.restaurant.menu.Menu;

class MenuTest {

    @Test
    void 못먹는_메뉴가_실제로_존재하지_않는_메뉴인_경우_예외를_반환한다() {
        assertThatThrownBy(() -> {
            Menu.from("치킨짜장면짬뽕탕수육마라탕사주세요");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Menu.from("짜계치기생충");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
