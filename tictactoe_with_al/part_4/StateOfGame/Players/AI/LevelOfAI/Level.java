package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI.LevelOfAI;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.Board;

public abstract class Level {
    private final String levelName;

    public Level(String levelName) {
        this.levelName = levelName;
    }

    public abstract int generateCoordinate(Board board);

    public String getLevelName() {
        return levelName;
    }
}
