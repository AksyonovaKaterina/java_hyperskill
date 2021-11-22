package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.Board;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI.AIStep;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.Stepper;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.User.UserStep;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.Terminal;

public class Playing implements StateOfGame {

    private Board board;
    private Terminal console;
    private Stepper curStepper;
    private Stepper stepperX;
    private Stepper stepperO;

    public Playing(Board board, Terminal console, String stepperX, String stepperO) {
        this.board = board;
        this.console = console;
        this.stepperX = сhosePlayer(stepperX, 'X');
        this.stepperO = сhosePlayer(stepperO, 'O');
        this.curStepper = this.stepperX;
    }

    private Stepper сhosePlayer(String player, char symbol) {
        if ("user".equals(player)) {
            return new UserStep(symbol);
        } else if ("easy".equals(player)) {
            return new AIStep(symbol, 0);
        }  else if ("medium".equals(player)) {
            return new AIStep(symbol, 1);
        }
        //проверены входные данные, поэтому не вызовется, но оставила место для расширения
        return new UserStep(symbol);
    }

    @Override
    public boolean makeAction() {
        this.board.printBoardWithBoundaries();

        boolean wasDone;
        do {
            wasDone = curStepper.step(this.board);
            if (wasDone) {
                curStepper = curStepper.getCurChar() == 'X' ? stepperO : stepperX;
                this.board.printBoardWithBoundaries();
            }
        } while (board.getState().isRepeating());
        console.println(board.getState().printState());
        return true;
    }

}
