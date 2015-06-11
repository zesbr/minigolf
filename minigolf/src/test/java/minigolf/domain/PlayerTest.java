package minigolf.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    
    private Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.player = new Player("");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void setAndGetBallWork() {
        Ball expected = new Ball(0, 0);
        player.setBall(expected);
        Ball actual = player.getBall();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void initialStrikesIsZero() {
        int strikes = player.getStrikes();
        
        assertEquals(0, strikes);
    }
    
    @Test
    public void puttingSetsNewSpeedAndAngleToBallAndIncrementsStrikes() {
        player.setBall(new Ball(0,0));
        player.put(100.0, 90.0);
        Ball ball = player.getBall();
        
        assertEquals(100.0, ball.getSpeed(), 0.0);
        assertEquals(90.0, ball.getAngle(), 0.0);
        assertEquals(1, player.getStrikes());
    }
    
    @Test
    public void initStrikesSetsStrikesToZero() {
        player.setBall(new Ball(0, 0));
        player.put(1, 1);
        player.put(1, 1);
        player.initStrikes();
        int strikes = player.getStrikes();
        
        assertEquals(0, strikes);
    }
    
    @Test
    public void getNameReturnsPlayersName() {
        String expected = "Player 1";
        player = new Player(expected);
        String actual = player.getName();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void scoreCanBeAddedToScoreCard() {
        Level level = new Level(0, 0, 800, 600, new Tee(0, 0), new Hole(0, 0), "1");
        player.addScore(level, 3);
        int actual = player.getScore(level);
        
        assertEquals(3, actual);
    }

    @Test
    public void returnsMinusOneWhenAskedForScoreForLevelThatPlayerHasNotPlayed() {
        Level level = new Level(0, 0, 800, 600, new Tee(0, 0), new Hole(0, 0), "1");
        int actual = player.getScore(level);
        
        assertEquals(-1, actual);
    }
    
    @Test
    public void cannotAddScoreToNullLevel() {
        player.addScore(null, 3);
        int actual = player.getScore(null);
        
        assertEquals(-1, actual);
    }
    
    @Test
    public void cannotAddScoreForLevelThatIsNotIncludedInGame() {
        // TODO
    }
    
    @Test
    public void puttingSpeedMustBeMoreThanZero() {
        // TODO
    }
    
    @Test
    public void puttingSpeedMustBeLessThanOrEqualToThousand() {
        // TODO
    }
    
    @Test
    public void puttingAngleMustBetMoreThanOrEqualToMinusOneHundredAndEighty() {
        // TODO
    }
    
    @Test
    public void puttingAngleMustBetLessThanOrEqualToOneHundredAndEighty() {
        // TODO
    }

}
