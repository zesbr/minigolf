package minigolf.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import minigolf.domain.Player;

/**
 * Käyttäjän pelinaikana tekemien syötteiden tapahtumakuuntelija. Tästä luokasta 
 * aloitetaan mm. uuden putin suorittamiseen tarvittava toimenpideketju.
 * 
 * @author zesbr
 */
public class GameInputManager implements ActionListener, ChangeListener {
    
    private GameCanvas canvas;
    private double power;
    private double angle;
    
    public GameInputManager(GameCanvas canvas, int power, int angle) {
        this.canvas = canvas;
        this.power = power;
        this.angle = angle;
    }
    
    /**
     * Asettaa 
     * @param power 
     */
    public void setPower(int power) {
        this.power = (double) power;
    }
    
    public void setAngle(int angle) {
        this.angle = (double) angle;
    }
    
    /**
     * Puttaus painikkeen tapahtumakuuntelija, joka käynnistää uuden putin
     * suorittamiseen liittyvän tapahtumaketjun.
     * @param action : puttausnapin painamisen aiheuttama tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        
        // Hakee peli-instanssin aktiivisen pelaajan
        Player player = canvas.getGame().getActivePlayer();
        
        // Tarkistaa ettei pelialustan ajastin ole käynnissä
        if (!canvas.timerIsRunning()) {
            
            System.out.println(player.getName() + " lyö palloa voimalla " + power + " ja kulmassa " + angle);
            
            // Suorittaa putin aktiivisella pelaajalla
            player.put(power, angle);
            
            // Käynnistää pelialustan ajastimen  
            canvas.startTimer();
            
            // TODO: Disable putti painike
            
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
                setPower(slider.getValue());
                System.out.println("power: " + slider.getValue());
                break;
            case "Angle Input":
                setAngle(slider.getValue());
                System.out.println("angle: " + slider.getValue());
                break;
        }
    }



    
}
