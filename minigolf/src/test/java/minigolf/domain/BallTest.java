package minigolf.domain;

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
        float x = ball.getX();
        float y = ball.getY();
        
        assertEquals(10, x, 0.0);
        assertEquals(10, y, 0.0);
    }
    
    @Test
    public void setMethodsForBallCoordinatesWork() {
        ball.setX(20);
        ball.setY(20);
        
        float x = ball.getX();
        float y = ball.getY();
        
        assertEquals(20, x, 0.0);
        assertEquals(20, y, 0.0);
    }
    
    @Test
    public void allowsNegativeCoordinates() { 
        ball.setX(Integer.MIN_VALUE);
        ball.setY(Integer.MIN_VALUE);
        
        float x = ball.getX();
        float y = ball.getY();
        
        assertEquals(Integer.MIN_VALUE, x, 0.0);
        assertEquals(Integer.MIN_VALUE, y, 0.0);
    }
    
    @Test
    public void allowsCoordinatesThatExceedScreenSpace() { 
        ball.setX(10000);
        ball.setY(10000);
        
        float x = ball.getX();
        float y = ball.getY();
        
        assertEquals(10000, x, 0.0);
        assertEquals(10000, y, 0.0);
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
        
        assertEquals(1000, speed, 0.0);
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
    
    @Test
    public void ballRadiusIsTen() { 
        int radius = ball.getRadius();
        
        assertEquals(10, radius);
    }
    
    @Test
    public void ballDiameterIsTwenty() { 
        int diameter = ball.getDiameter();
        
        assertEquals(20, diameter, 0.0);
    }
    
    @Test
    public void ballCenterIsCorrect() {
        int centerX = ball.getCenterX();
        int centerY = ball.getCenterY();
        
        assertEquals(20, centerX);
        assertEquals(20, centerY);
        
    }

}
