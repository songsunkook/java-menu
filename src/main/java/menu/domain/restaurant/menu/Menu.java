package menu.domain.restaurant.menu;

import static menu.domain.restaurant.menu.Category.*;
import static menu.exception.ExceptionMessage.MENU_NAME_NOT_FOUND;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    규동(JAPANESE_FOOD),
    우동(JAPANESE_FOOD),
    미소시루(JAPANESE_FOOD),
    스시(JAPANESE_FOOD),
    가츠동(JAPANESE_FOOD),
    오니기리(JAPANESE_FOOD),
    하이라이스(JAPANESE_FOOD),
    라멘(JAPANESE_FOOD),
    오코노미야끼(JAPANESE_FOOD),

    김밥(KOREAN_FOOD),
    김치찌개(KOREAN_FOOD),
    쌈밥(KOREAN_FOOD),
    된장찌개(KOREAN_FOOD),
    비빔밥(KOREAN_FOOD),
    칼국수(KOREAN_FOOD),
    불고기(KOREAN_FOOD),
    떡볶이(KOREAN_FOOD),
    제육볶음(KOREAN_FOOD),

    깐풍기(CHINESE_FOOD),
    볶음면(CHINESE_FOOD),
    동파육(CHINESE_FOOD),
    짜장면(CHINESE_FOOD),
    짬뽕(CHINESE_FOOD),
    마파두부(CHINESE_FOOD),
    탕수육(CHINESE_FOOD),
    토마토_달걀볶음(CHINESE_FOOD),
    고추잡채(CHINESE_FOOD),

    팟타이(ASIAN_FOOD),
    카오_팟(ASIAN_FOOD),
    나시고렝(ASIAN_FOOD),
    파인애플_볶음밥(ASIAN_FOOD),
    쌀국수(ASIAN_FOOD),
    똠얌꿍(ASIAN_FOOD),
    반미(ASIAN_FOOD),
    월남쌈(ASIAN_FOOD),
    분짜(ASIAN_FOOD),

    라자냐(WESTERN_FOOD),
    그라탱(WESTERN_FOOD),
    뇨끼(WESTERN_FOOD),
    끼슈(WESTERN_FOOD),
    프렌치_토스트(WESTERN_FOOD),
    바게트(WESTERN_FOOD),
    스파게티(WESTERN_FOOD),
    피자(WESTERN_FOOD),
    파니니(WESTERN_FOOD),
    ;

    public static final String CODE_SPACE = "_";
    public static final String OUTPUT_SPACE = " ";
    private final Category category;

    Menu(Category category) {
        this.category = category;
    }

    public static List<Menu> getMenusByCategory(Category category) {
        return Arrays.stream(values())
            .filter(menu -> menu.category == category)
            .collect(Collectors.toList());
    }

    public static Menu from(String name) {
        return Arrays.stream(values())
            .filter(menu -> menu.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(MENU_NAME_NOT_FOUND.getMessage()));
    }

    public String getName() {
        return name().replace(CODE_SPACE, OUTPUT_SPACE);
    }

    public Category getCategory() {
        return category;
    }
}
