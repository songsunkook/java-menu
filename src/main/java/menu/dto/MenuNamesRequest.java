package menu.dto;

import java.util.List;

public class MenuNamesRequest {

    private final List<String> menuNames;

    public MenuNamesRequest(List<String> coachNames) {
        this.menuNames = coachNames;
    }

    public static MenuNamesRequest from(String input) {
        return new MenuNamesRequest(List.of(input.split(",")));
    }

    public List<String> getMenuNames() {
        return menuNames;
    }
}