package com.minigolf.gui;

import com.minigolf.game.Minigolf;
import java.awt.*;
import javax.swing.*;

public class HeadsUpDisplayPanel extends JPanel {
    
    private Minigolf minigolf;
    private CanvasPanel canvas;
    
    public HeadsUpDisplayPanel(Minigolf minigolf, CanvasPanel canvas) {
        super();
        this.minigolf = minigolf;
        this.canvas = canvas;
        this.setLayout(new GridLayout(3,2));
        this.setOpaque(false);
        addComponents();
    }
    
    private void addComponents() {
        
        
        // SWING - FORCE INPUT
        // ---------------------------------------------------------------------
        final int FORCE_AXIS = JSlider.HORIZONTAL;
        final int FORCE_MIN = 0;
        final int FORCE_MAX = 100;
        final int FORCE_INIT = 25;
        
        JSlider FORCE_INPUT = new JSlider(FORCE_AXIS, FORCE_MIN, FORCE_MAX, FORCE_INIT);
        JLabel FORCE_OUTPUT = new JLabel("Force: " + FORCE_INPUT.getValue());
        SliderListener FORCE_LISTENER = new SliderListener(FORCE_INPUT, FORCE_OUTPUT, "Force: ");
        FORCE_INPUT.setOpaque(false);
        FORCE_INPUT.addChangeListener(FORCE_LISTENER);
        
        add(FORCE_INPUT);
        add(FORCE_OUTPUT);
        // ---------------------------------------------------------------------
        
        
        // SWING - DIRECTION INPUT
        // ---------------------------------------------------------------------
        final int DIR_AXIS = JSlider.HORIZONTAL;
        final int DIR_MIN = 0;
        final int DIR_MAX = 359;
        final int DIR_INIT = 90;
        
        JSlider DIR_INPUT = new JSlider(DIR_AXIS, DIR_MIN, DIR_MAX, DIR_INIT);
        JLabel DIR_OUTPUT = new JLabel("Direction: " + DIR_INPUT.getValue());
        SliderListener DIR_LISTENER = new SliderListener(DIR_INPUT, DIR_OUTPUT, "Direction: ");
        DIR_INPUT.setOpaque(false);
        DIR_INPUT.addChangeListener(DIR_LISTENER);

        add(DIR_INPUT);
        add(DIR_OUTPUT);
        // ---------------------------------------------------------------------
        
        
        
        // SWING - STRIKE BUTTON
        /**
         * Napin painamisen tulee liikuttaa palloa FORCE_INPUT ja DIR_INPUT arvojen perusteella
         * laskettuun päämäärään.
         */
        JButton BUTTON = new JButton("Swing!");
        ButtonListener BUTTON_LISTENER = new ButtonListener(minigolf, FORCE_INPUT.getValue(), DIR_INPUT.getValue(), canvas);
        BUTTON.addActionListener(BUTTON_LISTENER);
  
        add(BUTTON);

    }
    
}
