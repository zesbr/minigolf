package minigolf.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;
import minigolf.domain.*;
import minigolf.game.*;

/**
 * Sovelluksen piirtoalusta, jonka tehtävänä on huolehtia 
 * piirtoalustan alustamisesta sekä piirtoalustaan kohdistuvista 
 * piirtotapahtumista.
 * @author zesbr
 */
public class GameCanvas extends JPanel implements ActionListener {
   
    private Game game;
    private GUI gui;
    private HUD hud;
    private Timer timer;
    private MouseInputManager mouse;
    
    private final boolean SHOW_HUD = true;
    private final boolean SHOW_GUI = true;
    private final int FPS = 1000 / 60;
    
    public GameCanvas(Game game) {
        super();  
        this.game = game;
        this.gui = new GUI(this);
        this.hud = new HUD(this);
        this.timer = new Timer(FPS, this);
        this.mouse = new MouseInputManager(gui.getPowerBar());
        init();
    }
    
    // Valmistelee piirtoalustaan ja lisää siihen alikomponentit
    private void init() {
        setBackground(new Color(138, 224, 0));
        setLayout(new GridLayout(1, 2)); 
        // Lisää HUD:n ja Käyttöliittmään pelialustaan
        add(hud);
        add(gui); 
        // Lisätään pelialustalle tapahtumakuuntelijat
        addMouseListener(mouse);
    }
    
    /**
     * Käynnistää ajastimen. Tätä kutsutaan aina puttaustapahtuman 
     * aluksi, kun piirtoalustaa halutaan päivittää automaattisesti
     */
    public void startTimer() {
        timer.start();
    }
    
    /**
     * Pysäyttää ajastimen. Tätä kutsutaan aina puttaustapahtuman
     * päätteksi, kun piirtoalustan automaattinen päivittäminen halutaan 
     * lopettaa
     */
    public void stopTimer() {
        timer.stop();
    }
    
    /**
     * Tarkistaa onko ajastin päällä ja palauttaa totuusarvon
     * @return totuusarvo, onko ajastin päällä (true) vai ei (false)
     */
    public boolean timerIsRunning() {
        return timer.isRunning();
    }
    
    /**
     * Asettaa ajastimelle viiveen
     * @param delay : viive
     */
    public void setTimerDelay(int delay) {
        timer.setDelay(delay);
    }
    
    /**
     * Palauttaa piirtoalustan peli-instanssin. Tätä kutsutaan aina, kun 
     * piirtoalustan kautta halutaan päästä peli-instanssiin käsiksi
     * @return peli-instanssi
     */
    public Game getGame() {
        return game;
    }
    
    // Palauttaa reunepehmennetyn grafiikka-olion
    private Graphics2D getSmootherGraphics(Graphics g) {
        RenderingHints rendering = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        rendering.put(
                RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY
        );
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(rendering);
        
        return g2d;
    }
    
    /**
     * Piirtää pelikentän reiän
     * @param g : grafiikka-olio
     * @param hole : reikä
     */
    public void paint(Graphics2D g, Hole hole) {
        int x = hole.getX();
        int y = hole.getY();
        int diameter = hole.getDiameter();
        
        g.setColor(Color.BLACK);
        g.fillOval(x, y, diameter, diameter);
    }
    
    /**
     * Piirtää pelikentän esteen
     * @param g : grafiikka-olio
     * @param obstacle : este
     */
    public void paint(Graphics2D g, Obstacle obstacle) {
        int x = obstacle.getX();
        int y = obstacle.getY();
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        
        g.setColor(new Color(166, 134, 76));
        g.fillRect(x, y, width, height);
    }
    
    /**
     * Piirtää pallon
     * @param g : grafiikka-olio
     * @param ball : pallo
     */
    public void paint(Graphics2D g, Ball ball) {
        int x = (int) ball.getX();
        int y = (int) ball.getY();
        int diameter = ball.getDiameter();
        
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
    
    /**
     * Piirtää pelialustan komponentit
     * @param g : grafiikka-olio
     */
    @Override
    public void paintComponent(Graphics g) {   
        super.paintComponent(g);     
        // Luo uuden reunapehmennetyn (antialias) grafiikka-olion
        Graphics2D graphics = getSmootherGraphics(g); 
        // Haetaan nykyinen kenttä
        Level level = game.getCurrentLevel();
        // Piirtää kaikki kentän esteet piirtoalustaan
        for (Obstacle obstacle : level.getObstacles()) {
            paint(graphics, obstacle);
        }
        // Piirtää reiän piirtoalustaan
        paint(graphics, level.getHole());
        // Piirtää pallon piirtoalustaan
        paint(graphics, game.getActiveBall());
    }
    
    /**
     * TODO: 
     * Refaktoroi. Tästä voisi tehdä oman luokan
     * 
     * Luokan ajastinta kuunteleva tapahtumakäsittelijä, jota kutsutaan aina kun 
     * pallo on liikkeessä 60 kertaa sekunnissa
     * @param ae : ajastimen tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Hakee pelissä olevan pallon
        Ball ball = game.getActiveBall();
        // Tarkistetaan onko pallo liikkeessä
        if (ball.getSpeed() > 0) {   
            // Liikuttaa palloa
            ball.move(this);
            // Piirtää alustan uudelleen
            repaint();    
        } else {
            // Nollataan pallon liike, jos se on negatiivinen
            ball.setSpeed(0);  
            
            // Hakee nykyisen kentän ja tarkistaa oliko pallo reiässä
            Level level = game.getCurrentLevel();
            if (level.ballIsInHole(ball)) {
                
                // TODO: Tässä tulisi tapahtua reikään uppoamisen ääniefekti

                // Kirjaa pelaajan tuloksen ja nollaa lyöntilaskurin
                Player player = game.getActivePlayer();
                System.out.println(player.getName() + " pelasi pallon reikään " + player.getStrikes() + " lyönnillä.");
                player.addScore(level, player.getStrikes());
                player.initStrikes();
                // TODO: Näytä pelaajan tuloskortin
                
                // Jäädytää kuvan kolmeksi sekunniksi
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                // Vaihtaa pelaajan
                player = game.switchPlayer();               
                // Tarkistaa onko pelaaja pelannut jo reiän ja vaihtaa kentän tarvittaessa
                if (player.getScore(level) != -1) {
                    level = game.switchLevel();
                    game.placeBallsToTee(level.getTee());
                }
                // Piirtää alustan uudelleen
                repaint();
            }
            // Pysäyttää ajastimen lyönnin päätteeksi
            stopTimer();
        }
    }
     
}
