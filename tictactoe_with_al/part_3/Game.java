package com.bad_java.homework.hyperskill.tictactoe_with_al.part_3;

import com.bad_java.homework.hyperskill.tictactoe_with_al.part_3.StateOfGame.*;

public class Game {

    private final Terminal console;
    private Board playBoard;
    private StateOfGame step;

    public Game(Terminal console) {
        this.console = console;
        playBoard = Board.getInstance(console);
    }

    public void run() {
        do {
            String state = aksForAction();
            this.step = chooseState(state);
        } while (this.step.makeAction());

    }

    private StateOfGame chooseState(String input) {
        String[] parameters = input.split(" +");
        if (parameters.length > 0) {
            switch (parameters[0].toLowerCase()) {
                case "start":
                    if (parameters.length == 3) {
                        String firstPlayer = parameters[1];
                        String secondPlayer = parameters[2];
                        if (checkOpponent(firstPlayer) && checkOpponent(secondPlayer)) {
                            playBoard.clear();
                            return new Playing(playBoard, console, firstPlayer, secondPlayer);
                        }
                    }
                    return new Unknown();
                case "exit":
                    return new Exit();
                default:
                    return new Unknown();
            }
        }
        return new Unknown();
    }

    private boolean checkOpponent(String opponent){
       if ("user".equals(opponent) || "easy".equals(opponent)) {
           return true;
       }
       return false;
    }


    private String aksForAction() {
        console.print("Input command: ");
        return console.readLine();
    }


    public int getHeight() {
        return this.playBoard.getHeight();
    }

    public int getWidth() {
        return this.playBoard.getWidth();
    }

    public StateOfGame getStep() {
        return step;
    }

}
