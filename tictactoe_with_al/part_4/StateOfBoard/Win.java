package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfBoard;

public abstract class Win extends StateOfBoard {

    public Win() {
        super(false);
    }

    public abstract String printState();
}
