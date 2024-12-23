package menu.dto.response;

import menu.domain.coach.Coach;

public class CoachNameResponse {
    private final String coachName;

    public CoachNameResponse(String coachName) {
        this.coachName = coachName;
    }

    public static CoachNameResponse from(Coach coach) {
        return new CoachNameResponse(coach.getName());
    }

    public String getCoachName() {
        return coachName;
    }
}
