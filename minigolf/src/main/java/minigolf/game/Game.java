package minigolf.game;

import minigolf.domain.Tee;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.domain.Hole;
import minigolf.domain.Ball;
import java.util.ArrayDeque;
import minigolf.domain.CourseArchitect;
import minigolf.domain.Obstacle;
import minigolf.gui.GameCanvas;

/**
 * 
 * @author zesbr
 */
public class Game {
    
    private ArrayDeque<Level> levels;
    private ArrayDeque<Player> players;
    private CourseArchitect architect;
    
    public Game() {
        this.levels = new ArrayDeque<>();
        this.players = new ArrayDeque<>();
        this.architect = new CourseArchitect();
        
        init();
    }
    
    /**
     * Lisää pelaajat ja kentät, sekä asettaa pelaajien pallot aloituspaikalle.
     */
    private void init() {
        addPlayers();
        addLevels();
        placeBallsToTee(getTee()); 
    }
    
    private void addPlayers() {   
        Player p1 = new Player("P1");
        players.add(p1);        
    }
    
    private void addLevels() {
        levels.add(architect.buildLevel01());
    }
    
    /**
     * 
     */
    public void switchLevel() {
        Level previous = levels.pollLast();
        levels.add(previous);
    }
    
    /**
     * 
     * @return 
     */
    public Level getCurrentLevel() {
        return levels.peekLast();
    }
    
    /**
     * Vaihtaa jonon edessä olevaa pelaaja. Ensimmäinen pelaaja menee viimeiseksi.
     */
    public void switchPlayer() {
        Player previous = players.pollLast();
        players.add(previous);
    }
    
    /**
     * 
     * @return 
     */
    public Player getActivePlayer() {
        return players.peekLast();
    }
    
    /**
     * 
     * @return 
     */
    public Tee getTee() {
        Level level = getCurrentLevel();
        return level.getTee();
    }
    
    /**
     * Alustaa jokaisen pelaajan pallot aloituspaikalle.
     * @param Tee : Kentän merkitty aloituspaikka.
     */
    private void placeBallsToTee(Tee tee) {
        for (Player player : players) {
            player.setBall(new Ball(tee.getX(), tee.getY()));
        }
    }
    
    /**
     * Hakee ja palauttaa aktiivisen pelaajan pallon
     * @return Ball : Aktiivisen pelaajan pallo 
     */
    public Ball getBallOnPlay() {
        Player player = getActivePlayer();
        return player.getBall();
    }
    
    /**
     * Suorittaa puttauksen
     * @param canvas
     * @param power
     * @param angle 
     */
    public void performPut(GameCanvas canvas, double power, double angle) {
        Ball ball = getBallOnPlay();
        ball.setInitSpeed(power);
        ball.setSpeed(power);
        ball.setAngle(angle);
        
        System.out.println("Ennen löyntiä pallo on kohdassa: [" +
                (int) ball.getX() + ", " + (int) ball.getY() + "]");
        
        int delay = 0;
        int limit = 20;
        for (int i = 20; i >= 0; i-=2) {
            if (power < limit) {
                delay = i;
                break;
            }
            limit += 100;
        }
        //canvas.setTimerDelay(delay);
        canvas.startTimer();
    }
    
    /**
     * Tarkistaa onko pallo reiässä ja palauttaa totuusarvon.
     * @param ball
     * @return boolean : totuusarvo, onko pallo reiässä (true) vai ei (false)
     */
    public boolean ballIsInHole(Ball ball) {
        Level level = getCurrentLevel();
        Hole hole = level.getHole();
        
        int holeCenterX = hole.getX() + hole.getRADIUS();
        int holeCenterY = hole.getY() + hole.getRADIUS();
        
        int ballCenterX = (int) ball.getX() + ball.getRadius();
        int ballCenterY = (int) ball.getY() + ball.getRadius();
        
        if (Math.pow(ballCenterX - holeCenterX, 2) + Math.pow(ballCenterY - holeCenterY, 2) < Math.pow(hole.getRADIUS(), 2)) {
            
            if (ball.getSpeed() < 100) {
                System.out.println("Pallo on reiässä! Hienoa!");
                ball.setSpeed(0);
                ball.setX(level.getTee().getX());
                ball.setY(level.getTee().getY());
                return true;
            } else {
                System.out.println("Pallo ylittää reiän koska sen nopeus on liian suuri");
                return false;
            }
            
        }
        return false;
    }
    
    /**
     * Tarkistaa osuuko pallo esteeseen ja jos osuu, niin laskee kimmokkeen 
     * aiheuttauman uuden kulman pallolle sekä palauttaa totuusarvon true. 
     * Jos pallo ei osu, niin palauttaa false.
     * 
     * TODO: 
     * Refaktoroi muuttujien alustus alussa 
     * Refaktoroi if-laseiden toisto
     * Siirrä kimpoamisen kulman laskenta toisaalle
     * 
     * @param ball
     * @return boolean : totuusarvo, että osuuko pallo esteeseen vai ei
     */
    public boolean ballHitsObstacle(Ball ball) {
        Level level = getCurrentLevel();
        
        int ballTopX = (int) ball.getX() + ball.getRadius();
        int ballTopY = (int) ball.getY();
        
        int ballBottomX = (int) ball.getX() + ball.getRadius();
        int ballBottomY = (int) ball.getY() + ball.getDiameter();
        
        int ballRightX = (int) ball.getX() + ball.getDiameter();
        int ballRightY = (int) ball.getY() + ball.getRadius();
        
        int ballLeftX = (int) ball.getX();
        int ballLeftY = (int) ball.getY() + ball.getRadius();
        
        for (Obstacle obstacle : level.getObstacles()) {    
            
            // Tarkistaa osuuko pallo esteen alalaitaan
            if (ballTopX >= obstacle.getX() && ballTopX <= obstacle.getX() + obstacle.getWidth() 
                    && ballTopY == obstacle.getY() + obstacle.getHeight()) {
                
                System.out.println("Pallo osui esteen alalaitaan kohdassa: [" 
                        + ballTopX + ", " + ballTopY + "]");
                
                // Asetetaan pallolle uusi suunta ja nopeus
                ball.setAngle(ball.getAngle() * -1);
                ball.setSpeed(ball.getSpeed() - 50);
                
                return true;
            }
            
            // Tarkistaa osuuko pallo esteen ylälaitaan
            if (ballBottomX >= obstacle.getX() && ballBottomX <= obstacle.getX() + obstacle.getWidth() 
                    && ballBottomY == obstacle.getY()) {
                
                System.out.println("Pallo osui esteen ylälaitaan kohdassa: [" 
                        + ballBottomX + ", " + ballBottomY + "]");
                
                // Asetetaan pallolle uusi suunta ja nopeus
                ball.setAngle(ball.getAngle() * -1);
                ball.setSpeed(ball.getSpeed() - 50);
                
                return true;
            }
            
            // Tarkistaa osuuko pallo eseteen oikeaan laitaan
            if (ballLeftY >= obstacle.getY() && ballLeftY <= obstacle.getY() + obstacle.getHeight() 
                    && ballLeftX == obstacle.getX() + obstacle.getWidth()) {
                
                System.out.println("Pallo osui esteen oikeaan laitaan kohdassa: [" 
                        + ballLeftX + ", " + ballLeftY + "]");
                
                // Asetetaan pallolle uusi suunta ja nopeus
                if (ball.getAngle() > 90 && ball.getAngle() <= 180) {
                    ball.setAngle(180 - ball.getAngle());
                } else {
                    ball.setAngle(-180 - ball.getAngle());
                }
                ball.setSpeed(ball.getSpeed() - 50);
                
                return true;
            }
            
            // Tarkistaa osuuko pallo esteen vasempaan laitaan
            if (ballRightY >= obstacle.getY() && ballRightY <= obstacle.getY() + obstacle.getHeight() 
                    && ballRightX == obstacle.getX()) {
                
                System.out.println("Pallo osui esteen vasempaan laitaan kohdassa: " 
                        + ballRightX + ", " + ballRightY + "]");
                
                // Asetetaan pallolle uusi suunta ja nopeus
                if (ball.getAngle() >= 0 && ball.getAngle() < 90) {
                    ball.setAngle(180 - ball.getAngle());
                } else {
                    ball.setAngle(-180 - ball.getAngle());
                }
                ball.setSpeed(ball.getSpeed() - 50);
                
                return true;
            }
        }
        return false;
    }
}