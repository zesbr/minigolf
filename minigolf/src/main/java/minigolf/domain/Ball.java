package minigolf.domain;

public class Ball implements BallPhysics {
    
    private float x;
    private float y;
    private double initSpeed;
    private double speed;
    private double angle;
    
    private final int RADIUS = 10;
    private final int DIAMETER = RADIUS * 2;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.initSpeed = 0.0;
        this.speed = 0.0;
        this.angle = 0.0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double getInitSpeed() {
        return initSpeed;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAngle() {
        return angle;
    }

    public int getRadius() {
        return RADIUS;
    }
    
    public int getDiameter() {
        return DIAMETER;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public void setY(float y) {
        this.y = y;
    }
    
    public void setInitSpeed(double initSpeed) {
        this.initSpeed = initSpeed;
    }
    
    public void setSpeed(double speed) {
        if (speed > 1000) {
            this.speed = 1000;
        } else if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed; 
        }
    }

    public void setAngle(double angle) {
        if (angle >= -180 && angle <= 180) {
            this.angle = angle;
        }
    }
    
    /**
     * Liikuttaa palloa yhdellä siirrolla määritettyyn suuntaan.
     */
    public void move() {
        
        float x = (float) (getX() + Math.cos(1.0 * Math.toRadians(angle)));
        float y = (float) (getY() - Math.sin(1.0 * Math.toRadians(angle))); 
        setX(x);
        setY(y);   
        speed -= 3;
    }

}