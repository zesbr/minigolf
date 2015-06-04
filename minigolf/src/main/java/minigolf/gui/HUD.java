
package minigolf.gui;

import javax.swing.*;

/**
 * Pelialustalle kuuluva infopaneeli, jonka tehtävänä on huolehtia peliin 
 * liittyvistä ilmoituksista esim. vuorollisen pelaajan ja lyöntimäärän
 * esittämisestä käyttäjälle.
 * @author jesruuth
 */
public class HUD extends JPanel {   

    private GameCanvas canvas;
    
    public HUD(GameCanvas canvas) {
        this.canvas = canvas;
    }
}
