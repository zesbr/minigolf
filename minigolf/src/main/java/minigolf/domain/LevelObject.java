package minigolf.domain;

public abstract class LevelObject {
    
    private int x;
    private int y;
    
    public LevelObject(int x, int y) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }   
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }
    
    /**
     * Palauttaa kenttä-objektin x-koordinaatin 
     * @return x-koordinaatti
     */
    public int getX() {
        return x;
    }

    /**
     * Palauttaa kenttä-objektin y-koordinaatin
     * @return y-koordinaatti 
     */
    public int getY() {
        return y;
    }
    
    /**
     * Asettaa kenttä-objektin x-koordinaatin, jonka on oltava suurempi kuin 0
     * @param x : x-koordinaatti
     */
    public void setX(int x) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }
    
    /**
     * Asettaa kenttä-objektin y-koordinaatin, jonka on oltava suurempi kuin 0
     * @param y : y-koordinaatti 
     */
    public void setY(int y) {
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }
     
}
