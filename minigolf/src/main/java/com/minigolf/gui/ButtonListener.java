package com.minigolf.gui;

import com.minigolf.domain.Ball;
import com.minigolf.game.Minigolf;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ButtonListener implements ActionListener {

    private Minigolf minigolf;
    private int force;
    private int direction;
    private Component component;
    
    public ButtonListener(Minigolf minigolf, int force, int direction, Component component) {
        this.minigolf = minigolf;
        this.force = force;
        this.direction = direction;
        this.component = component;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Ball ball = this.minigolf.getBall();
        ball.calculateTrajectory(force, direction);
        component.repaint();
    }
    
}
