package com.company;

public class User {
    private String name;
    private String character;
    public boolean won = false;

    //Constructor
    User(String name, String character) {
        this.name = name;
        this.character = character;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public String getCharacter() {
        return character;
    }

    public boolean isWon() {
        return won;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
