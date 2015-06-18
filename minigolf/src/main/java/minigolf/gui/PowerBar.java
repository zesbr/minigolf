
package minigolf.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import minigolf.domain.Ball;
import minigolf.domain.Player;

public class PowerBar extends JProgressBar implements ActionListener {
    
    private float aimX;
    private float aimY;
    private int power;
    private boolean increase;
    private GameCanvas canvas;
    private Timer timer;
    
    public PowerBar(GameCanvas canvas) {
        super(JProgressBar.VERTICAL, 0, 1000);
        this.aimX = 0;
        this.aimY = 0;
        this.power = 0;
        this.increase = true;
        this.canvas = canvas;
        this.timer = new Timer(3, this);
        setOpaque(true);
    }
    
    /**
     * Käynnistää voimapalkin ajastimen.Tätä metodia kutsutaan pelialustan 
     * hiirentapahtumakäsittelijästä, kun hiiren vasenta painiketta pidetään 
     * pohjassa.
     */
    public void startTimer() {
        timer.start();
    }
    
    /**
     * Pysäyttää voimapalkin ajastimen sekä kutsuu uuden lyönnin käynnistävää 
     * toimenpidettä. Tätä metodia kutsutaan pelialustan 
     * hiirentapahtumakäsittelijästä, kun hiiren vasen painike vapauteaan. 
     */
    public void stopTimer() {
        timer.stop();
        put();
        init();
    }
    
    /**
     * Asettaa lyönnille x-koordinaatin
     * @param x : x-koordinaatti
     */
    public void setAimX(float x) {
        this.aimX = x;
        
    }
    
    /**
     * Asettaa lyönnin y-koordinaatin
     * @param y : y-koordinaatti
     */
    public void setAimY(float y) {
        this.aimY = y;
    }
    
    // Suorittaa lyönnin aktiivisella pelaajalla
    private void put() {
        canvas.getGui().disableHint();  // Piilottaa hint-tekstin
        Player player = canvas.getGame().getActivePlayer();
        Ball ball = player.getBall(); // Hakee aktiivisen pelaajan pallon
        double angle = ball.getAngleToPoint(aimX, aimY); // Laskee lyönnin kulman

        // Tarkistaa ettei pelialustan ajastin ole käynnissä
        if (!canvas.timerIsRunning()) {
            System.out.println(player.getName() + " lyö palloa voimalla " + power + " ja kulmassa " + angle); 
            player.put(power, angle); // Suorittaa putin aktiivisella pelaajalla
            canvas.startTimer(); // Käynnistää pelialustan ajastimen  
        }
    }
    
    /**
     * Ajastimen tapahtumakuuntelija, joka päivittää voimapalkin arvoa ajastimen 
     * viiveen määrittämällä nopeudella
     * @param ae : ajastimen päivitystapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Tarkistaa tuleeko voimapalkin arvoa kasvattaa vai vähentää
        if (power <= 0) {
            power = 0;
            increase = true;
        } else if (power >= 1000) {
            power = 1000;
            increase = false;
        }
        // Kasvattaa tai vähentää voimapalkin arvoa
        if (increase) {
            power += 3;
        } else{
            power -= 3;
        }
        transformColor();
        // Asettaa voimapalkin päivityneen arvon
        setValue(power);
        System.out.println("Power = " + power);
    }
    
    // Alustaa voimapalkin
    private void init() {
        power = 0;
        increase = true;
        setValue(power);
    }
    
    // Vaihtaa voimapalkin väriä
    private void transformColor() {
        int r = 255 * power / 1000;
        int g = (255 * (1000 - power) / 1000);
        int b = 0;
        setForeground(new Color(r, g, b));
    }
    
}
