
import minigolf.domain.Ball;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BallTest {
    
    Ball ball;
    
    public BallTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        
        ball = new Ball(10, 10);
    }
    
    @After
    public void tearDown() { }
    
    @Test
    public void getMethodsForBallCoordinatesWork() {
    
        int x = ball.getX();
        int y = ball.getY();
        
        assertEquals(10, x);
        assertEquals(10, y);
    
    }
    
    @Test
    public void setMethodsForBallCoordinatesWork() {
    
        ball.setX(20);
        ball.setY(20);
        int x = ball.getX();
        int y = ball.getY();
        
        assertEquals(20, x);
        assertEquals(20, y);
    }
    
    @Test
    public void allowsNegativeCoordinates() { 
        
        ball.setX(Integer.MIN_VALUE);
        ball.setY(Integer.MIN_VALUE);
        int x = ball.getX();
        int y = ball.getY();
        
        assertEquals(Integer.MIN_VALUE, x);
        assertEquals(Integer.MIN_VALUE, y);
    
    }
    
    @Test
    public void allowsCoordinatesThatExceedScreenSpace() { 
        
        ball.setX(Integer.MAX_VALUE);
        ball.setY(Integer.MAX_VALUE);
        int x = ball.getX();
        int y = ball.getY();
        
        assertEquals(Integer.MAX_VALUE, x);
        assertEquals(Integer.MAX_VALUE, y);
    
    }
    
    @Test
    public void getMethodForBallSpeedWorkAndinitialBallSpeedIsZero() {
    
        double speed = ball.getSpeed();
        
        assertEquals(0.0, speed, 0.0);
        
    }
    
    @Test
    public void getMethodForBallAngleWorkAndinitialBallAngleIsZero() {
    
        double angle = ball.getAngle();
        
        assertEquals(0.0, angle, 0.0);
    }
    
    @Test
    public void setMethodForBallSpeedWork() {
    
        ball.setSpeed(100);
        
        double speed = ball.getSpeed();
        
        assertEquals(100, speed, 0.0);
    }
    
    @Test
    public void setMethodForBallAngleWork() {
    
        ball.setAngle(0.0); 
        double angle = ball.getAngle();
        
        assertEquals(0.0, angle, 0.0);
        
    }
    
    @Test
    public void ballSpeedMustBeLessThanThousand() {
        
        ball.setSpeed(Double.MAX_VALUE);
        double speed = ball.getSpeed();
        
        assertEquals(999.99, speed, 0.0);
    }
    
    @Test
    public void ballSpeedMustBeMoreThanOrEqualToZero() {
        
        ball.setSpeed(Integer.MIN_VALUE);
        double speed = ball.getSpeed();
        
        assertEquals(0.0, speed, 0.0);
    }
    
    @Test
    public void ballAngleMustBeMoreThanOrEqualToMinusOneHundredAndEighty() { 
        
        ball.setAngle(Integer.MIN_VALUE);      
        double angle = ball.getAngle();
  
        assertEquals(0.0, angle, 0.0);
    
    }
    
    @Test
    public void ballAngleMustBeLessThanOrEqualToOneHundredAndEighty() { 
        
        ball.setAngle(Double.MAX_VALUE);
        double angle = ball.getAngle();
        
        assertEquals(0.0, angle, 0.0);
    
    }
    
}
