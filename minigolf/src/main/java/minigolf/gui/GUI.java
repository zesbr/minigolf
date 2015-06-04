package minigolf.gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

/**
 * Pelialustalle kuuluvat graafinen käyttöliittymäpaneeli, jonka tehtävänä
 * on huolehtia käyttöliittymäkomponenttien luomisesta ja alustamisesta. 
 * @author zesbr
 */
public class GUI extends JPanel {
    
    private final int POWER_MIN = 0;
    private final int POWER_MAX = 1000;
    private final int POWER_INIT = 500;
    
    private final int ANGLE_MIN = -180;
    private final int ANGLE_MAX = 180;
    private final int ANGLE_INIT = 45;
    
    private GameCanvas canvas; 
    private GridLayout layout;
    private EventListener handler;
    
    public GUI(GameCanvas canvas) {
        super();
        this.canvas = canvas;
        this.layout = new GridLayout(3,2);
        this.handler = new GameInputManager(canvas, POWER_INIT, ANGLE_INIT);
        
        init();
        addComponents();
    }
    
    private void init() {
        setLayout(layout);
        setOpaque(false);  
    }
    
    private void addComponents() {    
        
        
        JProgressBar powerBar = new JProgressBar(JProgressBar.VERTICAL, 1, 1000);
        
        JSlider powerInput = new JSlider(POWER_MIN, POWER_MAX, POWER_INIT);
        JSlider angleInput = new JSlider(ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);
        JButton putButton = new JButton("Put!");
        
        powerInput.setOpaque(false);
        angleInput.setOpaque(false);
        
        powerInput.setName("Power Input");
        angleInput.setName("Angle Input");

        // Lisää muutos- ja tapahtukuuntelijat käyttöliittymän komponenteille
        powerInput.addChangeListener((ChangeListener) handler);
        angleInput.addChangeListener((ChangeListener) handler);
        putButton.addActionListener((ActionListener) handler);
       
        
        powerBar.setAlignmentX(TOP_ALIGNMENT);
        powerBar.setSize(10, 200);
        //add(powerBar);
        
        add(new JLabel("Power:"));
        add(powerInput);
        
        add(new JLabel("Angle:"));
        add(angleInput);
        
        add("Put Button", putButton);
    }
    
}
