package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfGame.*;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.StateOfStep;
import com.bad_java.homework.hyperskill.tictactoe_with_al.part_2.StateOfStep.UserStep;

public class Game {

    private StateOfGame state;
    private final Terminal console;
    private Board playBoard;
    private char curChar;
    private StateOfStep curStep;

    public Game(Terminal console) {
        this.console = console;
        this.state = new Start(this);
        this.curStep = new UserStep(this);
        playBoard = Board.getInstance(console);
    }

    public boolean step(){
        boolean wasDone = false;
        askForStep();
        int y = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;
        if (this.console.hasNextInt()) {
            y = this.console.readInt();
            if (this.console.hasNextInt()) {
                x = this.console.readInt();
                if (Board.Node.Coordinate.checkCoordinate(x - 1, y - 1, playBoard.getWidth(), playBoard.getHeight())) {
                    wasDone = this.playBoard.step(x - 1, y - 1, curStep.getCurChar());
                } else {
                    //выбросить исключение
                    console.println("Coordinates should be from 1 to 3!");
                }
            } else {
                String delete = console.readLine();
                console.println("You should enter numbers!");
            }
        } else {
            String delete = console.readLine();
            console.println("You should enter numbers!");
        }
        return wasDone;

    }

    public boolean step(int x, int y, char curChar){
        boolean wasDone = false;
        if(Board.Node.Coordinate.checkCoordinate(x, y, playBoard.getWidth(), playBoard.getHeight())){
            wasDone = this.playBoard.step(x, y, curChar);
        } else {
            //выбросить исключение
        }
        return wasDone;

    }

    public StateOfGame checkBoard(){
        char winner = this.playBoard.checkForWin();
        if (!this.playBoard.checkForDivBetweenXO()) {
            switch (winner) {
                case 'X':
                    return new XWin(this);
                case 'O':
                    return new OWin(this);
                case 'I':
                    return new Impossible(this);
                case '_':
                    if (this.playBoard.isBusy()) {
                        return new Draw(this);
                    } else {
                        return new NotFinished(this);
                    }
            }
        }
        return new Impossible(this);
    }

    public StateOfGame getState(){
        return state;
    }

    private void askForStep() {
        console.print("Enter the coordinates: ");
    }

    public void printBoard() {
        this.playBoard.printBoardWithBoundaries();
    }


    public void changeState(StateOfGame state){
        this.state = state;
    }

    public void changeStepOrder(StateOfStep curStep){
        this.curStep = curStep;
    }

    public int getHeight() {
        return this.playBoard.getHeight();
    }

    public int getWidth() {
        return this.playBoard.getWidth();
    }

    public StateOfStep getCurStep() {
        return curStep;
    }
}
