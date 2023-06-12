package com.dpk;

import java.util.List;

public class ScoreBoard {
    private Player currentPlayer;
    private int remainingMoves;
    private GameStatus status;
    private List<Player> winners;

    public ScoreBoard(Player currentPlayer, int remainingMoves, GameStatus status, List<Player> winners) {
        this.currentPlayer = currentPlayer;
        this.remainingMoves = remainingMoves;
        this.status = status;
        this.winners = winners;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getRemainingMoves() {
        return remainingMoves;
    }

    public void setRemainingMoves(int remainingMoves) {
        this.remainingMoves = remainingMoves;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
