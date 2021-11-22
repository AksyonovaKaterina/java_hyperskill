package com.bad_java.homework.hyperskill.tictactoe_with_al.part_1;

public class Game {

    private State state;
    private final Terminal console;
    private Board playBoard;
    private char curChar;

    public Game(Terminal console) {
        this.console = console;
        this.curChar = 'X';
        this.state = new Start(this);
        playBoard = Board.getInstance(console);
    }

    public void play(String inputBoard) {
        CheckInput check = new CheckInput() {
            @Override
            public boolean checkBoardInput(String inputBoard) {
                if (inputBoard.length() != playBoard.getHeight() * playBoard.getWidth()) {
                    // добавить проверку на неподходящие симвоlы
                    return false;
                }
                return true;
            }
        };
        if (check.checkBoardInput(inputBoard)) {

        } else {
            console.println("Wrong inputBoard (play)!");
        }
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
                    wasDone = this.playBoard.step(x - 1, y - 1, this.playBoard.divBetweenXO() == 1 ? 'O' : 'X');
                    //changeCurChar();
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

    /*public void step(){
        askForStep();
        int x = this.console.readInt();
        int y = this.console.readInt();
        if(Board.Node.Coordinate.checkCoordinate(x, y, playBoard.getWidth(), playBoard.getHeight())){
            this.playBoard.step(x, y, curChar);
            changeCurChar();
        } else {
            //выбросить исключение
            console.println("Wrong coordinates (step)");
        }

    }*/

    public void step(int x, int y, char curChar){
        if(Board.Node.Coordinate.checkCoordinate(x, y, playBoard.getWidth(), playBoard.getHeight())){
            this.playBoard.step(x, y, curChar);
            //changeCurChar();
        } else {
            //выбросить исключение
            console.println("Wrong coordinates (step)");
        }

    }

    public State checkBoard(){
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

    public State getState(){
        return state;
    }

    private void askForStep() {
        console.print("Enter the coordinates: ");
    }

    public void printBoard() {
        this.playBoard.printBoardWithBoundaries();
    }

    /*private void changeCurChar(){
        this.curChar = this.curChar == 'X' ? 'O' : 'X';
    }*/

    public void changeState(State state){
        this.state = state;
    }

    public int getHeight() {
        return this.playBoard.getHeight();
    }

    public int getWidth() {
        return this.playBoard.getWidth();
    }

}
