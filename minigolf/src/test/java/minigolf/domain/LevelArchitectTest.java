/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minigolf.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LevelArchitectTest {
    
    public LevelArchitectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void levelArchitectReturnsLevelWhenAskedForLevelThatExists() {
        for (int i = 1; i <= 9; i++) {
            Level lvl = LevelArchitect.buildLevel(i);
            boolean actual = lvl instanceof Level;
            
            assertEquals(true, actual);
        }
    }
    
    @Test
    public void levelArchitectReturnsNullWhenAskedForLevelThatDoesNotExists() {
        Level actual = LevelArchitect.buildLevel(-1);
        
        assertEquals(null, actual);
    }
}
