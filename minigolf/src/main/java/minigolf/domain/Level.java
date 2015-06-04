package minigolf.domain;

import java.util.ArrayList;

/**
 * Pelialuetta mallintava luokka, joka vastaa pelialueen ja siihen kuuluvien
 * objektien määrittämisestä
 * @author zesbr
 */
public class Level {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private Tee tee;
    private Hole hole;
    private ArrayList<Obstacle> obstacles;
    
    private final int WALL_THICKNESS = 20;
    
    public Level(int x, int y, int width, int height, Tee tee, Hole hole) {
        if (x < 0) {
          this.x = 0;  
        } else {
           this.x = x; 
        }
        if (y < 0) {
          this.y = 0;  
        } else {
           this.y = x; 
        }
        this.width = width;
        this.height = height;
        setTee(tee);
        setHole(hole); 
        this.obstacles = new ArrayList<>();
        buildWalls();
    }
    
    /**
     * Palauttaa kentän x-koordinaatin
     * @return x-koordinaatti
     */
    public int getX() {
        return x;
    }
    
    /**
     * Palauttaa kentän y-koordinaatin
     * @return y-koordinaatti
     */
    public int getY() {
        return y;
    }
    
    /**
     * Palauttaa kentän leveyden
     * @return leveys
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Palauttaa kentän korkeuden
     * @return korkeus
     */
    public int getHeight() {
        return height;
    }

    /**
     * Palauttaa kentän aloituspaikan
     * @return aloituspaikka
     */
    public Tee getTee() {
        return tee;
    }
    
    /**
     * Asettaa kentälle uuden aloituspaikan
     * @param tee : aloituspaikka
     */
    public void setTee(Tee tee) {
        if (!isOutOfBounds(tee.getX(), tee.getY())) {
            if (hole != null) {
                if (!hole.withinDistance(tee.getX(), tee.getY(), 200)) {
                    this.tee = tee;
                }
            } else {
               this.tee = tee; 
            }
        }
    }
    
    /**
     * Palautttaa kentän reiän
     * @return reikä
     */
    public Hole getHole() {
        return hole;
    }
    
    /**
     * Asettaa kentälle uuden reiän
     * @param hole : eikä
     */
    public void setHole(Hole hole) {
        if (!isOutOfBounds(hole.getX(), hole.getY())) {
            if (tee != null) {
                if (!hole.withinDistance(tee.getX(), tee.getY(), 200)) {
                    this.hole = hole;
                }
            } else {
               this.hole = hole; 
            }
        }
    }
    
    /**
     * Palauttaa listan kentän esteistä
     * @return estelista
     */
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
    
    /**
     * Lisää uuden esteen kentän estelistaan
     * @param obstacle : este
     */
    public void addObstacle(Obstacle obstacle) {
        this.obstacles.add(obstacle);
    } 
    
    /**
     * Tarkistaa onko koordinaatti pelialueen ulkopuolella ja palauttaa totuusarvon
     * @param x : x-koordinaatti
     * @param y : y-koordinaatti
     * @return totuusarvo oliko piste pelialueen ulkopuolella (true) vai sisäpuolella (false)
     */
    public boolean isOutOfBounds(int x, int y) {
        if (x < this.x || x > (this.x + this.width) || y < this.y || y > (this.y + this.height)) {
            return true;
        }
        return false;
    }
    
    /**
     * Tarkistaa onko pallo reiässä ja palauttaa totuusarvon
     * @param ball : pelissä oleva pallo
     * @return totuusarvo, onko pallo reiässä (true) vai ei (false)
     */
    public boolean ballIsInHole(Ball ball) {
        // Tarkistaa onko pallon keskipiste reiän kehän sisällä
        if (hole.inHole(ball.getCenterX(), ball.getCenterY())) { 
            // Tarkistaa onko pallon nopeus liian suuri upotakseen reikään
            if (ball.getSpeed() < 300) { 
                System.out.println("Pallo on reiässä!");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tarkistaa osuuko pallo johonkin kentän esteeseen ja palauttaa totuusarvon
     * @param ball : pallo
     * @return totuusarvo, osuuko pallo esteeseen (true) vai ei (false)
     */
    public boolean ballHitsObstacle(Ball ball) {
        for (Obstacle obstacle : obstacles) {      
            if (obstacle.hits(ball)) {
                System.out.println("TÖRMÄYS!");
                return true;
            }
        }
        return false;
    }
    
    // Rakentaa pelialuetta ympäröivät seinät uusina esteinä ja lisää ne estelistaan
    private void buildWalls() {
        
        // Määritetään seinien koordinaatit apumuuttujiin
        int topLeftX = x;
        int topLeftY = y;
        int topRightX = x + width - WALL_THICKNESS;
        int topRightY = y;
        int bottomLeftX = x;
        int bottomLeftY = x + height - WALL_THICKNESS;
        int bottomRightX = x + width + WALL_THICKNESS;
        int bottomRightY = y + height;
        
        // Rakentaa yläseinän
        addObstacle(new Obstacle(topLeftX, topLeftY, width, WALL_THICKNESS));

        // Rakentaa alaseinän
        addObstacle(new Obstacle(bottomLeftX, bottomLeftY, width, WALL_THICKNESS));
        
        // Rakentaa vasemman seinän
        addObstacle(new Obstacle(topLeftX, (topLeftY + WALL_THICKNESS), WALL_THICKNESS, (height - (2 * WALL_THICKNESS))));
        
        // Asettaa oikean seinän
        addObstacle(new Obstacle(topRightX, (topRightY + WALL_THICKNESS), WALL_THICKNESS, (height - (2 * WALL_THICKNESS))));
    }
    
}