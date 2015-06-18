package minigolf.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.Timer;
import minigolf.domain.*;
import minigolf.game.*;

/**
 * Sovelluksen piirtoalusta, jonka tehtävänä on huolehtia 
 * piirtoalustan alustamisesta sekä piirtoalustaan kohdistuvista 
 * piirtotapahtumista.
 * @author zesbr
 */
public class GameCanvas extends JPanel {
   
    private Game game;
    private GUI gui;
    private HUD hud;
    private Timer timer;
    private MouseInputManager mouse;
    private ViewManager viewManager;
    
    private final boolean SHOW_HUD = true;
    private final boolean SHOW_GUI = true;
    private final int FPS = 1000 / 60;
    
    public GameCanvas(Game game, ViewManager viewManager) {
        super();  
        this.game = game;
        this.gui = new GUI(this);
        this.hud = new HUD(this);
        this.timer = new Timer(FPS, new GameCanvasUpdater(this));
        this.mouse = new MouseInputManager(gui.getPowerBar());
        this.viewManager = viewManager;
        init();
    }
    
    // Valmistelee piirtoalustaan ja lisää siihen alikomponentit
    private void init() {
        setBackground(new Color(138, 224, 0));
        setLayout(new GridLayout(1, 1)); 
        add(gui); 
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
    
    /**
     * Palauttaa piirtoalustan graafisen käyttöliittmäpaneelin
     * @return 
     */
    public GUI getGui() {
        return gui;
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
    
    public void showScoreCard() {
        viewManager.showScorecard(game);
    }
     
}
