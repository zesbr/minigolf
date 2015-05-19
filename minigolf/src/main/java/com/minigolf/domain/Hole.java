package com.minigolf.domain;

import java.awt.Color;
import java.awt.Graphics;


public class Hole {

    private int x;
    private int y;
    
    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 20, 20);
    }
     
}