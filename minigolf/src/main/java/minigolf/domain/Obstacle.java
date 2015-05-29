package minigolf.domain;

public class Obstacle extends LevelObject {
    
    private int width;
    private int height;

    public Obstacle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    
    /**
     * Palauttaa esteen leveyden
     * @return int : esteen leveys
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Palauttaa esteen korkeuden
     * @return int : esteen korkeus
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Tarkistaa onko koordinaatti esteen rajojen sisällä ja palauttaa totuusarvon
     * @param x : x-koordinaatti
     * @param y : y-koordinaatti
     * @return boolean : true jos on false jos ei
     */
    public boolean inside(int x, int y) {
        if (x < getX() || x > (getX() + this.width) || y < getY() || y > (getY() + this.height)) {
            return false;
        }
        return true;
    }
    
}