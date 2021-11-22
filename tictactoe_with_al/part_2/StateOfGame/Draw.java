package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public class Draw extends StateOfGame {

    public Draw(Game game) {
        super(game, false);
    }


    @Override
    public String printState() {
        return "Draw";
    }
}
