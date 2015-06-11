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
    private final String SCORECARD = "Scorecard";
    
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
        showStartMenu();
    }
    
    // Näyttää päävalikon
    private void showStartMenu() {
        add(STARTMENU, new StartMenu(this)); 
        layout.show(this, STARTMENU);
    }
    
    // Käynnistää uuden pelin ja näyttää pelialustan
    private void startGame(Game game) {
        add(GAME, new GameCanvas(game, this));
        layout.show(this, GAME);
    }
    
    /**
     * Näyttää tuloskortin pelikierroksen päätteeksi
     * @param game : peli-instanssi
     */
    public void showScorecard(Game game) {
        add(SCORECARD, new Scorecard(game, this));
        layout.show(this, SCORECARD);
    }
    
    /**
     * Tapahtumakuuntelija, joka käsittelee näkymien vaihtamiseen ja luontiin
     * liittyvät pyynnöt
     * @param ae : tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("NEW GAME")) {
            startGame(new Game());
        } else if (ae.getActionCommand().equals("CONTINUE")) {
            showStartMenu();
        } else if (ae.getActionCommand().equals("QUIT")) {
            System.exit(0);
        }
    }
    
}
