package com.company;
import java.util.*;

public class Field {
    private int size;
    private String [][] grid;
    private int filled = 0;
    private List<String> alphabet = Arrays.asList("A","B","C","D","E","F","G","H","I",
                                                  "J","K","L","M","N","O","P","Q","R",
                                                  "S","T","U","V","W","X","Y","Z");
    private List<String> numlist = Arrays.asList("1","2","3","4","5","6","7","8","9","10",
                                                "11","12","13","14","15","16", "17","18",
                                                "19","20","21","22","23","24","25","26");

    //Constructor
    public Field(int size) {
        this.size = size+1;
        this.grid = new String[this.size][this.size];
        setCoordinateBorder(this.size);
    }

    //Getters and Setters
    public int getSize() {
        return size;
    }

    public int getFilled() {
        return filled;
    }

    public String getGrid() {
        return Arrays.deepToString(grid).replace("],", "\n").replace("[","").replace(",","").replace("]]","");
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    //Setting the coordinate system around the board
    public void setCoordinateBorder(int dimension){
        this.grid[0][0] = " ";
        for(int j = 1; j < dimension; j++) {
            this.grid[0][j] = alphabet.get(j-1);
        }
        for(int i = 1; i < dimension; i++) {
            this.grid[i][0] = numlist.get(i-1);
        }
        for(int i = 1; i < dimension; i++) {
            for(int j = 1; j < dimension; j++) {
                this.grid[i][j] = " ";
            }
        }
    }

    //Check if a player has won
    public void checkWin(int x, int y, User player){
        int currentX = x;
        int currentY = y;
        int rowCounter = 0;
        int diagonalCounter = 0;
        int columnCounter = 0;

        System.out.println(currentX);
        System.out.println(currentY);
        for(int i = 1; i < size; i++) {
            if(grid[i][currentY] == player.getCharacter()) {
                columnCounter++;
            }
        }

        for(int j = 1; j < size; j++) {
            if(grid[currentX][j] == player.getCharacter()) {
                rowCounter++;
            }
        }

        for(int ij = 1; ij < size; ij++) {
            if(grid[ij][ij] == player.getCharacter()) {
                diagonalCounter++;
            }
        }

        if((columnCounter == size-1) || (rowCounter == size-1) || (diagonalCounter == size-1)) {
            player.setWon(true);
            System.out.println();
            System.out.println(player.getName() + " wins!!");
        }


    }
    //Input method
    public void input(User player, String coordinate){
        String first = String.valueOf(coordinate.charAt(0)).toUpperCase();
        String second = String.valueOf(coordinate.charAt(1));

        int y = alphabet.indexOf(first)+1;
        int x = numlist.indexOf(second)+1;

        if(this.grid[x][y] == " "){
            this.grid[x][y] = player.getCharacter();
        } else{
            System.out.println("FULL!");
        }
        checkWin(x,y, player);
    }
}