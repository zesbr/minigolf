
package com.minigolf.domain;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    
    private int x;
    private int y;
    private double speed;
    private double angle;
    private double velocity;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 0.0;
        this.angle = 0.0;
        this.velocity = 0.0;
        System.out.println("ballX: " + this.x + ", ballY: " + this.y);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAngle() {
        return angle;
    }
    
    public double getVelocity() {
        return velocity;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    
    // TODO: NOT WORKING PROPERLY
    public void calculateTrajectory(int power, int angle) {
        double newX = (double) x;
        double newY = (double) y;
        for (int i = 0; i < (3 * power); i++) {
            newX += Math.cos(1.0 * Math.toRadians(angle));
            System.out.println("NEW X:" + newX);
            newY -= Math.sin(1.0 * Math.toRadians(angle)); 
            //System.out.println("ballX: " + newX + ", ballY: " + newY);
        }  
        setX((int) newX);
        setY((int) newY);
        System.out.println("ballX: " + x + ", ballY: " + y);
    }
    
    public void animate() {
        // TODO
    }
    
    public void step() {
        // TODO
    }
    
    public void move() {
        // TODO
    }
    
    // Paints the ball
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 10, 10);
    }
    
}