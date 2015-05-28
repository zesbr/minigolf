package minigolf.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import minigolf.domain.*;
import minigolf.game.*;

/**
 * Sovelluksen pelitilan piirtoalusta, jonka tehtävänä on huolehtia 
 * piirtoalustan alustamisesta sekä piirtoalustaan kohdistuvista 
 * piirtotapahtumista.
 * @author zesbr
 */
public class GameCanvas extends JPanel implements ActionListener {
   
    private Game game;
    private GridLayout layout;
    private GUI gui;
    private HUD hud;
    private Timer timer;
    
    private final boolean SHOW_HUD = false;
    private final boolean SHOW_GUI = true;
    private double fps = 0;
    
    public GameCanvas(Game game) {
        super();  
        this.game = game;
        this.layout = new GridLayout(4, 3); // TODO: Joku muu layout voisi sopia paremmin
        this.gui = new GUI(this);
        this.hud = new HUD();
        this.timer = new Timer((int) fps, this);
        
        init();
    }
    
    private void init() {
        setBackground(Color.GREEN);
        setLayout(layout);
        
        // TODO: Refaktoroi tämä osio
            // Luodaan tyhjät JLabel-oliot GridLayoutin ylimälle riville
            add(new JLabel());
            add(new JLabel());
            add(new JLabel());
            add(new JLabel());

            // Luodaan tyhjät JLabel-oliot GridLayoutin keskimmäiselle riville
            add(new JLabel());
            add(new JLabel());
            add(new JLabel());
            add(new JLabel());

            // Luodaan HUD ja GUI sekä tyhjät JLabel-oliot GridLayoutin alimmalle riville
            if (SHOW_HUD) {
                add(hud);
            } else {
                add(new JLabel());
            }
            add(new JLabel());
            add(new JLabel());
            if (SHOW_GUI) {
                add(gui);
            } else {
               add(new JLabel());
            }
    }
    
    /**
     * Käynnistää ajastimen. Tätä kutsutaan aina puttaustapahtuman 
     * aluksi.
     */
    public void startTimer() {
        timer.start();
    }
    
    /**
     * Pysäyttää ajastimen. Tätä kutsutaan aina puttaustapahtuman
     * päätteksi.
     */
    public void stopTimer() {
        timer.stop();
    }
    
    /**
     * Tarkistaa onko ajastin päällä ja palauttaa totuusarvon
     * @return boolean : true, jos ajastin on päällä ja muuten false
     */
    public boolean timerIsRunning() {
        return timer.isRunning();
    }
    
    /**
     * Asettaa ajastimelle viiveen
     * @param delay : ajastimelle asetettava viive
     */
    public void setTimerDelay(int delay) {
        timer.setDelay(delay);
    }
    
    /**
     * Palauttaa piirtoalustan peli-instanssin. Tätä kutsutaan mm. tapahtuma-
     * käsittelijästä kun pelissä olevan pallon sijaintia päivitetään.
     * @return
     */
    public Game getGame() {
        return game;
    }
    
    /**
     * TODO
     * @param g
     * @return 
     */
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
     * Piirtää reiän mustalla.
     * @param g
     * @param hole 
     */
    public void paint(Graphics2D g, Hole hole) {
        int x = hole.getX();
        int y = hole.getY();
        int diameter = hole.getDIAMETER();
        
        g.setColor(Color.BLACK);
        g.fillOval(x, y, diameter, diameter);
    }
    
    /**
     * Piirtää esteen vaaleanharmaalla. 
     * @param g
     * @param obstacle 
     */
    public void paint(Graphics2D g, Obstacle obstacle) {
        int x = obstacle.getX();
        int y = obstacle.getY();
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, width, height);
    }
    
    /**
     * Piirtää pallon valkoisella.
     * @param g
     * @param ball 
     */
    public void paint(Graphics2D g, Ball ball) {
        int x = (int) ball.getX();
        int y = (int) ball.getY();
        int diameter = ball.getDiameter();
        
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
    
    /**
     * TODO
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {   
        super.paintComponent(g);     
        
        // Luo uuden reunapehmennetyn (antialias) grafiikka-olion
        Graphics2D graphics = getSmootherGraphics(g); 

        Level level = game.getCurrentLevel();
        
        // Piirtää kaikki kentän esteet piirtoalustan
        for (Obstacle obstacle : level.getObstacles()) {
            paint(graphics, obstacle);
        }
        
        // Piirtää reiän piirtoalustaan
        paint(graphics, level.getHole());
        
        // Piirtää pallon piirtoalustaan
        paint(graphics, game.getBallOnPlay());
    }
    
    /**
     * TODO
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Ball ball = game.getBallOnPlay();
        
        if (ball.getSpeed() > 1) { 
            // Tarkistaa onko pallo reiässä tai esteessä ja liikuttaa palloa
            if (game.ballIsInHole(ball)) {
                // TODO: Tässä tulisi tapahtua pelaajan tai radan vaihto
            } else if (game.ballHitsObstacle(ball)) { 
                ball.move();
            } else {
                ball.move();
            }
            // Hidastetaan ajastinta
            if (ball.getSpeed() < 200) {
                fps += 0.3;
                timer.setDelay((int) fps);
            }
            // Piirtää alustan uudelleen
            repaint();
        } else {
            // Pysäytetään pallo
            ball.setSpeed(0);
            
            System.out.println("Lyönnin jälkeen pallo on kohdassa: [" +
                (int) ball.getX() + ", " + (int) ball.getY() + "]");
            
            // Alustetaan ajastimen nopeus ja pysäytetään ajastin
            fps = 0;
            timer.setDelay(0);
            stopTimer();
        }
    }
     
}
