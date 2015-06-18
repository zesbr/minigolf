package minigolf.game;

import minigolf.domain.Tee;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.domain.Ball;
import java.util.ArrayDeque;
import java.util.ArrayList;
import minigolf.domain.LevelArchitect;

/**
 * Pelikierrosta hallinnoiva luokka, jonka tehtävä on huolehtia pelikierroksen
 * alustamisesta, sekä pelikierroksen aikana tapahtuvista muutoksista kuten kentän
 * ja pelivuoron vaihdoista
 * @author zesbr
 */
public class Game {
    
    private ArrayList<Level> levels;
    private ArrayDeque<Level> unfinishedLevels;
    private ArrayDeque<Player> players;
    
    public Game() {
        this.levels = new ArrayList<>();
        this.players = new ArrayDeque<>();   
        this.unfinishedLevels = new ArrayDeque<>();
        
        init();
    }
    
    public Game(ArrayDeque<Player> players) {
        this.levels = new ArrayList<>();
        this.unfinishedLevels = new ArrayDeque<>();
        this.players = players;
        
        init();
    }
    
    public Game(ArrayList<Level> levels) {
        this.levels = levels;
        this.unfinishedLevels = new ArrayDeque<>();
        this.players = new ArrayDeque<>();
        
        init();
    }
    
    public Game(ArrayList<Level> levels, ArrayDeque<Player> players) {
        this.levels = levels;
        this.players = players;
        this.unfinishedLevels = new ArrayDeque<>();
        
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
        if (players.isEmpty()) {
           players.add(new Player("Player 1"));
        } else if (players.size() > 8) {
            ArrayDeque<Player> newPlayers = new ArrayDeque<>();
            int id = 1;
            for (Player player : players) {
                if (id == 9) {
                    break;
                }
                newPlayers.add(player);
                id++;
            }
            players = newPlayers;
        }
    }
    
    
    // Lisää kentät
    private void addLevels() { 
        
        // Jos kenttiä ei ole tai niitä on enemmän kuin yhdeksän, niin alustetaan peli yhdeksällä kentällä
        if (levels.isEmpty() || levels.size() > 9) {
            if (levels.size() > 9) {
                levels = new ArrayList<>();
            }
            for (int i = 1; i <= 9; i++) {
                Level level = LevelArchitect.buildLevel(i);
                levels.add(level);
                unfinishedLevels.add(level);
            }
        } else {
            for (Level level : levels) {
                unfinishedLevels.add(level);
            }
        }
           
    }
    
    /**
     * Vaihtaa kentän ja palauttaa seuraavaksi pelattavan kentän
     * @return seuraavaa vuorossa oleva kenttä
     */
    public Level switchLevel() {
        unfinishedLevels.pollFirst();
        return getCurrentLevel();
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
     * Palauttaa nykyisen kentän eli sen jota parhaillaan pelataan
     * @return nykyinen kenttä
     */
    public Level getCurrentLevel() {
        return unfinishedLevels.peekFirst();
    }
    
    /**
     * Kirjaa pelaajan lyönnit tuloskortiin
     */
    public void markScore() {
        Player player = getActivePlayer();
        player.addScore(getCurrentLevel(), player.getStrikes());
        System.out.println(player.getName() + " pelasi pallon reikään " + player.getStrikes() + " lyönnillä.");
        player.initStrikes();
    }
    
    /**
     * Tarkistaa onko peli päättynyt ja palautta totuusarvon.
     * @return totuusarvo siitä onko peli päättynyt (true) vai ei (false)
     */
    public boolean hasEnded() {
        Level level = getCurrentLevel();
        if (level == null) {
            return true;
        }
        return false;
    }
    
    /**
     * Tarkistaa ovatko kaikki pelaajat pelanneet nykyisen kentän ja palauttaa 
     * totuusarvon.
     * @return totuusarvo ovatko kaikki pelanneet kentän (true) vai eivät (false)
     */
    public boolean allPlayersHaveCompletedLevel() {
        Player player = getActivePlayer();
        if (player.getScore(getCurrentLevel()) != -1) {
            return true;
        }
        return false;
    }
     
    /**
     * Palauttaa aktiivisen pelaajan eli sen kenen vuoro parhaillaan on
     * @return aktiivinen pelaaja
     */
    public Player getActivePlayer() {
        return players.peekFirst();
    }
    
    /**
     * Hakee ja palauttaa aktiivisen pelaajan pallon
     * @return Ball : Aktiivisen pelaajan pallo 
     */
    public Ball getActiveBall() {
        Player player = getActivePlayer();
        return player.getBall();
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
     * Palautta kaikki kentät
     * @return kaikki kentät
     */
    public ArrayList getAllLevels() {
        return this.levels;
    }
    
    /**
     * Palauttaa kaikki pelaajat
     * @return kaikki pelaajat
     */
    public ArrayDeque getAllPlayers() {
        return this.players;
    }
    
    /**
     * Palauttaa kaikki kentät, jotka ovat vielä pelaamatta mukaan lukien
     * nykyinen kenttä
     * @return kaikki pelaamattomat kentät
     */
    public ArrayDeque getUnfinishedLevels() {
        return this.unfinishedLevels;
    }
    
}