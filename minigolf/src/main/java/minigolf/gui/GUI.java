package minigolf.gui;

import minigolf.game.Game;
import java.awt.*;
import javax.swing.*;
import minigolf.domain.Player;

public class GUI extends JPanel {
    
    private final int POWER_MIN = 1;
    private final int POWER_MAX = 100;
    private final int POWER_INIT = 25;
    
    private final int ANGLE_MIN = -180;
    private final int ANGLE_MAX = 180;
    private final int ANGLE_INIT = 90;
    
    private Player player;
    private GameCanvas canvas;
    
    public GUI(Player player,GameCanvas canvas) {
        
        super();
        this.player = player;
        this.canvas = canvas;
        init();
        addComponents();
        
    }
    
    private void init() {
        
        setLayout(new GridLayout(3,2));
        setOpaque(false);
        
    }
    
    private void addComponents() {   
        
        JSlider powerInput = new JSlider(POWER_MIN, POWER_MAX, POWER_INIT);
        JSlider angleInput = new JSlider(ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);
        
        JButton putButton = new JButton("Put!");
        
        powerInput.setOpaque(false);
        angleInput.setOpaque(false);
        
        Putter putter = new Putter(player, powerInput, angleInput, canvas);
        
        //PutPower power = new PutPower(forceInput, put);
        //PutAngle angle = new PutAngle(angleInput, put);
        
        putButton.addActionListener(putter);
        
        add(new JLabel("Power:"));
        add(powerInput);
        add(new JLabel("Angle:"));
        add(angleInput);
        add(putButton);
    }
    
}
