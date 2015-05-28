package minigolf.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HoleTest {
    
    Hole hole;
    
    public HoleTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        hole = new Hole(100, 100);
    }
    
    @After
    public void tearDown() { }

    @Test
    public void getMethodForHoleCoordinatesWork() {
        int x = hole.getX();
        int y = hole.getY();
        
        assertEquals(100, x);
        assertEquals(100, y);
    }

    @Test
    public void setMethodForHoleCoordinatesWork() {
        hole.setX(0);
        hole.setY(0);
        
        int x = hole.getX();
        int y = hole.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    @Test
    public void holeCannotBeConstructedWithNegativeCoordinates() {
        hole = new Hole(-100, -100);
        
        int x = hole.getX();
        int y = hole.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    @Test
    public void setMethodsDoesNotAcceptNegativeCoordinates() {
        hole.setX(-100);
        hole.setY(-100);
        
        int x = hole.getX();
        int y = hole.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    @Test
    public void holeCannotBeConstuctedWithCoordinatesThatAreOutsideOfLevelBorders() {
        // TODO: Kuuluuko tämä testi LevelTest luokkaan?
    }
    

}
