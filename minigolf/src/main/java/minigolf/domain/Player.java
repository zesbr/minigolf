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
    
}
