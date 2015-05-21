
package minigolf.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import minigolf.domain.Ball;
import minigolf.domain.Player;

public class Putter implements ActionListener {
    
    private Player player;
    private JSlider powerInput;
    private JSlider angleInput;
    private GameCanvas canvas;
    
    public Putter(Player player, JSlider powerInput, JSlider angleInput, GameCanvas canvas) {    
        
        this.player = player;
        this.powerInput = powerInput;
        this.angleInput = angleInput;
        this.canvas = canvas;
        
    }
          
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Ball ball = player.getBall();
        int power = powerInput.getValue();
        int angle = angleInput.getValue();
        
        System.out.println("Pallo on aluksi kohdassa: " + ball.getX() + ", " + ball.getY());
        System.out.println("Putataan kulmassa:" + angle + " ja voimalla " + power);
        
        player.put(ball, power, angle);
        canvas.repaint();
          
    }

}
