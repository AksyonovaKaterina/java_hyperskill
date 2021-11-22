package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class OWin extends Win {

    public OWin(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSymbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSymbol);
        curGame.changeState(new OWin(curGame));
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new OWin(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "O wins";
    }
}
