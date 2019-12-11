package com.company;

public class Box {
    private String item;

    //Constructor
    public Box(String item) {
        this.item = item;
    }

    //Getters and Setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void write(String character){
        this.setItem(character);
    }

    public void erase(){
        this.setItem("E");
    }
}
