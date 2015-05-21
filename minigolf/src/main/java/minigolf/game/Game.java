package minigolf.game;

import minigolf.domain.Tee;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.domain.Hole;
import minigolf.domain.Ball;
import java.util.ArrayDeque;
import java.util.Random;

public class Game {
    
    private ArrayDeque<Level> levels;
    private ArrayDeque<Player> players;
    
    public Game() {
        
        initialize();
        
    }
    
    private void initialize() {
        
        this.levels = new ArrayDeque<>();
        this.players = new ArrayDeque<>();  
        
        loadPlayers();
        loadLevels();
        
        Level level = getCurrentLevel();
        
        Tee tee = level.getTee();
        
        initBalls(tee.getX(), tee.getY());
        
    }
    
    public void start() {
        
    
    }

    private void loadPlayers() {   
        players.add(new Player("P1"));
    }
    
    private void loadLevels() {
        Level level00 = buildLevel00();
        //Level random = buildRandomLevel();
        levels.add(level00);
        //levels.add(random);
        initBalls(level00.getX(), level00.getY());
    }
    
    private void initBalls(int x, int y) {
        for (Player player : players) {
            player.setBall(new Ball(x, y));
        }
    }
    
    private Level buildLevel00() {    
        return new Level(0, 0, 800, 600, new Tee(400, 550), new Hole(400, 50));
    }
    
    private Level buildRandomLevel() {
        Random random = new Random(); 
        int x = 0;
        int y = 0;
        do {
            x = random.nextInt(1100);
            y = random.nextInt(400);
        } while (x > 100 && y > 100);
        
        return new Level(0, 0, 1200, 720, new Tee(600, 100), new Hole(x, y));
    }
    
    public Level nextLevel() {
        Level nextLevel = levels.pollLast();
        levels.add(nextLevel);
        return nextLevel;
    }
    
    public Level getCurrentLevel() {
        return levels.peekLast();
    }
    
    public void switchPlayer() {
        Player nextPlayer = players.pollLast();
        players.add(nextPlayer);
    }
    
    public Player getCurrentPlayer() {
        return players.peekLast();
    }
    
}