package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public abstract class Win extends State {

    public Win(Game game) {
        super(game);
    }

    public abstract void nextStep(int x, int y, char curSymbol);

    public abstract boolean nextStep();

    public abstract String printState();
}
