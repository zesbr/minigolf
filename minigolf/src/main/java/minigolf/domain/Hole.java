package minigolf.domain;

public class Hole extends LevelObject {
    
    private final int RADIUS = 20;
    private final int DIAMETER = RADIUS * 2;
    
    public Hole(int x, int y) {
        super(x, y);
    }
    
    /**
     * Palauttaa reiän säteen
     * @return int : reiän säde
     */
    public int getRadius() {
        return RADIUS;
    }

    /**
     * Palauttaa reiän halkaisijan
     * @return int : reiän halkaisija
     */
    public int getDiameter() {
        return DIAMETER;
    }
    
    /**
     * Palautaa reiän keskipistee x-koordinaatin
     * @return int : reiän keskipisteen x-koordinaatti
     */
    public int getCenterX() {
        return getX() + RADIUS;
        
    }
    
    /**
     * Palautaa reiän keskipistee y-koordinaatin
     * @return int : reiän keskipisteen y-koordinaatti
     */
    public int getCenterY() {
        return getY() + RADIUS;
    }
    
    /**
     * Tarkistaa onko koordinaatti reiän sisällä
     * @param x : x-koordinaatti
     * @param y : y-koordinaatti
     * @return boolean : true jos on ja false jos ei
     */
    public boolean inside(int x, int y) {
        return withinRadius(x, y, RADIUS);
    }
    
    /**
     * Tarkistaa onko koordinaatti tietyn etäisyyden päässä reistä
     * @param x : x-koordinaatti
     * @param y : y-koordinatti
     * @param radius : etäisyys
     * @return boolean : true jos on ja muuten false
     */
    public boolean withinRadius(int x, int y, int radius) {
        if (Math.pow(x - getCenterX(), 2) + Math.pow(y - getCenterY(), 2) < Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }
    
}