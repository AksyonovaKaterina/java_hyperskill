package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class Start extends State {

    public Start(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSimbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSimbol);
        curGame.changeState(new NotFinished(curGame));
    }

    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new NotFinished(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "Game is started";
    }
}
