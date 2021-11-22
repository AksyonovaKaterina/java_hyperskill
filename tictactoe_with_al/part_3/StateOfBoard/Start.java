package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfBoard;

public class Start extends StateOfBoard {

    public Start() {
        super(true);
    }

    @Override
    public String printState() {
        return "Game is started";
    }
}
