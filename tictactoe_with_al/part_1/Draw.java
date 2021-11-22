package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class Draw extends State {

    public Draw(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSymbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSymbol);
        curGame.changeState(new Draw(curGame));
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new Draw(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "Draw";
    }
}
