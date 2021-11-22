package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public class XWin extends Win {

    public XWin(Game game) {
        super(game);
    }

    @Override
    public String printState() {
        return "X wins";
    }
}
