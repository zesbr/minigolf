package minigolf.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LevelTest {
    
    private Level level;
    
    public LevelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        level = new Level(0, 0, 800, 600);
    }
    
    @After
    public void tearDown() {
    }
  
    @Test
    public void getMethodsForLevelCoordinatesWork() {
        int x = level.getX();
        int y = level.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    @Test
    public void levelCannotBeConstructedWithNegativeCoordinates() {
        level = new Level(-10, -10, 800, 600);
        int x = level.getX();
        int y = level.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    @Test
    public void teeCannotBeSetOutsideLevelBorders() {
        level.setTee(new Tee(10000, 10000));
        
        assertEquals(null, level.getTee());
    }
    
    @Test
    public void holeCannotBeSetOutsideLevelBorders() {
        level.setHole(new Hole(10000, 10000));
        
        assertEquals(null, level.getHole()); 
    }
    
    @Test
    public void teeAndHoleMustBeMoreThanTwoHundredPixelsAwayFromEachOther() {
        Level level1 = new Level(0, 0, 800, 600);
        Level level2 = new Level(0, 0, 800, 600);
        
        level1.setHole(new Hole(10, 10));
        level1.setTee(new Tee(20, 20));
 
        level2.setTee(new Tee(10, 10));
        level2.setHole(new Hole(20, 20));
        
        assertEquals(null, level1.getTee());
        assertEquals(null, level2.getHole());
    }
    
    @Test
    public void obstacleAndTeeMustBeMoreThanTwentyPixelsAwayFromEachOther() {
        // TODO   
    }
    
    @Test
    public void obstacleAndHoleMustBeMoreThanTwentyPixelsAwayFromEachOther() {
        // TODO 
    }
    
}
