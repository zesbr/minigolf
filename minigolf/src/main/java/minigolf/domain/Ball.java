package minigolf.domain;

import minigolf.game.Game;
import minigolf.gui.GameCanvas;

/**
 * Liikkuvaa golfpalloa mallintava luokka, jonka tehtävä on huolehtia palloon 
 * ja sen liikkeeseen liittyvien palveluiden laskennasta
 * @author zesbr
 */
public class Ball {
    
    private float x;
    private float y;
    private double speed;
    private double angle;
    
    private final int RADIUS = 10;
    private final int DIAMETER = RADIUS * 2;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 0.0;
        this.angle = 0.0;
    }
    
    /**
     * Palauttaa pallon x-koordinaatin 
     * @return x-koordinaatti
     */
    public float getX() {
        return x;
    }
    
    /**
     * Asettaa pallolle uuden x-koordinaatin
     * @param x : x-koordinaatti
     */
    public void setX(float x) {
        this.x = x;
    }
    
    /**
     * Palauttaa pallon y-koordinaatin
     * @return y-koordinaatti
     */
    public float getY() {
        return y;
    }
     
    /**
     * Asettaa pallon uuden y-koordinaatin
     * @param y : y-koordinaatti
     */
    public void setY(float y) {
        this.y = y;
    }
    
    /**
     * Palauttaa pallon nopeuden
     * @return nopeus
     */
    public double getSpeed() {
        return speed;
    }
    
    /**
     * Asettaa pallolle uuden nopeuden
     * @param speed : nopeus
     */
    public void setSpeed(double speed) {
        if (speed > 1000) {
            this.speed = 1000;
        } else if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed; 
        }
    }
    
    /**
     * Palauttaa pallon kulman
     * @return kulma
     */
    public double getAngle() {
        return angle;
    }
    
    /**
     * Asetta pallolle uuden kulman
     * @param angle : kulma
     */
    public void setAngle(double angle) {
        if (angle >= -180 && angle <= 180) {
            this.angle = angle;
        }
    }
    
    /**
     * Palauttaa pallon säteen
     * @return säde
     */
    public int getRadius() {
        return RADIUS;
    }
    
    /**
     * Palauttaa pallon halkaisijan
     * @return halkaisija
     */
    public int getDiameter() {
        return DIAMETER;
    }
    
    /**
     * Palauttaa pallon keskipisteen x-koordinaatin
     * @return keskipisteen x-koordinaatti
     */
    public int getCenterX() {
        return (int) x + RADIUS;
        
    }
    
    /**
     * Palauttaa pallon keskipisteen y-koordinaatin
     * @return keskipisteen y-koordinaatti
     */
    public int getCenterY() {
        return (int) y + RADIUS;
    }
    
    /**
     * Palauttaa pallon yläreunan x-koordinaatin
     * @return yläreunan x-koordinaatti
     */
    public int getTopX() {
        return (int) x + RADIUS; 
    }
    
    /**
     * Palauttaa pallon yläreunan y-koordinaatin
     * @return yläreunan y-koordinaatti
     */
    public int getTopY() {
        return (int) y;
    }
    
    /**
     * Palauttaa pallon oikean reunan x-koordinaatin
     * @return oikean reunan x-koordinaatti
     */
    public int getRightX() {
        return (int) x + DIAMETER;
    }
    
    /**
     * Palauttaa pallon oikean reunan y-koordinaatin
     * @return oikean reunan y-koordinaatti
     */
    public int getRightY() {
        return (int) y + RADIUS;
    }
    
    /**
     * Palauttaa pallon alareunan x-koordinaatin
     * @return alareunan x-koordinaatti
     */
    public int getBottomX() {
         return (int) x + RADIUS;
    }
    
    /**
     * Palauttaa pallon alareunan y-koordinaatin
     * @return alareunan y-koordinaatti
     */
    public int getBottomY() {
         return (int) y + DIAMETER;
    }
    
    /**
     * Palauttaa pallon vasemman reunan x-koordinaatin
     * @return vasemman reunan x-koordinaatti
     */
    public int getLeftX() {
        return (int) x;
    }
    
    /**
     * Palauttaa pallon vasemman reunan y-koordinaatin
     * @return vasemman reunan y-koordinaatti
     */
    public int getLeftY() {
         return (int) y + RADIUS;
    }
    
    /**
     * Liikuttaa palloa
     * @param canvas : pelialusta
     */
    public void move(GameCanvas canvas) {
        // Haetaan pelialustan peli-instanssi
        Game game = canvas.getGame();
        // Haetaan nykyinen pelikenttä
        Level level = game.getCurrentLevel();
        // Laskee kuinka monta "steppiä" pallo siirtyy yhden ajastimen päivittymisen aikana
        int steps = (int) (getSpeed()) / 60;
        for (int i = 0; i <= steps; i++) {
            // Lasketaan ja asetetaan pallon uusi sijainti
            x = (float) (x + Math.cos(1.0 * Math.toRadians(angle)));
            y = (float) (y - Math.sin(1.0 * Math.toRadians(angle))); 
            // Vähennetään pallon nopeutta
            speed -= 0.75;
            // Tarkistaa onko pallo reiässä
            if (level.ballIsInHole(this)) {
                speed = 0; 
                x = level.getHole().getCenterX() - RADIUS;
                y = level.getHole().getCenterY() - RADIUS;
                break;
            }
            // Tarkistaa osuuko pallo esteeseen
            if (level.ballHitsObstacle(this)) { 
                
            }
        }
               
    }
    
    /**
     * Tarkistaa osuuko piste palloon eli onko se sen kehän sisällä ja 
     * palauttaa totuusarvon
     * @param x : pisteen x-koordinaatti
     * @param y : pisteen y-koordinaatti
     * @return totuusarvo, osuuko piste (true) vai ei (false)
     */
    public boolean hits(int x, int y) {
        if (Math.pow(x - getCenterX(), 2) + Math.pow(y - getCenterY(), 2) <= Math.pow(RADIUS, 2)) {
            return true;
        }
        return false;
    }
    
    /**
     * Laskee ja asettaa pallolle uuden kulman vertikaalisen törmäyksen johdosta.
     * Tätä kutsutaan jos pallon yläreuna osuu esteen alalaitaan tai jos pallon
     * alareuna osuu esteen ylälaitaan.
     */
    public void calculateAngleFromVerticalCollision() {
        angle = (angle * -1);
    }
    
    /**
     * Laskee ja asettaa pallolle uuden kulman horisontaalisen törmäyksen johdosta
     * Tätä kutsutaan jos pallon vasen reuna osuu esteen oikeean laitaan tai jos
     * pallon oikea reuna osuu esteen vasempaan laitaan.
     */
    public void calculateAngleFromHorizontalCollision() {
        if (angle > 90 && angle <= 180) {
            angle = (180 - angle);
        } else {
            angle = (-180 - angle);
        }
    }
    
    /**
     * Laskee ja asettaa pallon uuden kulman esteen kulmaan törmäämisen johdosta
     * TODO: Tämä ei laske vielä sinnepäinkään oikein
     * @param x : kulman x-koordinaatti
     * @param y : kulman y-koordinaatti
     */
    public void calculateAngleFromCornerCollision(int x, int y) {
        angle -= (double) Math.toDegrees(Math.atan2((this.y - getCenterY()), -(this.x - getCenterX())));
    }
    
    /**
     * Laskeen kulman pallon ja pisteen välillä ja palauttaa kulman suuruuden
     * @param x : pisteen x-koordinaatti
     * @param y : pisteen y-koordinaatti
     * @return : kulman arvo
     */
    public double getAngleToPoint(float x, float y) {
        float diffY = y - getCenterY();
        float diffX = getCenterX() - x;
        return (double) Math.toDegrees(Math.atan2(-diffY, -diffX));
    }
    
}