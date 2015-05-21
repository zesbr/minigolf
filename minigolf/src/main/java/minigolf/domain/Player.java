package minigolf.domain;

public class Player {
    
    private String name;
    private Ball ball;

    public Player(String name) {
        this.name = name;
    }
    
    public Ball getBall() {
        return ball;
    }
    
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    
    public void put(Ball ball, int power, int angle) {
        
        // Laske pallon päämäärä
        double newX = (double) ball.getX();
        double newY = (double) ball.getY();
        
        for (int i = 0; i < (power * 5); i++) {
            newX += Math.cos(1.0 * Math.toRadians(angle));
            System.out.println("NEW X:" + newX);
            newY -= Math.sin(1.0 * Math.toRadians(angle)); 
        }  

        System.out.println("Pallo on nyt kohdassa: " + ball.getX() + ", " + ball.getY());
                
        ball.setX((int) newX);
        ball.setY((int) newY);
        
        // TODO: Before setting new coordinates for the ball, check that it's not out of bounds
        
        
        
        // TODO: Check if ball hits an obstacle

        // TODO: Check if ball is in hole
        
        // TODO: Animate ball trajectory
        
        // TODO: Repaint canvas
        
    }
    
}
