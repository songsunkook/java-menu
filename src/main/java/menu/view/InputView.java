package menu.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static List<String> coachNames() {
        return List.of(Console.readLine().split(","));
    }

    public static List<String> menuNames() {
        return List.of(Console.readLine().split(","));
    }
}
