package minigolf.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import minigolf.game.Game;

/**
 * Käyttäjän pelinaikana tekemien syötteiden tapahtumakuuntelija. Tästä luokasta 
 * aloitetaan mm. uuden putin suorittamiseen tarvittava toimenpideketju.
 * @author zesbr
 */
public class GameInputManager implements ActionListener, ChangeListener {
    
    private GameCanvas canvas;
    private double power;
    private double angle;
    
    public GameInputManager(GameCanvas canvas, int power, int angle) {
        this.canvas = canvas;
        this.power = power * 10;
        this.angle = angle;
    }
    
    public void setPower(int power) {
        this.power = (double) power;
    }
    
    public void setAngle(int angle) {
        this.angle = (double) angle;
    }
    
    /**
     * Puttaus painikkeen tapahtumakuuntelija, joka käynnistää uuden putin
     * suorittamiseen liittyvän tapahtumaketjun.
     * @param action 
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        
        // Asetetaan peli instanssi muuttujaan
        Game game = canvas.getGame();
        
        // Jos timer on käynnössä, niin lyönti on kesken
        if (!canvas.timerIsRunning()) {
            // TODO: Disable putti painike
            game.performPut(canvas, power, angle);
        }
    }
    
    /**
     * Lyönnin voiman ja suunnan muutoksiin reagoiva muutoskuuntelija, joka
     * päivittää seuraavan lyönnin voima ja suunta attribuutteja.
     * @param change 
     */
    @Override
    public void stateChanged(ChangeEvent change) {
        JSlider slider = (JSlider) change.getSource();
        
        switch (slider.getName()) {
            case "Power Input":
                setPower(slider.getValue() * 10);
                System.out.println("power: " + slider.getValue());
                break;
            case "Angle Input":
                setAngle(slider.getValue());
                System.out.println("angle: " + slider.getValue());
                break;
        }
    }
    
}
