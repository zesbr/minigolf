/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minigolf.domain;

import java.util.HashMap;

/**
 *
 * @author jesruuth
 */
public class ScoreCard {
    
    private HashMap<Level, Integer> scorecard;
    
    public ScoreCard() {
        this.scorecard = new HashMap<>();
    }
    
    public void addScore(Level level, int score) {
        this.scorecard.put(level, score);
    }
    
    
    public int getScore(Level level) {
        return scorecard.get(level);
    }
    
}
