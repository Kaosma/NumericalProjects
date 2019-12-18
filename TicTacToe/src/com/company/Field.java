package com.company;

import java.util.*;

public class Field {
    private int size;
    private String[][] grid;
    private List<User> players;
    private int filled;
    private boolean tied;
    private List<String> alphabet = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
    private List<String> numlist = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    // Constructor
    public Field(int size) {
        this.size = size + 1;
        this.grid = new String[this.size][this.size];
        setCoordinateBorder();
        this.tied = false;
        this.players = new ArrayList<User>();
    }

    // Getters and Setters
    public boolean getEven() {
        return tied;
    }

    public String getGrid() {
        String border = "";
        for (int i = 0; i < this.size - 1; i++) {
            border += "———┼";
        }
        border += "———";

        return "\n" + Arrays.deepToString(grid).replace("],", "\n" + border + "\n").replace("[", "").replace(",", " │").replace("]]", "");
    }

    // Add users to list of players
    public void addUser(User player) {
        this.players.add(player);
    }

    // Reset grid
    public void resetGrid() {
        for (int i = 1; i < this.size; i++) {
            for (int j = 1; j < this.size; j++) {
                this.grid[i][j] = " ";
            }
        }
        this.filled = 0;
        this.tied = false;
    }

    // Setting the coordinate system around the board
    public void setCoordinateBorder() {
        this.grid[0][0] = "  ";
        for (int j = 1; j < this.size; j++) {
            this.grid[0][j] = alphabet.get(j - 1);
        }
        for (int i = 1; i < this.size; i++) {
            this.grid[i][0] = numlist.get(i - 1);
        }
        resetGrid();
    }

    // Check if a player has won
    public void checkWin(int x, int y, User player) {
        int columnCounter = 0;
        int rowCounter = 0;
        int diagonalOneCounter = 0;
        int diagonalTwoCounter = 0;

        // Column
        for (int i = 1; i < size; i++) {
            if (grid[i][y] == player.getCharacter()) {
                columnCounter++;
            }
        }

        // Row
        for (int j = 1; j < size; j++) {
            if (grid[x][j] == player.getCharacter()) {
                rowCounter++;
            }
        }

        // Diagonally
        for (int ij = 1; ij < size; ij++) {
            if (grid[ij][ij] == player.getCharacter()) {
                diagonalOneCounter++;
            }
        }

        // Diagonally
        for (int ij = 1; ij < size; ij++) {
            if (grid[ij][size - ij] == player.getCharacter()) {
                diagonalTwoCounter++;
            }
        }

        if ((columnCounter == size - 1) || (rowCounter == size - 1) || (diagonalOneCounter == size - 1) || (diagonalTwoCounter == size - 1)) {
            player.setWon(true);
            System.out.println();
            System.out.println(player.getName() + " wins!!");
            player.addWin();
        } else if (filled == (size - 1) * (size - 1)) {
            this.tied = true;
            System.out.println();
            System.out.println("Tied!");
        }
    }

    // Input method
    public boolean input(User player, String coordinate) {
        boolean validInput = false;
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
        if(coordinate.length() != 2 || !validInput) {
            return false;
        }

        int y = alphabet.indexOf(first) + 1;
        int x = numlist.indexOf(second) + 1;
        try{ // Check if a tile is empty and if so, inputs into it
            if (this.grid[x][y] == " ") {
                this.grid[x][y] = player.getCharacter();
                filled++;
                checkWin(x, y, player);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Update leaderboard method
    public String updateLeaderboard() {
        String leaderboard = "       LEADERBOARD \n";
        for (int i = 0; i < players.size(); i++) {
            leaderboard += (players.get(i).getName() + "| " + players.get(i).getWins() + " W " + "        ");
        }
        return leaderboard;
    }

}