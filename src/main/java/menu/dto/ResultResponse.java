package menu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Restaurant;

public class ResultResponse {

    private final List<String> categoryNames;
    private final List<InnerCoachMenu> coachMenus;

    private ResultResponse(List<String> categoryNames, List<InnerCoachMenu> coachMenus) {
        this.categoryNames = categoryNames;
        this.coachMenus = coachMenus;
    }

    public static ResultResponse of(Coaches coaches, Restaurant restaurant) {
        List<String> categoryNames = restaurant.getProvidedCategories().stream()
            .map(Category::getName)
            .collect(Collectors.toList());

        List<InnerCoachMenu> coachMenus = new ArrayList<>();
        coaches.resetIterator();
        while (coaches.hasNext()) {
            coachMenus.add(InnerCoachMenu.from(coaches.getNext()));
        }
        return new ResultResponse(categoryNames, coachMenus);
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public List<InnerCoachMenu> getCoachMenus() {
        return coachMenus;
    }

    public static class InnerCoachMenu {
        private final String coachName;
        private final List<String> menus;

        private InnerCoachMenu(String coachName, List<String> menus) {
            this.coachName = coachName;
            this.menus = menus;
        }

        public static InnerCoachMenu from(Coach coach) {
            return new InnerCoachMenu(
                coach.getName(),
                coach.getAteMenus().stream()
                    .map(Menu::getName)
                    .collect(Collectors.toList())
            );
        }

        public String getCoachName() {
            return coachName;
        }

        public List<String> getMenus() {
            return menus;
        }
    }
}
