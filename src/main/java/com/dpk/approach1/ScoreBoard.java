package com.dpk.approach1;

import java.util.List;

public class ScoreBoard {
    private Player currentPlayer;
    private int remainingMoves;
    private GameStatus status = GameStatus.NOT_STARTED;
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

    public void decrementRemainingMovesByOne() {
        this.remainingMoves--;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public List<Player> getWinners() {
        return winners;
    }

    public void setWinners(List<Player> winners) {
        this.winners = winners;
    }
}
