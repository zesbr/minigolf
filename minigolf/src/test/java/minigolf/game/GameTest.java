package minigolf.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import minigolf.domain.Ball;
import minigolf.domain.Hole;
import minigolf.domain.Level;
import minigolf.domain.LevelArchitect;
import minigolf.domain.Player;
import minigolf.domain.Tee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    private Game game;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.game = new Game();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void byDefaultGameIsInitializedWithNineHoles() {
        ArrayList<Level> levels = game.getAllLevels();
        
        assertEquals(9, levels.size());
    }
    
    @Test
    public void byDefaultGameIsInitializedWithSinglePlayer() {
        ArrayDeque<Player> players = game.getAllPlayers();
        
        assertEquals(1, players.size());
    }
    
    @Test
    public void gameCanBeInitializedWithSinglePlayer() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        Player p1 = new Player("Player 1");    
        players.add(p1);
        
        game = new Game(players);
        players = game.getAllPlayers();
        
        assertEquals(1, players.size());
    }
    
    @Test
    public void gameCanBeInitializedWithMultiplePlayers() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");      
        players.add(p1);
        players.add(p2);
        
        game = new Game(players);
        players = game.getAllPlayers();
        
        assertEquals(2, players.size());
    }
    
    @Test
    public void gameCannotBeInitializedWithNoPlayers() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        game = new Game(players);
        players = game.getAllPlayers();
        
        assertEquals(1, players.size());
    }
    
    @Test
    public void gameCannotBeInitializedWithMoreThanEightPlayers() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) {
            players.add(new Player("Player " + i));
        }
        game = new Game(players);
        players = game.getAllPlayers();
        
        assertEquals(8, players.size());
    }
    
    @Test
    public void gameCanBeInitializedWithASingleLevel() {
        ArrayList<Level> levels = new ArrayList<>();
        Level level = new Level(0, 0, 800, 600, new Tee(800,600), new Hole(0,0), "1");
        levels.add(level);
        game = new Game(levels);
        levels = game.getAllLevels();
        
        assertEquals(1, levels.size());
    }
    
    @Test
    public void gameCanBeInitializedWithMultipleLevels() {
        ArrayList<Level> levels = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            Level level = new Level(0, 0, 800, 600, new Tee(800,600), new Hole(0,0), "" + i);
            levels.add(level);
        }
        
        game = new Game(levels);
        levels = game.getAllLevels();
        
        assertEquals(9, levels.size());
    }
    
    @Test
    public void gameCannotBeInitializedWithMoreThanNineLevels() {
        ArrayList<Level> levels = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            Level level = new Level(0, 0, 800, 600, new Tee(800,600), new Hole(0,0), "" + i);
            levels.add(level);
        }
        
        game = new Game(levels);
        levels = game.getAllLevels();
        
        assertEquals(9, levels.size());
    }
    
    @Test
    public void gameCannotBeInitializedWithNoLevels() {
        ArrayList<Level> levels = new ArrayList<>();
        game = new Game(levels);
        levels = game.getAllLevels();
        
        assertEquals(9, levels.size());
    }
    
    @Test
    public void inTheBeginningAllLevelsAreInUnfinishedDeque() {
        ArrayDeque<Level> unfinishedLevels = game.getUnfinishedLevels();
        
        assertEquals(9, unfinishedLevels.size());
    }
    
    @Test
    public void getCurrentLevelReturnsCorrectLevelInTheBeginning() {
        Level expected = LevelArchitect.buildLevel(1);
        Level actual = game.getCurrentLevel();
        
        assertEquals(expected.getName(), actual.getName());
    }
    
    @Test
    public void getCurrentPlayerReturnsCorrectPlayerInTheBeginning() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        Player expected = new Player("Player 1");
        players.add(expected);
        game = new Game(players);
        
        Player actual = game.getActivePlayer();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void switchingLevelRemovesLevelFromDequeOfUnifinishedLevels() {
        game.switchLevel();
        ArrayDeque<Level> lvls = game.getUnfinishedLevels();
        
        assertEquals(8, game.getUnfinishedLevels().size());
    }
    
    @Test
    public void switchingLevelsDoesNotRemoveLevelsFromListOfAllLevels() {
        game.switchLevel();
        ArrayList<Level> levels = game.getAllLevels();
        
        assertEquals(9, levels.size());
    }
    
    @Test
    public void switchingLevelReturnsTheNewCurrentLevel() {
        Level expected = LevelArchitect.buildLevel(2);
        Level actual = game.switchLevel();
        
        assertEquals(expected.getName(), actual.getName());
    }
    
    @Test
    public void getCurrentLevelReturnsCorrectLevelAfterEachHole() {
        for (int i = 2; i <= 9; i++) {
            Level expected = LevelArchitect.buildLevel(i);
            game.switchLevel();
            Level actual = game.getCurrentLevel();
        
            assertEquals(expected.getName(), actual.getName());
        }
    }
    
    @Test
    public void switchingLevelReturnsNullAfterFinalLevelHasBeenPlayed() {
        for (int i = 2; i <= 9; i++) {
            game.switchLevel();
        }
        Level actual = game.switchLevel();
        assertEquals(null, actual);
    }
    
    @Test
    public void getActiveBallReturnsTheBallOfCurrentPlayer() {
        Player player = game.getActivePlayer();
        Ball expected = player.getBall();
        Ball actual = game.getActiveBall();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void allBallsAreOnTeeInTheBeginningOfEachHole() {
        ArrayList<Ball> balls = new ArrayList<>();
        ArrayDeque<Player> players = new ArrayDeque<>();
        for (int i = 1; i <= 8; i++) {
            players.add(new Player("" + i));
        }
        game = new Game(players);
        Tee tee = game.getCurrentLevel().getTee();
        for (Ball ball : balls) {
            int ballX = (int) ball.getX();
            int ballY = (int) ball.getY();
            
            assertEquals(ballX, tee.getX());
            assertEquals(ballY, tee.getY());
        }
    } 
    
    @Test
    public void switchingPlayerReturnsTheNewCurrentPlayer() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        Player p1 = new Player("Player 1");
        Player expected = new Player("Player 2");
        players.add(p1);
        players.add(expected);
        game = new Game(players);
        game.switchPlayer();
        Player actual = game.getActivePlayer();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void switchingPlayerDoesNotRemovePlayer() {
        ArrayDeque<Player> players = new ArrayDeque<>();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        players.add(p1);
        players.add(p2);
        game = new Game(players);
        game.switchPlayer();
        players = game.getAllPlayers();
        
        assertEquals(2, players.size());
    }
    
    @Test
    public void levelCannotBeSwitchedUntilAllPlayersHaveFinishedTheLevel() {
        // TODO
    }
    
    @Test
    public void playersAreInCorrectOrderAfterHoleIsFinished() {
        // TODO
    }
    
    @Test
    public void playerCannotPlayTheSameHoleTwice() {
        // TODO
    }   
    
}