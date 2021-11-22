package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4;

public enum POSSIBLE_LINES {
    FIRST_HORIZONTAL(0, 1, 2),
    SECOND_HORIZONTAL(3, 4, 5),
    THIRD_HORIZONTAL(6, 7, 8),
    FIRST_VERTICAL(0, 3, 6),
    SECOND_VERTICAL(1, 4, 7),
    THIRD_VERTICAL(2, 5, 8),
    MAIN_DIAGONAL(0, 4, 8),
    SUB_DIAGONAL(2, 4, 6);

    private final int first;
    private final int second;
    private final int third;

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    POSSIBLE_LINES(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
