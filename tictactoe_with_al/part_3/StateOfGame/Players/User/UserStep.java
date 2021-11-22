package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.User;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.AIStep;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.Board;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.Stepper;

public class UserStep extends Stepper {

    public UserStep(char symbol) {
        super(symbol);
    }

    public boolean step(Board board) {
        boolean wasDone;
        wasDone = board.step(getCurChar());
        if (wasDone) {
            board.checkBoard();
        }
        return wasDone;
    }

}
