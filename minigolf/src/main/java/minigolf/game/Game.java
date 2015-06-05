package minigolf.game;

import minigolf.domain.Tee;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.domain.Ball;
import java.util.ArrayDeque;
import minigolf.domain.LevelArchitect;

/**
 * Pelikierrosta hallinnoiva luokka, jonka tehtävä on huolehtia pelikierroksen
 * alustamisesta, sekä pelikierroksen aikana tapahtuvista muutoksista kuten kentän
 * ja pelivuoron vaihdoista
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
    
    // Lisää pelaajat ja kentät, sekä asettaa pelaajien pallot aloituspaikalle.
    private void init() {
        addPlayers();
        addLevels();
        placeBallsToTee(getCurrentLevel().getTee()); 
    }
    
    // Lisää pelaajat
    private void addPlayers() {   
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        players.add(p1);        
        //players.add(p2);
    }
    
    // Lisää kentät
    private void addLevels() {
        levels.add(LevelArchitect.buildLevel(1));
        levels.add(LevelArchitect.buildLevel(2));
        levels.add(LevelArchitect.buildLevel(3));
        levels.add(LevelArchitect.buildLevel(4));
        levels.add(LevelArchitect.buildLevel(5));
        levels.add(LevelArchitect.buildLevel(6));
        levels.add(LevelArchitect.buildLevel(7));
        levels.add(LevelArchitect.buildLevel(8));
        levels.add(LevelArchitect.buildLevel(9));
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
     * Palauttaa nykyisen kentän eli sen jota parhaillaan pelataan
     * @return nykyinen kenttä
     */
    public Level getCurrentLevel() {
        return levels.peekFirst();
    }
    
    /**
     * Kierrättää tai vaihtaa aktiivisen pelaajan ja palauttaa seuraavan 
     * vuorossa olevan pelaajan
     * @return seuraava pelaaja 
     */
    public Player switchPlayer() {
        Player previous = players.pollFirst();
        players.add(previous);
        return getActivePlayer();
    }
    
    /**
     * Palauttaa aktiivisen pelaajan eli sen kenen vuoro parhaillaan on
     * @return aktiivinen pelaaja
     */
    public Player getActivePlayer() {
        return players.peekFirst();
    }

    /**
     * Alustaa jokaisen pelaajan pallot kentän aloituspaikalle.
     * @param tee : kentän aloituspaikka
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