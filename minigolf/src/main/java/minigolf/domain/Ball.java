package minigolf.domain;

public class Ball {
    
    private int x;
    private int y;
    private double speed;
    private double angle;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 0.0;
        this.angle = 0.0;
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
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setSpeed(double speed) {
        if (speed > 999.99) {
            this.speed = 999.99;
        } else if (speed < 0.0) {
            this.speed = 0.0;
        } else {
            this.speed = speed; 
        }
    }
    
    public void setAngle(double angle) {
        if (angle <= 180 && angle >= -180) {
            this.angle = angle;
        }
    }
    
}