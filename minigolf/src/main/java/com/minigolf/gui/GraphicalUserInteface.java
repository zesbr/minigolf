package com.minigolf.gui;



import com.minigolf.game.Minigolf;
import com.minigolf.gui.*;
import java.awt.*;
import javax.swing.*;

public class GraphicalUserInteface implements Runnable {

    private JFrame frame;
    private Minigolf minigolf;
    private CanvasPanel canvas;
    
    public GraphicalUserInteface(Minigolf minigolf) { 
        this.minigolf = minigolf;
    }
    
    @Override
    public void run() {  
        frame = new JFrame("Minigolf");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addPanels(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    
    }
    
    private void addPanels(Container container) {
        CanvasPanel canvas = new CanvasPanel(minigolf);
        container.add(canvas);
        container.add(new JMenuBar());
        canvas.setLayout(new GridLayout(3, 3));
        
        
        canvas.add(new ConsolePanel(minigolf));
        canvas.add(new JLabel());
        canvas.add(new JLabel());
        
        canvas.add(new JLabel());
        canvas.add(new JLabel());
        canvas.add(new JLabel());
        
        canvas.add(new JLabel());
        canvas.add(new JLabel());
        canvas.add(new HeadsUpDisplayPanel(minigolf, canvas));   
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
