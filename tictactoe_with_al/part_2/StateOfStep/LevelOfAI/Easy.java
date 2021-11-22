package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.LevelOfAI;

import java.util.Random;

public class Easy extends Level{

    public Easy() {
        super("easy");
    }

    @Override
    public int generateX() {
        return new Random().nextInt(3);
    }

    @Override
    public int generateY() {
        return new Random().nextInt(3);
    }
}

