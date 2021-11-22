package com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.Board;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.AI.LevelOfAI.*;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_4.StateOfGame.Players.Stepper;


public class AIStep extends Stepper {

    private Level levelOfGame;
    private LevelFactory factory;

    public AIStep(char symbol, int complexity) {
        super(symbol);
        switch (LevelChoice.getByComplexity(complexity)) {
            case EASY:
                factory = new EasyLevelFactory();
                this.levelOfGame = factory.createLevel();
                break;
            case MEDIUM:
                factory = new MediumLevelFactory();
                this.levelOfGame = factory.createLevel();
                break;
        }
    }

    public boolean step(Board board) {
        boolean wasDone;
        int x = -1;
        int y = -1;
        do {
            int coordinate = levelOfGame.generateCoordinate(board);
            x = coordinate % 3;
            y = coordinate / 3;
            wasDone = board.step(x, y, getCurChar());
        } while (!wasDone);
        printLevel();
        board.checkBoard();
        return true;
    }

    public void printLevel() {
        System.out.println("Making move level \"" + levelOfGame.getLevelName() + '\"');
    }

    private enum LevelChoice {
        EASY(0),
        MEDIUM(1);

        private int complexity;

        LevelChoice(int complexity){
            this.complexity = complexity;
        }

        public static LevelChoice getByComplexity(int complexity){
            for (LevelChoice curLevel : LevelChoice.values()) {
                if (curLevel.complexity == complexity) {
                    return curLevel;
                }
            }
            return LevelChoice.EASY;
        }
    }
}
