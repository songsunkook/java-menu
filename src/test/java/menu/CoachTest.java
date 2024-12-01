package menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import menu.domain.Coach;

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
}
