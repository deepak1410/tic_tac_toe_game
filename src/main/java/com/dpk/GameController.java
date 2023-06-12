package com.dpk;

import static com.dpk.Player.PLAYER_O;
import static com.dpk.Player.PLAYER_X;

public class GameController {

    private final GameService gameService;
    private PlayerStrategy player1Strategy;
    private PlayerStrategy player2Strategy;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void setPlayer1Strategy(PlayerStrategy player1Strategy) {
        this.player1Strategy = player1Strategy;
    }

    public void setPlayer2Strategy(PlayerStrategy player2Strategy) {
        this.player2Strategy = player2Strategy;
    }

    public void start() {
        System.out.println("Tic-Tac-Toe Game");
        System.out.println("Player 1: " + PLAYER_X.name());
        System.out.println("Player 2: " + PLAYER_O.name());
        gameService.start();
    }

    public void playGame() {
        while (isGameOn()) {
            gameService.printBoard();

            if(gameService.getScoreBoard().getCurrentPlayer() == PLAYER_X) {
                player1Strategy.makeMove(gameService);
            } else {
                player2Strategy.makeMove(gameService);
            }

        }
        gameService.printBoard();
    }

    private boolean isGameOn() {
        return gameService.getScoreBoard().getStatus() == GameStatus.ON;
    }

}
