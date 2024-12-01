package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.request.CoachNamesRequest;
import menu.dto.request.MenuNamesRequest;

public class InputView {

    public static CoachNamesRequest coachNames() {
        return CoachNamesRequest.from(Console.readLine());
    }

    public static MenuNamesRequest menuNames() {
        return MenuNamesRequest.from(Console.readLine());
    }

    private InputView() {
    }
}
