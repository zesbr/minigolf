package minigolf.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.UIManager;
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
    private BorderLayout layout;
    private GameInputManager handler;
    
    private PowerBar powerBar;
    
    public GUI(GameCanvas canvas) {
        super();
        this.canvas = canvas;
        this.layout = new BorderLayout();
        this.handler = new GameInputManager(canvas, POWER_INIT, ANGLE_INIT);
        this.powerBar = new PowerBar(canvas);

        init();
        addComponents();
    }
    
    private void init() {
        
        setLayout(null);
        setOpaque(false);  
    }
    
    public PowerBar getPowerBar() {
        return powerBar;
    }
    
    private void addComponents() {    
       
powerBar.setForeground(Color.blue);
        powerBar.setBorderPainted(false);
        powerBar.setBounds(340, 360, 20, 200);
        add(powerBar);
        
        add(new JLabel("Aim with mouse and hold down the right mouse button"));
    }
    
}
