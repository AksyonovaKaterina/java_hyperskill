package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public class NotFinished extends StateOfGame {

    public NotFinished(Game game) {
        super(game, true);
    }

    @Override
    public String printState() {
        return "Game not finished";
    }
}
