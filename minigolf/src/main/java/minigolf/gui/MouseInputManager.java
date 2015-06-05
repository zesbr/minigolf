package minigolf.gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Pelialustaan liittyvä hiiren tapahtumiakäsittelijä. Luokan tehtävä on mm.
 * asettaa
 * @author zesbr
 */
public class MouseInputManager extends MouseAdapter {
    
    private PowerBar powerBar;
    
    public MouseInputManager(PowerBar powerBar) {
        this.powerBar = powerBar;
    }
    
    /**
     * Hiiren painikkeen painallustapahtumaa käsittelevä metodi, joka kutsuu
     * käyttöliittymän voimapalkin ajastinta käynnistymään
     * @param me : hiiren tapahtuma
     */
    @Override
    public void mousePressed(MouseEvent me) {
        powerBar.startTimer();
    }
    
    /**
     * Hiireen painikkeen vapauttamistapahtumaa käsittelevä metodi, joka
     * asettaa voimapalkille hiiren osoittimen sijainnin koordinaatteina 
     * ja pysäyttää voimapalkin ajastimen
     * @param me ; hiiren tapahtuma
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        Point mousePosition = me.getComponent().getMousePosition();
        powerBar.setAimX(mousePosition.x);
        powerBar.setAimY(mousePosition.y);
        powerBar.stopTimer();
    }
    
}
