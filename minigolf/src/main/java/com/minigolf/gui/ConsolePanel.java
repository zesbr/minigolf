package com.minigolf.gui;

import com.minigolf.domain.Ball;
import com.minigolf.game.Minigolf;
import javax.swing.*;

public class ConsolePanel extends JPanel {   
    
    private Minigolf minigolf;
    
    public ConsolePanel(Minigolf minigolf) {
        super();
        this.minigolf = minigolf;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);
        addComponents();
    }
    
    private void addComponents() {   
        
        Ball ball = minigolf.getBall();
        
        JLabel ballXOutput = new JLabel("ballXPos: " + ball.getX());
        add(ballXOutput);

        JLabel ballYOutput = new JLabel("ballYPos: " + ball.getY());
        add(ballYOutput);
        
        JLabel ballSpeedOutput = new JLabel("ballSpeed: null");
        add(ballSpeedOutput);
        
        JLabel ballDirectionOutput = new JLabel("ballDirection: null");
        add(ballDirectionOutput);
        
    }  
}