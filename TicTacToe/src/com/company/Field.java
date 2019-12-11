package com.company;

import java.util.Arrays;

public class Field {
    private int size;
    private Box [][] grid;
    public int filled = 0;

    //Constructor
    public Field(int size) {
        this.size = size;
    }

    //Getters and Setters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFilled() {
        return filled;
    }

    public void setGrid() {
        this.grid = new Box[size][size];
    }

    public String getGrid() {
        return Arrays.deepToString(grid).replace("],", "],\n");
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }
}