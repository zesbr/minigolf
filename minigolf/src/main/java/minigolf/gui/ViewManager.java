package minigolf.gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import minigolf.App;
import minigolf.game.Game;

/**
 * Sovelluksen näkymienhallinnasta huolehtiva luokka, jonka tehtävä on käsitellä 
 * tapahtumat, joilla halutaan vaikuttaa esitettävään näkymään App luokan JFrame
 * ikkunakehyksessä.
 * @author zesbr
 */
public class ViewManager extends JPanel implements ActionListener {
    
    private final String STARTMENU = "Start Menu";
    private final String GAME = "Game";
    
    private App app;
    private CardLayout layout;
    
    public ViewManager(App app) {
        this.app = app;
        this.layout = new CardLayout();
        
        init();
    }
    
    // Alustaa näkymänhallitsijan
    private void init() {
        setLayout(layout);
        startMenu();
    }
    
    // Käynnistää päävalikon
    private void startMenu() {
        add(STARTMENU, new StartMenu(this)); 
        layout.show(this, STARTMENU);
    }
    
    // Käynnistää uuden pelin
    private void startGame(Game game) {
        add(GAME, new GameCanvas(game));
        layout.show(this, GAME);
    }
    
    /**
     * Tapahtumakuuntelija, joka käsittelee näkymien vaihtamiseen ja luontiin
     * liittyvät pyynnöt
     * @param ae : tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("New Game")) {
            startGame(new Game());
        }
    }
    
}
