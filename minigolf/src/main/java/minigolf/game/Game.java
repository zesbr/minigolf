package minigolf.game;

import minigolf.domain.Tee;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.domain.Ball;
import java.util.ArrayDeque;
import minigolf.domain.LevelArchitect;

/**
 * 
 * @author zesbr
 */
public class Game {
    
    private ArrayDeque<Level> levels;
    private ArrayDeque<Player> players;
    
    public Game() {
        this.levels = new ArrayDeque<>();
        this.players = new ArrayDeque<>();
        
        init();
    }
    
    /**
     * Lisää pelaajat ja kentät, sekä asettaa pelaajien pallot aloituspaikalle.
     */
    private void init() {
        addPlayers();
        addLevels();
        placeBallsToTee(getCurrentLevel().getTee()); 
    }
    
    public void start() {
        
    }
    
    public void startNewRound() {
        
    }
    
    // Lisää pelaajat
    private void addPlayers() {   
        Player p1 = new Player("P1");
        players.add(p1);        
    }
    
    // Lisää kentät
    private void addLevels() {
        levels.add(LevelArchitect.buildLevel(0));
        levels.add(LevelArchitect.buildLevel(1));
        levels.add(LevelArchitect.buildLevel(2));
        levels.add(LevelArchitect.buildLevel(3));
        levels.add(LevelArchitect.buildLevel(4));
    }
    
    /**
     * Vaihtaa kentän ja palauttaa seuraavaksi pelattavan kentän
     * @return seuraavaa vuorossa oleva kenttä
     */
    public Level switchLevel() {
        Level previous = levels.pollFirst();
        levels.add(previous);
        return getCurrentLevel();
    }
    
    /**
     * TODO
     * @return 
     */
    public Level getCurrentLevel() {
        return levels.peekFirst();
    }
    
    /**
     * Vaihtaa jonon edessä olevaa pelaaja. Ensimmäinen pelaaja menee viimeiseksi.
     */
    public void switchPlayer() {
        Player previous = players.pollFirst();
        players.add(previous);
    }
    
    /**
     * Palauttaa aktiivisen pelaajan
     * @return pelaaja
     */
    public Player getActivePlayer() {
        return players.peekFirst();
    }

    
    /**
     * Alustaa jokaisen pelaajan pallot aloituspaikalle.
     * @param tee
     */
    public void placeBallsToTee(Tee tee) {
        for (Player player : players) {
            player.setBall(new Ball(tee.getX(), tee.getY()));
        }
    }
    
    /**
     * Hakee ja palauttaa aktiivisen pelaajan pallon
     * @return Ball : Aktiivisen pelaajan pallo 
     */
    public Ball getActiveBall() {
        Player player = getActivePlayer();
        return player.getBall();
    }
    
    
}