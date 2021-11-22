package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfBoard;

public class Impossible extends StateOfBoard {

    public Impossible() {
        super(false);
    }


    @Override
    public String printState() {
        return "Impossible";
    }

}
