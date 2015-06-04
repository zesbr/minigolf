package minigolf.domain;

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

    public Player(String name) {
        this.name = name;
        this.strikes = 0;
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
     
}
