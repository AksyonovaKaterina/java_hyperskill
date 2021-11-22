package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class XWin extends Win {

    public XWin(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSymbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSymbol);
        curGame.changeState(new XWin(curGame));
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new XWin(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "X wins";
    }
}
