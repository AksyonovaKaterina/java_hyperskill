package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public abstract class Win extends StateOfGame {

    public Win(Game game) {
        super(game, false);
    }

    public abstract String printState();
}
