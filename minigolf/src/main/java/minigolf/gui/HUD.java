
package minigolf.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.game.Game;

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
    private JLabel levelID;
    private JLabel playerName;
    private JLabel playerStrikes;
    
    public HUD(GameCanvas canvas) {
        super();
        this.canvas = canvas;
        this.levelID = new JLabel();
        this.playerName = new JLabel();
        this.playerStrikes  = new JLabel();
        
        init();
        addComponents();
    }
    
    private void init() {
        setOpaque(false);
        
        Game game = canvas.getGame();
        Level level = game.getCurrentLevel();
        Player player = game.getActivePlayer();
        levelID.setText(level.getName());
        playerName.setText(player.getName());
        playerStrikes.setText("" + player.getStrikes());
    }
    
    private void addComponents() {  
        add(levelID);
        add(playerName);
        add(playerStrikes); 
    }

}
