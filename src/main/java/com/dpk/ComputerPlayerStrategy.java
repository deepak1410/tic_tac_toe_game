package com.dpk;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.dpk.ApplicationConstants.DIMENSION;

public class ComputerPlayerStrategy implements PlayerStrategy {

    @Override
    public void makeMove(GameService gameService) {
        System.out.println(gameService.getCurrentPlayer().name() + " enters the move");

        // Add a small delay in computer's move to sync with human
        delay();

        // Find winning move using BruteForce
        Optional<List<Integer>> optionalWinningMove = findWinningMove(gameService);

        if(optionalWinningMove.isPresent()) {
            List<Integer> winningMove = optionalWinningMove.get();
            gameService.makeMove(winningMove.get(0), winningMove.get(1));
        } else {
            // Winning move not found, find move randomly
            List<Integer> randomMove = findRandomMove(gameService);
            gameService.makeMove(randomMove.get(0), randomMove.get(1));
        }
    }

    private Optional<List<Integer>> findWinningMove(GameService gameService) {
        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                if (gameService.isValidMove(row, col) && GameUtils.isWinningMove(gameService.getBoard(), row, col, gameService.getCurrentPlayer().getMark())) {
                    return Optional.of(List.of(row, col));
                }
            }
        }

        return Optional.empty();
    }

    private List<Integer> findRandomMove(GameService gameService) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(DIMENSION);
            col = random.nextInt(DIMENSION);
        } while (!gameService.isValidMove(row, col));

        return List.of(row, col);
    }

    public void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted");
        }
    }

}
