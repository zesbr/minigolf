package minigolf.gui;

import java.awt.*;
import javax.swing.*;
import minigolf.domain.*;
import minigolf.game.*;

public class GameCanvas extends JPanel {
   
    private Game game;
    private GUI gui;
    private HUD hud;
    
    private final boolean SHOW_HUD = false;
    private final boolean SHOW_GUI = true;
    
    public GameCanvas(Game game) {

        super();
        this.game = game;
        this.gui = new GUI(game.getCurrentPlayer(), this);
        this.hud = new HUD();
        initialize();
    
    }
    
    private void initialize() {
        
        // Asettaa näkymän taustaväriki vihreän
        setBackground(Color.GREEN);
        
        // TODO: Korvaa GridLayout GridBagLayoutilla
        
        // Asetttaa layoutiksi GridLayout:n
        setLayout(new GridLayout(4, 3));

        // GridLayoutin ylin rivi
        if (SHOW_HUD) {
            add(hud);
        } else {
            add(new JLabel());
        }
        
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        
        // GridLayoutin keskimmäinen rivi
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        
        // GridLayoutin alin rivi
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        if (SHOW_GUI) {
            add(gui);
        } else {
           add(new JLabel());
        }
        
    }
    
    public Graphics2D getAntiAliasedBrush(Graphics g) {
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(rh);
        
        return g2d;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);     
        Graphics2D g2d = getAntiAliasedBrush(g);
        
        Level level = game.getCurrentLevel();
        
        Hole hole = level.getHole();
        Tee tee = level.getTee();
        
        Player player = game.getCurrentPlayer();
        
        Ball ball = player.getBall();
        
        g2d.setColor(Color.BLACK);
        g2d.fillOval(hole.getX(), hole.getY(), 30, 30);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(ball.getX(), ball.getY(), 20, 20);
        
    }
     
}
