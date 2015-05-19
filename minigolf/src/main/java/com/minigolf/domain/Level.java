package com.minigolf.domain;

import java.util.Random;


public class Level {
    
    private int width;
    private int height;
    
    private int startX;
    private int startY;
    private Hole cup;
    
    // private Surface surface;
    // private ArrayList<Wall> walls;
    // private ArrayList<Obstacle> obstacles;

    public Level(int width, int height, int startX, int startY) {
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.cup = getRandomCup();
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
    
    public Hole getCup() {
        return cup;
    }
    
    private Hole getRandomCup() {
        Random random = new Random();
        int x = 0;
        int y = 0;
        while (true) {
            x = random.nextInt(width);
            y = random.nextInt(height);
            if ((Math.abs(startX - x) + Math.abs(startY - y)) > 200) {
                break;
            }
        }
        return new Hole(x, y);
    }
    
    public void setStartX(int startX) {
        this.startX = startX;
    }
    
    public void setStartY(int startY) {
        this.startY = startY;
    }

}