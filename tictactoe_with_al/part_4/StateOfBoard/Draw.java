package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfBoard;

public class Draw extends StateOfBoard {

    public Draw() {
        super(false);
    }


    @Override
    public String printState() {
        return "Draw";
    }
}
