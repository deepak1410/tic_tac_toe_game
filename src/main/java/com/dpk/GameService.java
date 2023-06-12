package com.dpk;

public interface GameService {

    public void start();

    Player getCurrentPlayer();

    public void printBoard();

    GameStatus getGameStatus();

    boolean isValidMove(int row, int col);

    void makeMove(int row, int col);

    char[][] getBoard();
}
