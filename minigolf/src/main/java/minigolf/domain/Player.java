package minigolf.domain;

import java.util.HashMap;
import java.util.Objects;

/**
 * Pelikierrokselle osallistuvaa pelaajaa mallintava luokka, jonka tehtävänä on
 * pitää kirjaa pelaajan tiedoista ja lyönneistä, sekä määrittää pallolle lähtö-
 * nopeus ja -voima lyönnin alussa.
 * @author zesbr
 */
public class Player {
    
    private String name;
    private Ball ball;
    private int strikes;
    private HashMap<Level, Integer> scorecard;

    public Player(String name) {
        this.name = name;
        this.strikes = 0;
        this.scorecard = new HashMap<>();
    }
    
    /**
     * Palauttaa pelaajalle kuuluvan pallon
     * @return pelaajan omistama pallo
     */
    public Ball getBall() {
        return ball;
    }
    
    /**
     * Asettaa pelaajalle uuden pallon
     * @param ball : pelaajan uusi pallo
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     * Palauttaa pelaajan suorittamien lyöntien määrän
     * @return lyöntien lukumäärä
     */
    public int getStrikes() {
        return strikes;
    }
    
    /**
     * Palauttaa pelaajan nimen
     * @return pelaajan nimi
     */
    public String getName() {
        return name;
    }
    
     /**
     * Nollaa lyöntilaskurin
     */
    public void initStrikes() {
        strikes = 0;
    }
    
    /**
     * Suorittaa lyönnin eli puttauksen, joka  asettaa pallolle löhtänopeuden ja 
     * -kulman, sekä kasvattaa lyöntilaskuria yhdellä
     * @param power : lyönnin voima, joka on sama kuin pallon lähtönopeus
     * @param angle : lyönnin nopeus, joka on sama kuin pallon lähtökulma
     */
    public void put(double power, double angle) {
        ball.setSpeed(power);
        ball.setAngle(angle);
        strikes++;
    }
    
    /**
     * Lisää uuden tuloksen kenttää kohti
     * @param level : kenttä (avain)
     * @param score : tulos eli lyöntien lukumäärä (arvo)
     */
    public void addScore(Level level, int score) {
        if (level != null) {
            this.scorecard.put(level, score);
        }
    }
    
    /**
     * Palauttaa tuloksen, jonka pelaaja suoritti kentällä
     * @param level : kenttä
     * @return tulos eli lyöntien lukumäärä. palauttaa -1, jos kenttää ei ole 
     * kirjattu pelatuksi
     */
    public int getScore(Level level) {
        if (scorecard.containsKey(level)) {
            return scorecard.get(level);
        } else {
            return -1;
        }
    }

}
