package com.dpk;

import static com.dpk.ApplicationConstants.COMPUTER_PLAYER_ENABLED;

public class TicTacToeClient {

    public static void main(String[] args) {
        System.out.println("Starting the tic tac toe game. To stop at any time, enter 'q'");
        GameController gameController = new GameController(new TicTacToeServiceImpl());

        // Set Player's strategies based on ApplicationConstants
        gameController.setPlayer1Strategy(new HumanPlayerStrategy());
        gameController.setPlayer2Strategy(COMPUTER_PLAYER_ENABLED ? new ComputerPlayerStrategy() : new HumanPlayerStrategy());

        // Start and play the Game
        gameController.start();
        gameController.playGame();
    }
}
