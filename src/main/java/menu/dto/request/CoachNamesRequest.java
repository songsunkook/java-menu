package menu.dto.request;

import java.util.List;

public class CoachNamesRequest {

    private final List<String> coachNames;

    public CoachNamesRequest(List<String> coachNames) {
        this.coachNames = coachNames;
    }

    public static CoachNamesRequest from(String input) {
        return new CoachNamesRequest(List.of(input.split(",")));
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
