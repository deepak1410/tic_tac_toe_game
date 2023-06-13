package com.dpk.approach1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dpk.approach1.ApplicationConstants.DIMENSION;
import static com.dpk.approach1.ApplicationConstants.VACANT;
import static com.dpk.approach1.Player.PLAYER_O;
import static com.dpk.approach1.Player.PLAYER_X;

public class TicTacToeServiceImpl implements GameService {
    private char[][] board;
    private ScoreBoard scoreBoard;

    @Override
    public void start() {
        System.out.println("Starting tic tac toe game");
        System.out.println("Player 1: " + PLAYER_X.name());
        System.out.println("Player 2: " + PLAYER_O.name());
        initialiseBoard();
        initialiseScoreBoard();
    }

    @Override
    public boolean isValidMove(int row, int col) {
        checkGameStatus();
        return row >= 0 && row < DIMENSION && col >= 0 && col < DIMENSION && board[row][col] == VACANT;
    }

    @Override
    public void makeMove(int row, int col) {
        checkGameStatus();
        board[row][col] = scoreBoard.getCurrentPlayer().getMark();
        scoreBoard.decrementRemainingMovesByOne();
        updateScoreBoard(row, col);
    }

    @Override
    public void printBoard() {
        GameUtils.printBoard(board);
    }

    @Override
    public char[][] getBoard() {
        return board;
    }

    @Override
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    private void updateScoreBoard(int row, int col) {
        checkGameStatus();
        if (GameUtils.isWinningMove(board, row, col)) {
            System.out.println("Player " + scoreBoard.getCurrentPlayer().name() + " wins!");
            scoreBoard.setStatus(GameStatus.COMPLETED_BY_WIN);
            scoreBoard.setWinners(List.of(scoreBoard.getCurrentPlayer()));
            scoreBoard.setRemainingMoves(0);
        } else if (isBoardFull()) {
            System.out.println("It's a DRAW!");
            scoreBoard.setStatus(GameStatus.COMPLETED_BY_DRAW);
            scoreBoard.setWinners(List.of(PLAYER_X, PLAYER_O));
        } else {
            switchPlayer();
        }
    }

    private void switchPlayer() {
        if(scoreBoard.getCurrentPlayer() == PLAYER_X) {
            scoreBoard.setCurrentPlayer(PLAYER_O);
        } else {
            scoreBoard.setCurrentPlayer(PLAYER_X);
        }
    }

    private boolean isBoardFull() {
        return scoreBoard.getRemainingMoves() == 0;
    }

    private void initialiseBoard() {
        board = new char[DIMENSION][DIMENSION];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, VACANT));
    }

    private void initialiseScoreBoard() {
        scoreBoard = new ScoreBoard(PLAYER_X, DIMENSION * DIMENSION, GameStatus.ON, new ArrayList<>());
    }

    private void checkGameStatus() {
        if(scoreBoard == null || scoreBoard.getStatus() == GameStatus.NOT_STARTED) {
            throw new TicTacToeException("The game has not yet started");
        } else if(scoreBoard.getStatus() == GameStatus.COMPLETED_BY_WIN || scoreBoard.getStatus() == GameStatus.COMPLETED_BY_DRAW) {
            throw new TicTacToeException("The game has finished");
        }
    }

}
