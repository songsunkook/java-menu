package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class AteMenus {

    private final List<Menu> ateMenus;

    public AteMenus() {
        ateMenus = new ArrayList<>();
    }

    public boolean contains(Menu menu) {
        return ateMenus.contains(menu);
    }

    public void add(Menu menu) {
        ateMenus.add(menu);
    }

    public List<Menu> getMenus() {
        return new ArrayList<>(ateMenus);
    }
}
