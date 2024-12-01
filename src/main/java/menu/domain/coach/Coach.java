package menu.domain.coach;

import java.util.List;

import menu.domain.restaurant.menu.Menu;

public class Coach {

    private final Name name;
    private final AteMenus ateMenus = new AteMenus();
    private final HateMenus hateMenus = new HateMenus();

    public Coach(String name) {
        this.name = new Name(name);
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
    }

    public boolean isAte(Menu menu) {
        return ateMenus.contains(menu);
    }

    public void eat(Menu menu) {
        ateMenus.add(menu);
    }

    public String getName() {
        return name.get();
    }

    public List<Menu> getAteMenus() {
        return ateMenus.getMenus();
    }

    public void resetHateMenu() {
        hateMenus.reset();
    }
}
