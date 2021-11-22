package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfBoard;

public abstract class StateOfBoard {
    private boolean hasSteps;

    public StateOfBoard(boolean isRepeating) {
        this.hasSteps = isRepeating;
    }

    public abstract String printState();


    public boolean isRepeating() {
        return hasSteps;
    }

    protected void stepping() {
        // вынести общую часть
    }

}
