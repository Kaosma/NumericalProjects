package com.company;

import java.util.*;

public class Main {

    public static String updateGame(Field object) {
        return object.getGrid();
    }

    //Main program
    public static void main(String[] args) {
        System.out.println();
        //Scanner for reading in the game size
        Scanner reader = new Scanner(System.in);
        System.out.println("Please select size for your 2 dimensional game, the width and height will be the same(MAX 9): ");
        int size = reader.nextInt();

        //Initiating field with game size
        Field game = new Field(size);

        //Read and initiate player 1
        System.out.println();
        System.out.println("Player 1 (☓) select name: ");
        User playerOne = new User(reader.next(), "☓");

        //Read and initiate player 2
        System.out.println();
        System.out.println("Player 2 (◯) select name: ");
        User playerTwo = new User(reader.next(), "◯");

        System.out.println(updateGame(game));

        //Running the game until player 1 or player 2 wins or until all boxes are filled
        while (!playerOne.isWon() && !playerTwo.isWon() && !game.getEven()) {

            //turn counter to keep track of who's turn it is
            int turn = 1;

            //reading and inputing  valid moves for player 1
            while (turn != 2) {
                System.out.println();
                System.out.println(playerOne.getName() + " choose coordinate (eg. a4): ");
                String input = reader.next();
                if (game.input(playerOne, input)) {
                    turn = 2;
                } else {
                    turn = 1;
                    System.out.println();
                    System.out.println("Invalid move");
                }
            }
            System.out.println(updateGame(game));

            //reading and inputing  valid moves for player 1
            if (!playerOne.isWon() && !game.getEven()) {
                while (turn != 1) {
                    System.out.println();
                    System.out.println(playerTwo.getName() + " choose coordinate (eg. a4): ");
                    String input = reader.next();
                    if (game.input(playerTwo, input)) {
                        turn = 1;
                    } else {
                        turn = 2;
                        System.out.println();
                        System.out.println("Invalid move");
                    }
                }
                System.out.println(updateGame(game));
            }
        }
    }
}
/*
- Exceptions
*/