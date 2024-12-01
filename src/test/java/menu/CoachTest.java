package menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import menu.domain.Coach;
import menu.domain.Menu;

class CoachTest {

    @Test
    void 코치_이름은_최소_2글자_최대_4글자이다() {
        Coach coach1 = new Coach("포비");
        Coach coach2 = new Coach("wowa");
    }

    @Test
    void 코치_이름이_정상_범위를_벗어날_경우_예외를_반환한다() {
        assertThatThrownBy(() -> new Coach("토비의스프링"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Coach("woowa"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Coach("가"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 각_코치는_최소_0개_최대_2개의_못먹는_메뉴가_있다() {
        Coach coach = new Coach("포비");
        coach.addHateMenu(Menu.from("비빔밥"));
        coach.addHateMenu(Menu.from("스시"));
    }

    @Test
    void 못먹는_메뉴_수가_정상_범위를_벗어날_경우_예외를_반환한다() {
        assertThatThrownBy(() -> {
            Coach coach = new Coach("포비");
            coach.addHateMenu(Menu.from("비빔밥"));
            coach.addHateMenu(Menu.from("스시"));
            coach.addHateMenu(Menu.from("볶음면"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
    // TODO: DTO로 검증로직 이동
/*
    @Test
    void 못먹는_메뉴가_실제로_존재하지_않는_메뉴인_경우_예외를_반환한다() {
        assertThatThrownBy(() -> {
            Coach coach = new Coach("포비");
            coach.addHateMenu("감자");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Coach coach = new Coach("포비");
            coach.addHateMenu("짜계치");
        }).isInstanceOf(IllegalArgumentException.class);
    }*/
}
