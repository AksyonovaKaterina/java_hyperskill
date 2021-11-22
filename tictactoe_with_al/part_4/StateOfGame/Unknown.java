package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame;

public class Unknown implements StateOfGame {


    @Override
    public boolean makeAction() {
        System.out.println("Bad parameters!");
        return true;
    }
}
