package com.dpk;

/**
 * Custom exception class to throw specific exceptions
 */
public class TicTackToeException extends RuntimeException {

    public TicTackToeException(){
        super();
    }

    public TicTackToeException(String message) {
        super(message);
    }
}
