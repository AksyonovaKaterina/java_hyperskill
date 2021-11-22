package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class Impossible extends State {

    public Impossible(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSymbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSymbol);
        curGame.changeState(new Impossible(curGame));
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new Impossible(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "Impossible";
    }

}
