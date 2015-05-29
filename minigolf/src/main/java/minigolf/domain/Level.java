package minigolf.domain;

import java.util.ArrayList;

public class Level {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private Tee tee;
    private Hole hole;
    private ArrayList<Obstacle> obstacles;
    
    public Level(int x, int y, int width, int height) {
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
        this.tee = null;
        this.hole = null;
        this.obstacles = new ArrayList<>();
    }
    
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
        this.tee = tee;
        this.hole = hole;
        this.obstacles = new ArrayList<>();
    }
    
    /**
     * Palauttaa kentän x-koordinaatin
     * @return int : kentän x-koordinaatti
     */
    public int getX() {
        return x;
    }
    
    /**
     * Palauttaa kentän y-koordinaatin
     * @return int : kentän y-koordinaatti
     */
    public int getY() {
        return y;
    }
    
    /**
     * Palauttaa kentän leveyden
     * @return int : kentän leveys
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Palauttaa kentän korkeuden
     * @return int : kentän korkeus
     */
    public int getHeight() {
        return height;
    }

    /**
     * Palauttaa kentän aloituspaikan
     * @return Tee : kentän aloituspaikka
     */
    public Tee getTee() {
        return tee;
    }
    
    /**
     * Palautttaa kentän reiän
     * @return Hole : kentän reikä
     */
    public Hole getHole() {
        return hole;
    }

    /**
     * Palauttaa listan kentän esteistä
     * @return ArrayList : lista kentän esteistä
     */
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
    
    /**
     * Asettaa kentälle uuden aloituspaikan
     * @param tee : kentän uusi aloituspaikka
     */
    public void setTee(Tee tee) {
        if (!isOutOfBounds(tee.getX(), getY())) {
            if (hole != null) {
                if (!hole.withinRadius(tee.getX(), tee.getY(), 200)) {
                    this.tee = tee;
                }
            } else {
               this.tee = tee; 
            }
        }
    }

    /**
     * Asettaa kentälle uuden reiän
     * @param hole : kentön uusi reikä
     */
    public void setHole(Hole hole) {
        if (!isOutOfBounds(hole.getX(), hole.getY())) {
            if (tee != null) {
                if (!hole.withinRadius(tee.getX(), tee.getY(), 200)) {
                    this.hole = hole;
                }
            } else {
               this.hole = hole; 
            }
        }
    }

    /**
     * Lisää uuden esteen kentän esteiden listaan
     * @param obstacle : kentän uusi este
     */
    public void addObstacle(Obstacle obstacle) {
        this.obstacles.add(obstacle);
    } 
    
    /**
     * Tarkistaa onko koordinaatti pelialueen sisällä ja palauttaa totuusarvon
     * @param x : x-koordinaatti
     * @param y : y-koordinaatti
     * @return boolean : true jos ulkopuolella ja muuten false
     */
    public boolean isOutOfBounds(int x, int y) {
        if (x < this.x || x > (this.x + this.width) || y < this.y || y > (this.y + this.height)) {
            return true;
        }
        return false;
    }
    
    /**
     * Asettaa kenttää ympäröivät seinät kentän pinta-alan perusteella
     */
    public void setWalls() {
        
        // Määritetään seinien paksuus ja koordinaatit muuuttujiien
        int wallThickness = 20; // TODO: Aseta kentän attribuutiksi
        int topLeftX = x;
        int topLeftY = y;
        int topRightX = x + width - wallThickness;
        int topRightY = 0;
        int bottomLeftX = 0;
        int bottomLeftY = 0 + height - wallThickness;
        int bottomRightX = x + width + wallThickness;
        int bottomRightY = y + height;
        
        // Rakentaa yläreunan
        addObstacle(new Obstacle(topLeftX, topLeftY, width, wallThickness));

        // Rakentaa alareunan
        addObstacle(new Obstacle(bottomLeftX, bottomLeftY, width, wallThickness));
        
        // Rakentaa vasemman reunan
        addObstacle(new Obstacle(topLeftX, (topLeftY + wallThickness), wallThickness, (height - (2 * wallThickness))));
        
        // Asettaa oikean reunan
        addObstacle(new Obstacle(topRightX, (topRightY + wallThickness), wallThickness, (height - (2 * wallThickness))));
    }
    
}