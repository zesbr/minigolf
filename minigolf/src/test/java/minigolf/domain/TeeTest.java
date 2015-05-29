package minigolf.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeeTest {
    
    private Tee tee;
    
    public TeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tee = new Tee(100, 100);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getMethodForTeeCoordinatesWork() {
        int x = tee.getX();
        int y = tee.getY();
        
        assertEquals(100, x);
        assertEquals(100, y);
    }

    @Test
    public void setMethodForTeeCoordinatesWork() {
        tee.setX(0);
        tee.setY(0);
        
        int x = tee.getX();
        int y = tee.getY();
        
        assertEquals(0, x);
        assertEquals(0, y);
    }
}
