package com.minigolf.domain;


public class Player {

    private int number;
    private String name;
    
    public Player(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Player " + this.number + ": " + this.name;
    }
}
