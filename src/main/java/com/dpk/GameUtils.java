package com.dpk;

import static com.dpk.ApplicationConstants.DIMENSION;

public class GameUtils {

    public static boolean isWinningMove(char[][] board, int row, int col) {
        char mark = board[row][col];
        return isWinningMove(board, row, col, mark);
    }

    public static boolean isWinningMove(char[][] board, int row, int col, char mark) {
        return isWinningRow(board, row, mark) || isWinningColumn(board, col, mark)
                || isWinningLeftDiagonal(board, row, mark) || isWinningRightDiagonal(board, row, col, mark);
    }

    public static void printBoard(char[][] board) {
        for(int i=0; i<DIMENSION; i++) {
            System.out.print("----");
        }
        System.out.print("-\n");

        for (int i = 0; i < DIMENSION; i++) {
            System.out.print("| ");
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(board[i][j] + " | ");
            }

            System.out.println();

            for(int j=0; j<DIMENSION; j++) {
                System.out.print("----");
            }
            System.out.print("-\n");
        }
    }

    private static boolean isWinningRow(char[][] board, int row, char mark) {
        for(int i=0; i< DIMENSION; i++) {
            if(board[row][i] != mark) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWinningColumn(char[][] board, int col, char mark) {
        for(int i=0; i< DIMENSION; i++) {
            if(board[i][col] != mark) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWinningLeftDiagonal(char[][] board, int row, char mark) {
        for(int i=0; i< DIMENSION; i++) {
            if(board[i][i] != mark) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWinningRightDiagonal(char[][] board, int row, int col, char mark) {
        if(row+col != DIMENSION - 1) {
            return false;
        }

        for(int i=0; i< DIMENSION; i++) {
            if(board[i][DIMENSION-i-1] != mark) {
                return false;
            }
        }
        return true;
    }
}
