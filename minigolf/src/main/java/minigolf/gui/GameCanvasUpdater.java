package minigolf.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minigolf.domain.Ball;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.game.Game;

/**
 * Piirtoalustan päivittäjä. Tämä luokka on piirtoalustan ajastimen 
 * tapahtumakuuntelija, joka käsittelee piirtoalustan päivittämiseen liittyvän
 * tapahtuman eli liikuttaa palloa, mikäli siinä on liike-energiaa jäljellä
 * @author zesbr
 */
public class GameCanvasUpdater implements ActionListener{
    
    private GameCanvas canvas;
    
    public GameCanvasUpdater(GameCanvas canvas) {
        this.canvas = canvas;
    }
    
    // Jäädyttää piirtoalustan kolmeksi sekunniksi
    private void freezeCanvas() {
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * TODO: Tämä on jo parempi, mutta edelleen vähän mörkö
     * 
     * Piirtoalustan ajastinta kuunteleva tapahtumakäsittelijä, jota kutsutaan 
     * aina kun pallo on liikkeessä 60 kertaa sekunnissa.
     * @param ae : ajastimen tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Game game = canvas.getGame();
        Ball ball = game.getActiveBall(); // Hakee pelissä olevan pallon
        
        // Tarkistetaan onko pallo liikkeessä
        if (ball.getSpeed() > 0) {    
            ball.move(canvas); // Liikuttaa palloa
            canvas.repaint(); // Piirtää alustan uudelleen 
        } else {   
            ball.setSpeed(0);  // Nollataan pallon liike, jos se on negatiivinen
            Level level = game.getCurrentLevel(); // Hakee nykyisen kentän ja tarkistaa oliko pallo reiässä
            
            // Tarkistetaan onko pallo reiässä
            if (level.ballIsInHole(ball)) {
                game.markScore(); // Kirjaa pelaajan tuloksen tuloskorttiin
                freezeCanvas(); // Jäädyttää piirtoalustan kolmeksi sekunniksi
                game.switchPlayer(); // Vaihtaa pelaajan       
                
                // Jos kaikki pelaajat ovat pelanneet kentän, niin vaihdetaan kenttä
                if (game.allPlayersHaveCompletedLevel()) {
                    level = game.switchLevel();
                }
                
                // Jos peli on päättynyt, niin näytetään tuloskortti
                if (game.hasEnded()) {
                    System.out.println("Peli on päättynyt"); 
                    canvas.stopTimer();
                    canvas.showScoreCard();
                } else {
                    game.placeBallsToTee(level.getTee());
                }
                canvas.repaint();
            }
            // Pysäyttää ajastimen lyönnin päätteeksi
            canvas.stopTimer();
        }
    }
    
}
