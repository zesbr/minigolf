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
    public void checkingIfCoordinateIsInsideObstacleBordersWork() {
        assertEquals(true, obstacle.inside(150, 110));
        assertEquals(false, obstacle.inside(500, 500));
    }
    
}
