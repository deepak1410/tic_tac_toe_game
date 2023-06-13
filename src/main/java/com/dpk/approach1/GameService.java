package com.dpk.approach1;

public interface GameService {
    /**
     * Initialises the game variables like board and scoreboard and starts the game
     */
    public void start();

    /**
     * Prints the board and displays the items placed on the board.
     */
    public void printBoard();

    /**
     * Checks if the move is valid
     */
    boolean isValidMove(int row, int col);

    /**
     * Make a move on the board
     */
    void makeMove(int row, int col);

    /**
     * Returns the board
     */
    char[][] getBoard();

    /**
     * Returns the current scoreBoard
     */
    ScoreBoard getScoreBoard();
}
