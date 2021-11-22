package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.AI.LevelOfAI;

public abstract class Level {
    private final String levelName;

    public Level(String levelName) {
        this.levelName = levelName;
    }

    public abstract int generateX();

    public abstract int generateY();

    public String getLevelName() {
        return levelName;
    }
}
