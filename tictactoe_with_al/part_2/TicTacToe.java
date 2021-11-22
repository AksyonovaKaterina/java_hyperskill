package com.bad_java.homework.hyperskill.tictactoe_with_al.part_2;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Game curGame = new Game(console);
        curGame.printBoard();
        boolean wasDone;
        do {
            wasDone = curGame.getCurStep().step();
            if (wasDone) {
                curGame.printBoard();
            }
        } while (curGame.getState().isRepeating());
        console.println(curGame.getState().printState());
    }

}
