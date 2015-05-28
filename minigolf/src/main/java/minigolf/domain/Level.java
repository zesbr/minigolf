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
    
    public Level(int x, int y, int width, int height, Tee tee, Hole hole) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tee = tee;
        this.hole = hole;
        this.obstacles = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tee getTee() {
        return tee;
    }

    public Hole getHole() {
        return hole;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTee(Tee tee) {
        this.tee = tee;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public void addObstacle(Obstacle obstacle) {
        this.obstacles.add(obstacle);
    } 
    
    public boolean isOutOfBounds(int x, int y) {
        if (x < this.x || x > (this.x + this.width) || y < this.y || y > (this.y + this.height)) {
            return true;
        }
        return false;
    }
    
    /**
     * Rakentaa pelialueelle reunat alueen koordinaattin ja koon perusteella.
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