package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public abstract class StateOfGame {
    private Game game;
    private boolean isRepeating;

    public StateOfGame(Game game, boolean isRepeating) {
        this.game = game;
        this.isRepeating = isRepeating;
    }

    public abstract String printState();

    public Game getGame() {
        return game;
    }

    public boolean isRepeating() {
        return isRepeating;
    }

    protected void stepping() {
        // вынести общую часть
    }

}
