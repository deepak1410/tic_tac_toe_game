package com.dpk.approach2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeGameUnitTest {

    @Test
    void canFindWinnerByRowMatch() {
        int dimension = 3;
        TicTacToeGame ticTacToeGame = new TicTacToeGame(dimension);
        char[][] board = new char[dimension][dimension];
        board[0][0] = 'X';
        board[1][0] = 'O';
        board[0][1] = 'X';
        board[2][0] = 'O';
        board[0][2] = 'X';

        char winner = ticTacToeGame.findWinner(board);
        assertEquals('X', winner);
    }

    @Test
    void canFindWinnerByColumnMatch() {
        int dimension = 3;
        TicTacToeGame ticTacToeGame = new TicTacToeGame(dimension);
        char[][] board = new char[dimension][dimension];
        board[0][0] = 'X';
        board[1][1] = 'O';
        board[1][0] = 'X';
        board[2][2] = 'O';
        board[2][0] = 'X';

        char winner = ticTacToeGame.findWinner(board);
        assertEquals('X', winner);
    }

    @Test
    void canFindWinnerByLeftDiagonalMatch() {
        int dimension = 3;
        TicTacToeGame ticTacToeGame = new TicTacToeGame(dimension);
        char[][] board = new char[dimension][dimension];
        board[0][0] = 'O';
        board[2][1] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'X';
        board[2][2] = 'O';

        char winner = ticTacToeGame.findWinner(board);
        assertEquals('O', winner);
    }

    @Test
    void canFindWinnerByRightDiagonalMatch() {
        int dimension = 3;
        TicTacToeGame ticTacToeGame = new TicTacToeGame(dimension);
        char[][] board = new char[dimension][dimension];
        board[0][2] = 'O';
        board[1][0] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'X';
        board[2][0] = 'O';

        char winner = ticTacToeGame.findWinner(board);
        assertEquals('O', winner);
    }

    @Test
    void cannotFindWinnerWithNoMatchFound() {
        int dimension = 3;
        TicTacToeGame ticTacToeGame = new TicTacToeGame(dimension);
        char[][] board = new char[dimension][dimension];
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[0][2] = 'X';
        board[1][0] = 'O';
        board[2][0] = 'X';

        char winner = ticTacToeGame.findWinner(board);
        assertEquals(' ', winner);
    }
}