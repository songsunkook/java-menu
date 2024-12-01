package menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

import menu.domain.coach.Coaches;

class CoachesTest {

    @Test
    void 코치는_최소_2명_최대_5명이다() {
        Coaches coaches = new Coaches(List.of("가나", "다라", "마바", "사아", "자차"));
    }

    @Test
    void 코치_수가_정상_범위를_벗어날_경우_예외를_반환한다() {
        assertThatThrownBy(() -> {
            Coaches coaches = new Coaches(List.of("가나"));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Coaches coaches = new Coaches(List.of("가나", "다라", "마바", "사아", "자차", "타카"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
