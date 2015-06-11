package minigolf.domain;

/**
 * Pelikentän reikää mallintava luokka jonka tehtävä on huolehtia reiän sijaintiin
 * liittyvistä palveluista
 * @author zesbr
 */
public class Hole extends LevelObject {
    
    private final int RADIUS = 15;
    private final int DIAMETER = RADIUS * 2;
    
    public Hole(int x, int y) {
        super(x, y);
    }
    
    /**
     * Palauttaa reiän säteen
     * @return säde
     */
    public int getRadius() {
        return RADIUS;
    }

    /**
     * Palauttaa reiän halkaisijan
     * @return halkaisija
     */
    public int getDiameter() {
        return DIAMETER;
    }
    
    /**
     * Palautaa reiän keskipisteen x-koordinaatin
     * @return x-koordinaatti
     */
    public int getCenterX() {
        return getX() + RADIUS;
        
    }
    
    /**
     * Palautaa reiän keskipisteen y-koordinaatin
     * @return y-koordinaatti
     */
    public int getCenterY() {
        return getY() + RADIUS;
    }
    
    /**
     * Tarkistaa onko piste reiän sisällä
     * @param x : pisteen x-koordinaatti
     * @param y : pisteen y-koordinaatti
     * @return totuusarvo onko piste reiän kehän sisäpuolellea (true) vai ulkopuolella (false)
     */
    public boolean inHole(int x, int y) {
        return withinDistance(x, y, RADIUS);
    }
    
    /**
     * Tarkistaa onko piste tietyn etäisyyden päässä reiästä
     * @param x : pisteen x-koordinaatti
     * @param y : pisteen y-koordinaatti
     * @param distance : tarkistusalueen säde eli etäisyys reiän keskipisteestä
     * @return totuusarvo onko piste etäisyyden päässä reiän keskipisteessä (true) vai ei (false)
     */
    public boolean withinDistance(int x, int y, int distance) {
        if (Math.pow(x - getCenterX(), 2) + Math.pow(y - getCenterY(), 2) < Math.pow(distance, 2)) {
            return true;
        }
        return false;
    }
   
}