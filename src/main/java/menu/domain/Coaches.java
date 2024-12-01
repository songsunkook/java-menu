package menu.domain;

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
        if (size < 2 || size > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명이어야 합니다.");
        }
    }

    public boolean hasNext() {
        return coaches.size() > cursor;
    }

    public Coach getNext() {
        Coach next = coaches.get(cursor);
        cursor++;
        return next;
    }

    public Coach from(String name) {
        return coaches.stream()
            .filter(coach -> Objects.equals(coach.getName(), name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] "));
    }

    public void resetIterator() {
        cursor = 0;
    }
}
