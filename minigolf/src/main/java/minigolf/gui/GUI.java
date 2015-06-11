package minigolf.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Pelialustalle kuuluva graafinen käyttöliittymäpaneeli, jonka tehtävänä
 * on huolehtia käyttöliittymän komponenttien luomisesta ja alustamisesta. 
 * @author zesbr
 */
public class GUI extends JPanel {
    
    private GameCanvas canvas; 
    private PowerBar powerBar;
    private JLabel hintText;
    
    public GUI(GameCanvas canvas) {
        super();
        this.canvas = canvas;
        this.powerBar = new PowerBar(canvas);
        this.hintText = new JLabel();
        
        init();
        addComponents();
    }
    
    /**
     * Palauttaa lyönnin voimapalkkikomponentin
     * @return voimapalkki
     */
    public PowerBar getPowerBar() {
        return powerBar;
    }
    
    // Alustaa paneelin ja komponentit
    private void init() { 
        setLayout(null);
        setOpaque(false);  
        powerBar.setForeground(Color.blue);
        powerBar.setBorderPainted(false);
        powerBar.setBounds(740, 360, 20, 200);
        hintText.setText("Hold and release left mouse button to shoot");
        hintText.setFont(new Font("Lato Light", Font.BOLD, 18));
        hintText.setForeground(Color.WHITE);
        hintText.setBounds(200, 460, 600, 50);
    }
    
    /**
     * 
     */
    public void disableHint() {
       hintText.setVisible(false);
    }
    
    // Lisää komponentit paneeliin
    private void addComponents() {    
        add(powerBar);
        add(hintText);
    }
    
}
