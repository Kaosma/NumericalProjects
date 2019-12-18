package com.company;

public class User {
    private String name;
    private String character;
    private int wins = 0;
    public boolean won = false;

    // Constructor
    User(String name, String character) {
        this.name = name;
        this.character = character;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getCharacter() {
        return character;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public int getWins() {
        return wins;
    }

    // Adding wins for a User
    public void addWin() {
        wins++;
    }
}
