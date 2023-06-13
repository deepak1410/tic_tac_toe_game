package com.dpk.approach1;

import static com.dpk.approach1.Player.PLAYER_X;

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
