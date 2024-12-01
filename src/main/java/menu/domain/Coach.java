package menu.domain;

public class Coach {

    private final String name;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 이름은 2글자 이상 4글자 이하여아 합니다.");
        }
    }
}
