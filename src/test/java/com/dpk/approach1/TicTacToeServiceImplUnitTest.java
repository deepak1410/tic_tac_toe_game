package com.dpk.approach1;

import com.dpk.approach1.GameService;
import com.dpk.approach1.GameStatus;
import com.dpk.approach1.Player;
import com.dpk.approach1.ScoreBoard;
import com.dpk.approach1.TicTacToeException;
import com.dpk.approach1.TicTacToeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeServiceImplUnitTest {

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "1, 1"
    })
    public void cannotMakeMovesWhenGameIsNotStarted(int row, int col) {
        GameService gameService = new TicTacToeServiceImpl();
        assertThrows(TicTacToeException.class, () -> gameService.isValidMove(row, col));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, false",
            "1, 1, true",
            "-1, 1, false"
    })
    public void canMakeMovesWhenTheGameIsON(int row, int col, boolean expectedResult) {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();
        boolean result = gameService.isValidMove(row, col);
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldUpdateScoreBoardOnEachMoves() {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();
        ScoreBoard scoreBoard = gameService.getScoreBoard();
        Player currentPlayer = scoreBoard.getCurrentPlayer();

        gameService.makeMove(1, 1);

        Player newPlayer = scoreBoard.getCurrentPlayer();
        assertEquals(8, scoreBoard.getRemainingMoves());
        assertNotEquals(currentPlayer, newPlayer);
    }

    @Test
    public void canWinTheGameByMatchingRow() {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();

        gameService.makeMove(0, 0); // Player1
        gameService.makeMove(1, 0); // Player2

        gameService.makeMove(0, 1); // Player1
        gameService.makeMove(2, 2); // Player2

        gameService.makeMove(0, 2); // Player1 : Winning move

        ScoreBoard scoreBoard = gameService.getScoreBoard();

        assertEquals(GameStatus.COMPLETED_BY_WIN, scoreBoard.getStatus());
        assertEquals(0, scoreBoard.getRemainingMoves());
        assertEquals(1, scoreBoard.getWinners().size());
        assertTrue(scoreBoard.getWinners().contains(Player.PLAYER_X));
    }

    @Test
    public void canWinTheGameByMatchingColumn() {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();

        gameService.makeMove(0, 0); // Player1
        gameService.makeMove(1, 1); // Player2

        gameService.makeMove(1, 0); // Player1
        gameService.makeMove(2, 2); // Player2

        gameService.makeMove(2, 0); // Player1 : Winning move

        ScoreBoard scoreBoard = gameService.getScoreBoard();

        assertEquals(GameStatus.COMPLETED_BY_WIN, scoreBoard.getStatus());
        assertEquals(0, scoreBoard.getRemainingMoves());
        assertEquals(1, scoreBoard.getWinners().size());
        assertTrue(scoreBoard.getWinners().contains(Player.PLAYER_X));
    }

    @Test
    public void canWinTheGameByMatchingDiagonal() {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();

        gameService.makeMove(0, 2); // Player1
        gameService.makeMove(0, 1); // Player2

        gameService.makeMove(1, 1); // Player1
        gameService.makeMove(2, 2); // Player2

        gameService.makeMove(2, 0); // Player1 : Winning move

        ScoreBoard scoreBoard = gameService.getScoreBoard();

        assertEquals(GameStatus.COMPLETED_BY_WIN, scoreBoard.getStatus());
        assertEquals(0, scoreBoard.getRemainingMoves());
        assertEquals(1, scoreBoard.getWinners().size());
        assertTrue(scoreBoard.getWinners().contains(Player.PLAYER_X));
    }

    @Test
    public void shouldResultInDrawWhenTheBoardIsFull() {
        GameService gameService = new TicTacToeServiceImpl();
        gameService.start();

        gameService.makeMove(0, 0);
        gameService.makeMove(1, 0);

        gameService.makeMove(0, 1);
        gameService.makeMove(0, 2);

        gameService.makeMove(2, 0);
        gameService.makeMove(1, 1);

        gameService.makeMove(1, 2);
        gameService.makeMove(2, 1);

        gameService.makeMove(2, 2);

        ScoreBoard scoreBoard = gameService.getScoreBoard();

        assertEquals(GameStatus.COMPLETED_BY_DRAW, scoreBoard.getStatus());
        assertEquals(0, scoreBoard.getRemainingMoves());
        assertEquals(2, scoreBoard.getWinners().size());
        assertTrue(scoreBoard.getWinners().contains(Player.PLAYER_X));
        assertTrue(scoreBoard.getWinners().contains(Player.PLAYER_O));
    }

}