package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfBoard;

public class XWin extends Win {

    public XWin() {
        super();
    }

    @Override
    public String printState() {
        return "X wins";
    }
}
