package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI.LevelOfAI;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.Board;

import java.util.Random;

public class Easy extends Level {

    public Easy() {
        super("easy");
    }

    @Override
    public int generateCoordinate(Board board) {
        return new Random().nextInt(9);
    }

}

