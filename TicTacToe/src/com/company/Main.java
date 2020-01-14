package com.company;

import java.util.*;

public class Main {

    public static List<User> players = new ArrayList<User>();

    public static String updateGame(Field object) {
        return object.printGrid();
    }

    // Input method
    public static boolean input(User player, String coordinate, Field game) {
        boolean validInput;
        String first = "";
        String second = "";

        // Catch error if input is invalid
        try {
            first = String.valueOf(coordinate.charAt(0)).toUpperCase();
            second = String.valueOf(coordinate.charAt(1));
            validInput = true;
        } catch (Exception e) {
            validInput = false;
        }
        if (coordinate.length() != 2 || !validInput) {
            return false;
        }

        int y = game.getAlphabet().indexOf(first) + 1;
        int x = game.getNumlist().indexOf(second) + 1;
        try { // Check if a tile is empty and if so, inputs into it
            if (game.checkEmpty(x,y)) {
                game.setGrid(x, y, player.getCharacter());
                game.addFilled();
                game.checkWin(x, y, player);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Add users to list of players
    public static void addUser(User player) {
        players.add(player);
    }

    // Update leaderboard method
    public static String updateLeaderboard() {
        String leaderboard = "       LEADERBOARD \n";
        for (int i = 0; i < players.size(); i++) {
            leaderboard += (players.get(i).getName() + "| " + players.get(i).getWins() + " W " + "        ");
        }
        return leaderboard;
    }

    //Main program
    public static void main(String[] args) {
        System.out.println();
        //Scanner for reading in the game size
        Scanner reader = new Scanner(System.in);
        System.out.println("Please select size for your 2 dimensional game, the width and height will be the same (MIN 3 - MAX 9): ");
        int size = 0;
        boolean correctInput = false;

        while (!correctInput) {
            try {
                String s = reader.nextLine();
                size = Integer.parseInt(s);
                correctInput = true;
            } catch (Exception e) {
                System.out.println("Try again (MIN 3 - MAX 9): ");
            }
        }

        //Initiating field with game size
        Field game = new Field(size);

        //Read and initiate player 1
        System.out.println();
        System.out.println("Player 1 (☓) select name: ");
        User playerOne = new User(reader.next(), "☓");
        addUser(playerOne);


        //Read and initiate player 2
        System.out.println();
        System.out.println("Player 2 (◯) select name: ");
        User playerTwo = new User(reader.next(), "◯");
        addUser(playerTwo);


        boolean quit = false;

        while (!quit) {

            // Game info printer
            System.out.println();
            System.out.println(updateGame(game));
            System.out.println();
            System.out.println("First to " + size + " in a row wins!");

            // Running the game until player 1 or player 2 wins or until all boxes are filled
            while (!playerOne.isWon() && !playerTwo.isWon() && !game.getEven()) {

                // Turn counter to keep track of who's turn it is
                int turn = 1;

                // Reading and inputing valid moves for player 1
                while (turn != 2) {
                    System.out.println();
                    System.out.println(playerOne.getName() + " choose coordinate (eg. a4): ");
                    String input = reader.next();
                    if (input(playerOne, input, game)) {
                        turn = 2;
                    } else {
                        turn = 1;
                        System.out.println();
                        System.out.println("Invalid move!");
                    }
                }
                System.out.println(updateGame(game));

                // Reading and inputing valid moves for player 1
                if (!playerOne.isWon() && !game.getEven()) {
                    while (turn != 1) {
                        System.out.println();
                        System.out.println(playerTwo.getName() + " choose coordinate (eg. a4): ");
                        String input = reader.next();
                        if (input(playerTwo, input, game)) {
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
            System.out.println();
            System.out.println(updateLeaderboard());

            System.out.println();
            System.out.println("Do you want to play again? (y/n): ");

            String choice = reader.next();

            if (choice.equals("n")) {
                quit = true;
                System.out.println();
                System.out.println("GOODBYE!");
            } else if (choice.equals("y")) {
                playerOne.setWon(false);
                playerTwo.setWon(false);
                game.resetGrid();
            }
        }
    }
}