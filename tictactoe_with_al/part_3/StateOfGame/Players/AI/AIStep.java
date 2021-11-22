package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.AI;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.UserStep;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.Board;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.AI.LevelOfAI.Easy;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.AI.LevelOfAI.Level;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.Players.Stepper;


public class AIStep extends Stepper {

    private Level levelOfGame;

    public AIStep(char symbol, int complexity) {
        super(symbol);
        switch (LevelChoise.getByComplexity(complexity)) {
            case EASY:
                this.levelOfGame = new Easy();
                break;
        }
    }

    public boolean step(Board board) {
        boolean wasDone;
        int x = -1;
        int y = -1;
        do {
            x = levelOfGame.generateX();
            y = levelOfGame.generateY();
            wasDone = board.step(x, y, getCurChar());
        } while (!wasDone);
        printLevel();
        board.checkBoard();
        return true;
    }

    public void printLevel() {
        System.out.println("Making move level \"" + levelOfGame.getLevelName() + '\"');
    }

    private enum LevelChoise {
        EASY(0);

        private int complexity;

        LevelChoise(int complexity){
            this.complexity = complexity;
        }

        public static LevelChoise getByComplexity(int complexity){
            for (LevelChoise curLevel : LevelChoise.values()) {
                if (curLevel.complexity == complexity) {
                    return curLevel;
                }
            }
            return LevelChoise.EASY;
        }
    }
}
