package com.company;

import java.util.*;

public class Field {
    private int size;
    private String[][] grid;
    private int filled;
    private boolean tied;
    private List<String> alphabet = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
    private List<String> numlist = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    //Constructor
    public Field(int size) {
        this.size = size + 1;
        this.grid = new String[this.size][this.size];
        setCoordinateBorder(this.size);
        this.filled = 0;
        this.tied = false;
    }

    //Getters and Setters
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

    public void setFilled(int filled) {
        this.filled = filled;
    }

    //Setting the coordinate system around the board
    public void setCoordinateBorder(int dimension) {
        this.grid[0][0] = "  ";
        for (int j = 1; j < dimension; j++) {
            this.grid[0][j] = alphabet.get(j - 1);
        }
        for (int i = 1; i < dimension; i++) {
            this.grid[i][0] = numlist.get(i - 1);
        }
        for (int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++) {
                this.grid[i][j] = " ";
            }
        }
    }

    //Check if a player has won
    public void checkWin(int x, int y, User player) {
        int columnCounter = 0;
        int rowCounter = 0;
        int diagonalOneCounter = 0;
        int diagonalTwoCounter = 0;

        for (int i = 1; i < size; i++) {
            if (grid[i][y] == player.getCharacter()) {
                columnCounter++;
            }
        }

        for (int j = 1; j < size; j++) {
            if (grid[x][j] == player.getCharacter()) {
                rowCounter++;
            }
        }

        for (int ij = 1; ij < size; ij++) {
            if (grid[ij][ij] == player.getCharacter()) {
                diagonalOneCounter++;
            }
        }

        for (int ij = 1; ij < size; ij++) {
            if (grid[ij][size - ij] == player.getCharacter()) {
                diagonalTwoCounter++;
            }
        }

        if ((columnCounter == size - 1) || (rowCounter == size - 1) || (diagonalOneCounter == size - 1) || (diagonalTwoCounter == size - 1)) {
            player.setWon(true);
            System.out.println();
            System.out.println(player.getName() + " wins!!");
        } else if (filled == (size - 1) * (size - 1)) {
            this.tied = true;
            System.out.println();
            System.out.println("Tied!");
        }
    }

    //Input method
    public boolean input(User player, String coordinate) {
        String first = String.valueOf(coordinate.charAt(0)).toUpperCase();
        String second = String.valueOf(coordinate.charAt(1));

        int y = alphabet.indexOf(first) + 1;
        int x = numlist.indexOf(second) + 1;

        //check if a tile is empty and if so, inputs to it
        if (this.grid[x][y] == " ") {
            this.grid[x][y] = player.getCharacter();
            filled++;
            checkWin(x, y, player);
            return true;
        } else {
            return false;
        }
    }

}