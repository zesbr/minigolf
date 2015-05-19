package com.minigolf.game;


import com.minigolf.domain.Player;
import com.minigolf.domain.Level;
import com.minigolf.domain.Ball;
import java.util.*;

public class Minigolf {

    private Level level;
    private Ball ball;
    private ArrayList<Player> players;
    
    public Minigolf(ArrayList<Player> players) {        
        this.level = new Level(800, 600, 400, 570);
        this.ball = new Ball(this.level.getStartX(), this.level.getStartY());
        this.players = players;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Ball getBall() {
        return ball;
    }
    
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    
}
