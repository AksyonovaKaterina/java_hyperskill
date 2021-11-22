package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfBoard.*;

import java.util.ArrayList;

public class Board {

    private static final int CUR_HEIGHT = 3;
    private static final int CUR_WIDTH = 3;

    /*
    private static volatile Board instance; - to fix problems with multi threads
     */

    private static Board instance;
    private final Terminal console;
    private ArrayList<Node> board;
    private StateOfBoard stateOfBoard;
    private final int height;
    private final int width;
    private int countO;
    private int countX;


    public static Board getInstance(Terminal console) {
        return getInstance(CUR_WIDTH, CUR_HEIGHT, console);
    }

    private static Board getInstance(int width, int height, Terminal console) {
        /*
        with multi threads it will look different: check before rewrite
         */
        if(instance == null) {
            instance = new Board(width, height, console);
        }
        return instance;
    }


    private Board(int width, int height, Terminal console) {
        this.stateOfBoard = new Start();
        this.height = height;
        this.width = width;
        this.console = console;
        this.countO = 0;
        this.countX = 0;
        this.board = new ArrayList<Node>();
        boolean isAdded = true;
        for (int indexY = 0; indexY < height; indexY++) {
            for (int indexX = 0; indexX < width; indexX++) {
                isAdded = board.add(new Empty(indexX, indexY));
                if (!isAdded) {
                    // бросить исключение
                    System.out.println("Can't be added");
                }
            }
        }
    }

    public void checkBoard(){
        char winner = this.checkForWin();
        if (!this.checkForDivBetweenXO()) {
            switch (winner) {
                case 'X':
                    this.stateOfBoard = new XWin();
                    break;
                case 'O':
                    this.stateOfBoard = new OWin();
                    break;
                case 'I':
                    this.stateOfBoard = new Impossible();
                    break;
                case '_':
                    if (this.isBusy()) {
                        this.stateOfBoard = new Draw();
                    } else {
                        this.stateOfBoard = new NotFinished();
                    }
                    break;
                default:
                    this.stateOfBoard = new Impossible();
            }
        }

    }

    public void printBoardWithBoundaries() {
        printDashes();
        for (int curNode = 1; curNode <= board.size(); curNode++) {
            if (curNode % width == 1) {
                console.print("|");
            }
            console.print(" " + board.get(curNode - 1).toString());
            if (curNode % width == 0) {
                console.print(" |\n");
            }
        }
        printDashes();
    }

    private void printDashes() {
        console.println("---------");
    }

    public boolean step(int x, int y, char symbol) {
        if (Node.Coordinate.checkCoordinate(x, y, this.width, this.height) && !board.get(y * this.width + x).isBusy()) {
            switch (symbol) {
                case 'X':
                    board.set(y * width + x, new Cross(x, y));
                    countX++;
                    return true;
                case 'O':
                    board.set(y * width + x, new Zero(x, y));
                    countO++;
                    return true;
                case '_':
                    return true;
                default:
                    //выбросить исключение
                    console.println("Wrong char (step)");
                    return false;
            }
        } else {
            //выбросить исключение
            if (symbol == 'X') {
                //console.println("This cell is occupied! Choose another one!");
            }
            return false;
        }
    }

    public boolean step(char curhar){
        boolean wasDone = false;
        askForStep();
        int y = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;
        if (this.console.hasNextInt()) {
            y = this.console.readInt();
            if (this.console.hasNextInt()) {
                x = this.console.readInt();
                this.console.readLine();
                if (Board.Node.Coordinate.checkCoordinate(x - 1, y - 1, getWidth(), getHeight())) {
                    wasDone = this.step(x - 1, y - 1, curhar);
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

    private void askForStep() {
        console.print("Enter the coordinates: ");
    }

    public char checkForWin(){
        ArrayList<Character> winnersOnLIne = checkForWinners();
        int countX = 0;
        int countO = 0;
        for (Character winner : winnersOnLIne) {
            if (winner.equals('X')) {
                countX++;
            } else if (winner.equals('O')) {
                countO++;
            }
        }
        if (countX + countO > 1 && countX != 0 && countO != 0) {
            return 'I';
        } else if (countO != 0) {
            return 'O';
        } else if (countX != 0) {
            return 'X';
        } else {
            return '_';
        }
    }

    private ArrayList<Character> checkForWinners(){
        ArrayList<Character> winnersOnLIne = new ArrayList<Character>();
        for (POSSIBLE_LINES line : POSSIBLE_LINES.values()) {
            winnersOnLIne.add(checkLine(line));
        }
        return winnersOnLIne;
    }

    private char checkLine(POSSIBLE_LINES line){
        char firstSym = board.get(line.getFirst()).getSymbol();
        char secondSym = board.get(line.getSecond()).getSymbol();
        char thirdSym = board.get(line.getThird()).getSymbol();
        if (firstSym == secondSym && secondSym == thirdSym) {
            return firstSym;
        }
        return  '_';
    }

    public boolean isBusy(){
        return this.height * this.width == countO + countX;
    }


    public boolean checkForDivBetweenXO(){
        if (Math.abs(countO - countX) > 1) {
            return true;
        }
        return false;
    }

    public StateOfBoard getState(){
        return stateOfBoard;
    }

    public void changeState(StateOfBoard stateOfBoard){
        this.stateOfBoard = stateOfBoard;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void clear() {
        this.stateOfBoard = new Start();
        this.countO = 0;
        this.countX = 0;
        this.board = new ArrayList<Node>();
        boolean isAdded = true;
        for (int indexY = 0; indexY < height; indexY++) {
            for (int indexX = 0; indexX < width; indexX++) {
                isAdded = board.add(new Board.Empty(indexX, indexY));
                if (!isAdded) {
                    // бросить исключение
                    System.out.println("Can't be added");
                }
            }
        }
    }

    public static abstract class Node {
        Coordinate coordinate;

        Node(int x, int y) {
            this.coordinate = new Coordinate(x, y);
        }

        public abstract boolean isBusy();

        public abstract char getSymbol();

        public abstract void setBusy(boolean busy);

        public abstract void setSymbol(char symbol);

        @Override
        public abstract String toString();

        public static class Coordinate {
            private int x;
            private int y;

            public Coordinate(int x, int y) {
                this.x = x;
                this. y = y;
            }

            public boolean checkCoordinate(int maxWidth, int maxHeight) {
                if (this.x < 0 || this.x >= maxWidth || this.y < 0 || this.y >= maxHeight) {
                    return false;
                }
                return true;
            }

            public static boolean checkCoordinate(int x, int y, int maxWidth, int maxHeight) {
                if (x < 0 || x >= maxWidth || y < 0 || y >= maxHeight) {
                    return false;
                }
                return true;
            }

        }
    }

    static class Cross extends Node{
        private char symbol;
        protected boolean isBusy;

        Cross(int x, int y){
            super(x, y);
            this.symbol = 'X';
            this.isBusy = true;
        }

        @Override
        public boolean isBusy() {
            return true;
        }

        @Override
        public char getSymbol() {
            return 'X';
        }

        public String toString(){
            return String.valueOf(symbol);
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        public void setBusy(boolean busy) {
            this.isBusy = busy;
        }
    }

    static class Zero extends Node{
        private char symbol;
        protected boolean isBusy;

        Zero(int x, int y){
            super(x, y);
            this.symbol = 'O';
            this.isBusy = true;
        }

        @Override
        public boolean isBusy() {
            return true;
        }

        @Override
        public char getSymbol() {
            return 'O';
        }

        public String toString(){
            return String.valueOf(symbol);
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        public void setBusy(boolean busy) {
            this.isBusy = busy;
        }
    }

    static class Empty extends Node{
        private char symbol;
        protected boolean isBusy;

        Empty(int x, int y){
            super(x, y);
            this.symbol = ' ';
            this.isBusy = false;
        }

        @Override
        public boolean isBusy() {
            return false;
        }

        @Override
        public char getSymbol() {
            return ' ';
        }

        public String toString(){
            return String.valueOf(symbol);
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        public void setBusy(boolean busy) {
            this.isBusy = busy;
        }
    }

    enum POSSIBLE_LINES {
        FIRST_HORIZONTAL(0, 1, 2),
        SECOND_HORIZONTAL(3, 4, 5),
        THIRD_HORIZONTAL(6, 7, 8),
        FIRST_VERTICAL(0, 3, 6),
        SECOND_VERTICAL(1, 4, 7),
        THIRD_VERTICAL(2, 5, 8),
        MAIN_DIAGONAL(0, 4, 8),
        SUB_DIAGONAL(2, 4, 6);

        private final int first;
        private final int second;
        private final int third;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getThird() {
            return third;
        }

        POSSIBLE_LINES(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
