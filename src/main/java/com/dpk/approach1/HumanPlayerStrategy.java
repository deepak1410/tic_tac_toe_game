package com.dpk.approach1;

import java.util.Objects;
import java.util.Scanner;

import static com.dpk.approach1.ApplicationConstants.DIMENSION;

public class HumanPlayerStrategy implements PlayerStrategy {

    @Override
    public void makeMove(GameService gameService) {
        System.out.println(gameService.getScoreBoard().getCurrentPlayer().name()
                + " enter your move row and column (0-" + (DIMENSION - 1) + ") separated by space.:");

        Scanner scanner = new Scanner(System.in);
        try {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(gameService.isValidMove(row, col)) {
                gameService.makeMove(row, col);
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        } catch (Exception ex) {
            if(Objects.equals(scanner.next(), "q")) {
                System.out.println("Terminating the game");
                System.exit(0);
            }
            System.out.println("Invalid Input. Please try again.");
        }

    }
}
