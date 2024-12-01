package menu.domain;

import static menu.constant.MenuConstant.MAXIMUM_COACH_COUNT;
import static menu.constant.MenuConstant.MINIMUM_COACH_COUNT;
import static menu.exception.ExceptionMessage.COACH_COUNT_OUT_OF_RANGE;
import static menu.exception.ExceptionMessage.COACH_NAME_NOT_FOUND;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coaches {

    private int cursor = 0;
    private final List<Coach> coaches;

    public Coaches(List<String> coachNames) {
        validateCoachCount(coachNames.size());
        coaches = coachNames.stream()
            .map(Coach::new)
            .collect(Collectors.toList());
    }

    private void validateCoachCount(int size) {
        if (size < MINIMUM_COACH_COUNT || size > MAXIMUM_COACH_COUNT) {
            throw new IllegalArgumentException(COACH_COUNT_OUT_OF_RANGE.getMessage());
        }
    }

    public Coach from(String name) {
        return coaches.stream()
            .filter(coach -> Objects.equals(coach.getName(), name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(COACH_NAME_NOT_FOUND.getMessage()));
    }

    public boolean hasNext() {
        return coaches.size() > cursor;
    }

    public Coach getNext() {
        Coach next = coaches.get(cursor);
        cursor++;
        return next;
    }

    public void resetIterator() {
        cursor = 0;
    }
}
