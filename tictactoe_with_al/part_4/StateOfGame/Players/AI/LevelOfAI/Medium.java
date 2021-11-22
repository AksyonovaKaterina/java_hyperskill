package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI.LevelOfAI;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.Board;

import java.util.Random;


public class Medium extends Level{


    public Medium() {
        super("medium");
    }

    @Override
    public int generateCoordinate(Board board) {
        int coordinate = board.whereToStep();
        return coordinate != -1 ? coordinate : new Random().nextInt(9);
    }

}
