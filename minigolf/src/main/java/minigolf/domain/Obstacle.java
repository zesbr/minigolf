package minigolf.domain;

/**
 * Pelikentän estettä mallintava luokka, jonka tehtävä on huolehtia esteen
 * ulottuvuuksista sekä esteeseen törmäyksen tunnistamisesta
 * @author zesbr
 */
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
     * @return leveys
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Palauttaa esteen korkeuden
     * @return korkeus
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Palauttaa esteen ylälaidan y-koordinaatin
     * @return ylälaidan y-koordinaatti
     */
    public int getTopSideY() {
        return getY();
    }
    
    /**
     * Palauttaa esteen oikean laidan x-koordinaatin
     * @return oikean laidan x-koordinaatti
     */
    public int getRightSideX() {
        return getX() + getWidth();
    }
    
    /**
     * Palauttaa esteen alalaidan y-koordinaatin
     * @return alalaidan y-koordinaatti
     */
    public int getBottomSideY() {
        return getY() + getHeight();
    }
    
    /**
     * Palauttaa esteen vasemman laidan x-koordinaatin
     * @return vasemman laidan x-koordinaatti
     */
    public int getLeftSideX() {
        return getX();
    }
    
    /**
     * Tarkistaa onko piste esteen rajojen sisällä ja palauttaa totuusarvon
     * @param x : pisteen x-koordinaatti
     * @param y : pisteen y-koordinaatti
     * @return totuusarvo onko piste esteen rajojen sisällä (true) vai ulkopuolella (false)
     */
    public boolean inside(int x, int y) {
        if (x < getLeftSideX() || x > getRightSideX() || y < getTopSideY() || y > getBottomSideY()) {
            return false;
        }
        return true;
    }
    
    /**
     * Tarkistaa osuuko pallo esteeseen ja kutsuu palloa päivittämään törmäyksen 
     * aiheuttaman muutoksen pallon liikerataan, sekä palauttaa totuusarvon
     * @param ball : pallo
     * @return totuusarvo, osuuko pallo esteeseen (true) vai ei (false)
     */ 
    public boolean hits(Ball ball) {
        // Tarkistaa osuuko pallo esteen laitoihin tai jos ei osu, niin osuuko sen kulmiin
        if (hitsSides(ball)) {
            return true;
        } else if (hitsCorners(ball)) {
            return true;
        }
        return false;
    }
    
    /**
     * Tarkistaa osuuko pallo esteen laitoihin ja palauttaa totuusarvon
     * @param ball : pallo
     * @return totuusarvo, osuuko pallo esteen laitoihin (true) vai ei (false)
     */
    public boolean hitsSides(Ball ball) {
        boolean hits = false;
        if (hitsTopsSide(ball.getBottomX(), ball.getBottomY())) {
            ball.calculateAngleFromVerticalCollision();
            hits = true;
        }
        if (hitsRightSide(ball.getLeftX(), ball.getLeftY())) {
            ball.calculateAngleFromHorizontalCollision();
            hits = true;
        }
        if (hitsBottomSide(ball.getTopX(), ball.getTopY())) {
            ball.calculateAngleFromVerticalCollision();
            hits = true;
        }
        if (hitsLeftSide(ball.getRightX(), ball.getRightY())) {
            ball.calculateAngleFromHorizontalCollision();
            hits = true;
        }
        return hits;
    }
    
    /**
     * Tarkistaa osuuko pallo esteen kulmiin ja palauttaa totuusarvon
     * @param ball : pallo
     * @return totuusarvo, osuuko pallo kulmaan (true) vai ei (false)
     */
    public boolean hitsCorners(Ball ball) { 
        // Tarkistaa osuuko pallo esteen vasempaan yläkulmaan
        if (hitsTopLeftCorner(ball)) {
            //ball.calculateAngleFromCornerCollision(getLeftSideX(), getTopSideY());
            ball.calcualateAngleFromTopLeftCollision();
            return true;
        }
        // Tarkistaa osuuko pallo esteen oikeaan yläkulmaan
        if (hitsTopRightCorner(ball)) {
            // ball.calculateAngleFromCornerCollision(getRightSideX(), getTopSideY());
            ball.calcualateAngleFromTopRightCollision();
            return true;
        }
        // Tarkistaa osuuko pallo esteen oikeaan alakulmaan
        if (hitsBottomRightCorner(ball)) {
            // ball.calculateAngleFromCornerCollision(getRightSideX(), getBottomSideY());
            ball.calcualateAngleFromBottomRightCollision();
            return true;
        }
        // Tarkistaa osuuko pallo esteen vasempaan alakulmaan
        if (hitsBottomLeftCorner(ball)) {
            // ball.calculateAngleFromCornerCollision(getLeftSideX(), getBottomSideY());
            ball.calcualateAngleFromBottomLeftCollision();
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko pallo esteen yläreunaan
    private boolean hitsTopsSide(int x, int y) {
        if (x >= getX() && x <= getX() + getWidth() && y == getY()) {
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko pallo esteen oikeaan laitaan
    private boolean hitsRightSide(int x, int y) {
        if (y >= getY() && y <= getY() + getHeight() && x == getX() + getWidth()) {
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko piste esteen alalaitaan
    private boolean hitsBottomSide(int x, int y) {  
        if (x >= getX() && x <= getX() + getWidth() && y == getY() + getHeight()) {
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko pallo esteen vasempaan
    private boolean hitsLeftSide(int x, int y) {
        if (y >= getY() && y <= getY() + getHeight() && x == getX()) {
            return true;
        }
        return false; 
    }
    
    // Tarkistaa osuuko pallo esteen vasempaan yläkulmaan
    private boolean hitsTopLeftCorner(Ball ball) {
        if (ball.hits(getLeftSideX(), getTopSideY())) {
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko pallo esteen oikeaan yläkulmaan
    private boolean hitsTopRightCorner(Ball ball) {
        if (ball.hits(getRightSideX(), getTopSideY())) {
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko pallo esteen oikeaan alakulmaan
    private boolean hitsBottomRightCorner(Ball ball) {
        if (ball.hits(getRightSideX(), getBottomSideY())) {
            return true;
        }
        return false;
    }
    
    // Tarkistaa osuuko pallo esteen vasempaan alakulmaan
    private boolean hitsBottomLeftCorner(Ball ball) {
        if (ball.hits(getLeftSideX(), getBottomSideY())) {
            return true;
        }
        return false;
    }

}