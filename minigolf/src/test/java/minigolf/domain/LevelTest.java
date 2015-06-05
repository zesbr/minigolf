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
        level = new Level(0, 0, 800, 600, new Tee(800,600), new Hole(0,0), "");
    }
    
    @After
    public void tearDown() {
    }
  
    @Test
    public void getMethodsForCoordinatesWork() {
        assertEquals(0, level.getX());
        assertEquals(0, level.getY());
    }
    
    @Test
    public void cannotBeBuiltWithNegativeCoordinates() {
        Level level = new Level(-100, -100, 800, 600, new Tee(0,0), new Hole(0,0), "");
        
        assertEquals(0, level.getX());
        assertEquals(0, level.getY());
    }
    
    @Test
    public void getWidthForLevelWorks() {
        assertEquals(800, level.getWidth());
    }
    
    @Test
    public void getHeightForLevelWorks() {
        assertEquals(600, level.getHeight());
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
        level = new Level(-10, -10, 800, 600, new Tee(0,0), new Hole(0,0), "");
        int x = level.getX();
        int y = level.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    @Test
    public void teeCannotBeSetOutsideLevelBorders() {
        level.setTee(new Tee(1000, 1000));
        
        assertEquals(800, level.getTee().getX());
        assertEquals(600, level.getTee().getY());
    }
    
    @Test
    public void holeCannotBeSetOutsideLevelBorders() {
        level.setHole(new Hole(1000, 1000));
        
        assertEquals(0, level.getHole().getX()); 
        assertEquals(0, level.getHole().getY()); 
    }
    
    @Test
    public void teeAndHoleMustBeMoreThanTwoHundredPixelsAwayFromEachOther() {
        // TODO
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
