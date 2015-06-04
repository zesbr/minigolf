
package minigolf.gui;

import javax.swing.*;

/**
 * TODO: Lisää tekstipaneelit lyöntilaskurille, kentän numerolle ja
 * pelaajan nimelle
 * 
 * Pelialustalle kuuluva infopaneeli, jonka tehtävänä on huolehtia peliin 
 * liittyvistä ilmoituksista esim. vuorollisen pelaajan ja lyöntimäärän
 * esittämisestä käyttäjälle.
 * @author zesbr
 */
public class HUD extends JPanel {   

    private GameCanvas canvas;
    
    public HUD(GameCanvas canvas) {
        this.canvas = canvas;
    }
}
