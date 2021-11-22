package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class NotFinished extends State {

    public NotFinished(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSimbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSimbol);
        curGame.changeState(new NotFinished(curGame));

    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(curGame.checkBoard());
        return wasDone;
    }

    @Override
    public String printState() {
        return "Game not finished";
    }
}
