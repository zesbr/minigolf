package com.minigolf.gui;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

    private JSlider input;
    private JLabel output;
    private String prefix;
    
    public SliderListener(JSlider input, JLabel output, String prefix) {
        this.input = input;
        this.output = output;
        this.prefix = prefix;
    }
    
    @Override
    public void stateChanged(ChangeEvent ce) {
        this.output.setText(this.prefix + this.input.getValue());
    }
      
}