package minigolf.domain;

/**
 * Kenttäsuunnittelija vastaa kenttien luomisesta.
 * @author jesruuth
 */
public class CourseArchitect {
    
    public CourseArchitect() {
        
    }
    
    public Level buildLevel01() {    
        Level level = new Level(0, 0, 800, 600, new Tee(400, 550), new Hole(400, 50));
        level.setWalls();
        level.addObstacle(new Obstacle(200, 200, 400, 20));
        return level;
    }
}
