package com.dpk.approach2;

public class TicTacToeGame {
    private int dimension;

    public TicTacToeGame(int dimension) {
        this.dimension = dimension;
    }

    public char findWinner(char[][] board) {
        // Check rows
        for (int i = 0; i < dimension; i++) {
            char mark = board[i][0];
            for(int j = 0; j < dimension; j++) {
                if (mark == ' ' || board[i][j] != mark) {
                    break;
                } else if(j == dimension-1) {
                    System.out.println(mark + " won by row matching");
                    return mark;
                }
            }
        }

        // Check columns
        for (int i = 0; i < dimension; i++) {
            char mark = board[0][i];
            for(int j = 0; j < dimension; j++) {
                if (mark == ' ' || board[j][i] != mark) {
                    break;
                } else if(j == dimension-1) {
                    System.out.println(mark + " won by column matching");
                    return mark;
                }
            }
        }

        // Check left diagonal
        for (int i = 0; i < dimension; i++) {
            char mark = board[0][0];
            if (mark == ' ' || board[i][i] != mark) {
                break;
            } else if(i == dimension-1) {
                System.out.println(mark + " won by left diagonal matching");
                return mark;
            }
        }


        // Check right diagonal
        for (int i = dimension-1; i >= 0; i--) {
            char mark = board[0][dimension -1];
            if (mark == ' ' || board[dimension-1-i][i] != mark) {
                break;
            } else if(i == 0) {
                System.out.println(mark + " won by right diagonal matching");
                return mark;
            }
        }

        System.out.println("No winner found");
        return ' ';
    }
}
