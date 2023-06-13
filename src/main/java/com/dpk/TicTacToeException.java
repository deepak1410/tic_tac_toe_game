package com.dpk;

/**
 * Custom exception class to throw specific exceptions
 */
public class TicTacToeException extends RuntimeException {

    public TicTacToeException(){
        super();
    }

    public TicTacToeException(String message) {
        super(message);
    }
}
