package com.dpk;

import java.util.Scanner;

import static com.dpk.ApplicationConstants.DIMENSION;

public class HumanPlayerStrategy implements PlayerStrategy {

    @Override
    public void makeMove(GameService gameService) {
        System.out.println(gameService.getCurrentPlayer().name()
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
            System.out.println("Invalid Input. Please try again.");
        }

    }
}
