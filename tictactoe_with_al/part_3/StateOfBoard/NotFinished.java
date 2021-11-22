package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfBoard;

public class NotFinished extends StateOfBoard {

    public NotFinished() {
        super(true);
    }

    @Override
    public String printState() {
        return "Game not finished";
    }
}
