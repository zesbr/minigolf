package com.minigolf.gui;




import com.minigolf.game.Minigolf;
import com.minigolf.domain.Ball;
import com.minigolf.domain.Hole;
import java.awt.*;
import javax.swing.*;

public class CanvasPanel extends JPanel {
    
    private Minigolf minigolf;
    
    public CanvasPanel(Minigolf minigolf) {
        this.minigolf = minigolf;
        setBackground(Color.GREEN);
        setSize(new Dimension(800, 600));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);      
        minigolf.getBall().paint(g);
        minigolf.getLevel().getCup().paint(g);   
    }
    
}
