package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public class OWin extends Win {

    public OWin(Game game) {
        super(game);
    }

    @Override
    public String printState() {
        return "O wins";
    }
}
