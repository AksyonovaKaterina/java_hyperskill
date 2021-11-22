package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Game curGame = new Game(console);
        curGame.run();

    }

}
