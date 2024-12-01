package menu.domain;

import static menu.exception.ExceptionMessage.COACH_NAME_OUT_OF_RANGE;
import static menu.exception.ExceptionMessage.HATE_MENU_COUNT_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();
    private final List<Menu> ateMenus = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
        validateHateMenuCount();
    }

    private void validateHateMenuCount() {
        if (hateMenus.size() > 2) {
            throw new IllegalArgumentException(HATE_MENU_COUNT_OUT_OF_RANGE.getMessage());
        }
    }

    public boolean isAte(Menu menu) {
        return ateMenus.contains(menu);
    }

    public void eat(Menu menu) {
        ateMenus.add(menu);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getAteMenus() {
        return new ArrayList<>(ateMenus);
    }

    public void resetHateMenu() {
        hateMenus.clear();
    }
}
