package menu.domain;

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
            throw new IllegalArgumentException("[ERROR] 이름은 2글자 이상 4글자 이하여아 합니다.");
        }
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
        validateHateMenuCount();
        // TODO: 일괄롤백되는지 확인
    }

    private void validateHateMenuCount() {
        if (hateMenus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 먹지 못하는 메뉴는 최소 0개, 최대 2개여야 합니다.");
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
