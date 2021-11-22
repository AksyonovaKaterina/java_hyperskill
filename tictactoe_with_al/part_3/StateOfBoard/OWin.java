package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfBoard;

public class OWin extends Win {

    public OWin() {
        super();
    }

    @Override
    public String printState() {
        return "O wins";
    }
}
