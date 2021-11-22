package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI.LevelOfAI;

public class EasyLevelFactory implements LevelFactory{
    @Override
    public Level createLevel() {
        return new Easy();
    }
}
