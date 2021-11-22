package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.Board;

public abstract class Stepper {

    private final char curChar;

    public Stepper(char curChar) {
        this.curChar = curChar;
    }

    public abstract boolean step(Board board);

    public char getCurChar() {
        return curChar;
    }
}
