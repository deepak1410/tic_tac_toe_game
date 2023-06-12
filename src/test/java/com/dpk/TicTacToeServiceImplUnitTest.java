package com.dpk;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeServiceImplUnitTest {

    @ParameterizedTest
    @CsvSource({
            "5, 5, false",
            "1, 1, true"
    })
    public void testIsValidMoveBeforeGameStarts(int row, int col, boolean expectedResult) {
        GameService gameService = new TicTacToeServiceImpl();
        assertThrows(TicTackToeException.class, () -> gameService.isValidMove(row, col));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, false",
            "1, 1, true",
            "-1, 1, false"
    })
    public void testIsValidMoveWhenGameIsON(int row, int col, boolean expectedResult) {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();
        boolean result = gameService.isValidMove(row, col);
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldUpdateScoreBoardAfterMove() {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();
        ScoreBoard scoreBoard = gameService.getScoreBoard();
        Player currentPlayer = scoreBoard.getCurrentPlayer();

        gameService.makeMove(1, 1);

        Player newPlayer = scoreBoard.getCurrentPlayer();
        assertEquals(8, scoreBoard.getRemainingMoves());
        assertNotEquals(currentPlayer, newPlayer);
    }
}