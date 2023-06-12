package com.dpk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dpk.ApplicationConstants.DIMENSION;
import static com.dpk.ApplicationConstants.VACANT;
import static com.dpk.Player.PLAYER_O;
import static com.dpk.Player.PLAYER_X;

public class TicTacToeServiceImpl implements GameService {
    private char[][] board;
    private ScoreBoard scoreBoard;

    @Override
    public void start() {
        System.out.println("Starting tic tac toe game");
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
            scoreBoard.setStatus(GameStatus.COMPLETED);
            scoreBoard.setWinners(List.of(scoreBoard.getCurrentPlayer()));
        } else if (isBoardFull()) {
            System.out.println("It's a DRAW!");
            scoreBoard.setStatus(GameStatus.COMPLETED);
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
            throw new TicTackToeException("The game has not started");
        } else if(scoreBoard.getStatus() == GameStatus.COMPLETED) {
            throw new TicTackToeException("The game has finished");
        }
    }

}
