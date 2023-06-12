package com.dpk;

import java.util.Arrays;

import static com.dpk.ApplicationConstants.DIMENSION;
import static com.dpk.ApplicationConstants.VACANT;
import static com.dpk.Player.PLAYER_O;
import static com.dpk.Player.PLAYER_X;

public class TicTacToeServiceImpl implements GameService {

    private char[][] board;
    private Player currentPlayer;
    private int remainingMoves;
    private GameStatus status = GameStatus.NOT_STARTED;

    @Override
    public void start() {
        System.out.println("Starting tic tac toe game");
        currentPlayer = PLAYER_X;
        remainingMoves = DIMENSION * DIMENSION;
        board = new char[DIMENSION][DIMENSION];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, VACANT));
        status = GameStatus.ON;
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < DIMENSION && col >= 0 && col < DIMENSION && board[row][col] == VACANT;
    }

    @Override
    public void makeMove(int row, int col) {
        board[row][col] = currentPlayer.getMark();
        remainingMoves--;
        updateScoreBoard(row, col);
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }

    @Override
    public void printBoard() {
        GameUtils.printBoard(board);
    }

    @Override
    public char[][] getBoard() {
        return board;
    }

    private void updateScoreBoard(int row, int col) {
        if (GameUtils.isWinningMove(board, row, col)) {
            System.out.println("Player " + currentPlayer.name() + " wins!");
            status = GameStatus.COMPLETED;
        } else if (isBoardFull()) {
            System.out.println("It's a DRAW!");
            status = GameStatus.COMPLETED;
        } else {
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private boolean isBoardFull() {
        return remainingMoves == 0;
    }

}
