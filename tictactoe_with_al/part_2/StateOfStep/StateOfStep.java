package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public abstract class StateOfStep {

    private final char curChar;
    private Game game;

    public StateOfStep (Game game, char curChar) {
        this.game = game;
        this.curChar = curChar;
    }

    public abstract boolean step();

    public char getCurChar() {
        return curChar;
    }

    protected Game getGame() {
        return game;
    }
}
