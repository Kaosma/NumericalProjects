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
        System.out.println("Please select size for your 2 dimensional game, the width and height will be the same(MAX 26): ");
        int size = reader.nextInt();

        //Initiating field with game size
        Field game = new Field(size);

        //Read and initiate player 1
        System.out.println("Player 1 (☓) select name: ");
        User playerOne = new User(reader.next(), "☓");

        //Read and initiate player 2
        System.out.println("Player 2 (◯) select name: ");
        User playerTwo = new User(reader.next(), "◯");

        System.out.println(updateGame(game));

        //Running the game until player 1 or player 2 wins or until all boxes are filled
        while(!playerOne.isWon() && !playerTwo.isWon()) {
            System.out.println(playerOne.getName()+" choose coordinate (eg. a4): ");
            String input = reader.next();
            game.input(playerOne, input);
            System.out.println(updateGame(game));

            if(!playerOne.isWon()){
                System.out.println(playerTwo.getName()+" choose coordinate (eg. a4): ");
                input = reader.next();
                game.input(playerTwo, input);
                System.out.println(updateGame(game));
            }
        }
    }
}
