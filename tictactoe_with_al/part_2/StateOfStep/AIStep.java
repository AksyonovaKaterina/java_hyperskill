package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.Game;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.LevelOfAI.Easy;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.LevelOfAI.Level;


public class AIStep extends StateOfStep{

    private Level levelOfGame;

    public AIStep(Game game, int complexity) {
        super(game, 'O');
        switch (LevelChoise.getByComplexity(complexity)) {
            case EASY:
                this.levelOfGame = new Easy();
                break;
        }
    }

    public boolean step() {
        boolean wasDone;
        Game curGame = getGame();
        int x = -1;
        int y = -1;
        do {
            x = levelOfGame.generateX();
            y = levelOfGame.generateY();
            wasDone = curGame.step(x, y, 'O');
        } while (!wasDone);
        printLevel();
        curGame.changeStepOrder(new UserStep(curGame));
        curGame.changeState(curGame.checkBoard());
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
