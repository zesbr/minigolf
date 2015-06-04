package minigolf.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObstacleTest {
    
    private Obstacle obstacle;
    
    public ObstacleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        obstacle = new Obstacle(100, 100, 100, 20);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getWidthWorks() {
        int width = obstacle.getWidth();
        
        assertEquals(100, width);
    }
    
    @Test
    public void getHeightWorks() {
        int height = obstacle.getHeight();
        
        assertEquals(20, height);
    }
    
    @Test
    public void getTopSideYWorks() {
        assertEquals(100, obstacle.getTopSideY());
    }
    
    @Test
    public void getRightSideXWorks() {
        assertEquals(200, obstacle.getRightSideX());
    }
    
    @Test
    public void getBottomSideYWorks() {
        assertEquals(120, obstacle.getBottomSideY());
    }
    
    @Test
    public void getLeftSideXWorks() {
        assertEquals(100, obstacle.getLeftSideX());
    }
    
    @Test
    public void checkingIfCoordinateIsInsideObstacleBordersWork() {
        assertEquals(true, obstacle.inside(150, 110));
        assertEquals(false, obstacle.inside(500, 500));
    }
    
    @Test
    public void collisionDetectionForTopSideCollisionWorks() {
        Ball trueBall = new Ball(140, 80);
        Ball falseBall = new Ball(140, 79);
        
        assertEquals(true, obstacle.hits(trueBall));
        assertEquals(false, obstacle.hits(falseBall));
    }
    
    @Test
    public void collisionDetectionForRightSideCollisionWorks() {
        Ball trueBall = new Ball(200, 100);     
        Ball falseBall = new Ball(200, 80);

        assertEquals(true, obstacle.hits(trueBall));
        assertEquals(false, obstacle.hits(falseBall));
    }
    
    @Test
    public void collisionDetectionForBottomSideCollisionWorks() {
        Ball trueBall = new Ball(140, 120);     
        Ball falseBall = new Ball(140, 121);
        
        assertEquals(true, obstacle.hits(trueBall));
        assertEquals(false, obstacle.hits(falseBall));
    }
    
    @Test
    public void collisionDetectionForLeftSideCollisionWorks() {
        Ball trueBall = new Ball(80, 100);     
        Ball falseBall = new Ball(79, 100);
        
        assertEquals(true, obstacle.hits(trueBall));
        assertEquals(false, obstacle.hits(falseBall));
    }
    
    @Test
    public void collisionDetectionForTopLeftCornerWorkWhenBallHitsCornersButNotSides() {
        Ball ball = new Ball(90, 90);
        
        assertEquals(false, obstacle.hitsSides(ball));
        assertEquals(true, obstacle.hitsCorners(ball));
    }
    
    @Test
    public void collisionDetectionForTopRightCornerWorkWhenBallHitsCornersButNotSides() {
        Ball ball = new Ball(190, 90);
        
        assertEquals(false, obstacle.hitsSides(ball));
        assertEquals(true, obstacle.hitsCorners(ball));
    }

    @Test
    public void collisionDetectionForBottomRightCornerWorkWhenBallHitsCornersButNotSides() {
        Ball ball = new Ball(190, 110);
        
        assertEquals(false, obstacle.hitsSides(ball));
        assertEquals(true, obstacle.hitsCorners(ball));
    }
    
    @Test
    public void collisionDetectionForBottomLeftCornerWorkWhenBallHitsCornersButNotSides() {
        Ball ball = new Ball(90, 110);
        
        assertEquals(false, obstacle.hitsSides(ball));
        assertEquals(true, obstacle.hitsCorners(ball));
    }
}
