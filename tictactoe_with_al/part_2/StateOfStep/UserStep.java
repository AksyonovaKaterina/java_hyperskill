package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;

public class UserStep extends StateOfStep{

    public UserStep(Game game) {
        super(game, 'X');
    }

    public boolean step() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        if (wasDone) {
            curGame.changeStepOrder(new AIStep(curGame, 0));
            curGame.changeState(curGame.checkBoard());
        }
        return wasDone;
    }
}
