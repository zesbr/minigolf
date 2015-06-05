package minigolf;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import minigolf.gui.ViewManager;

/**
 * Ohjelman ikkunakehyksestä ja alustustoimenpiteistä huolehtiva luokka. Luokan tehtävänä on luoda ja alustaa 
 * uusi sovellusikkuna sekä sovellusikkunan näkymähallitsija ViewManager.
 * @author zesbr
 */
public class App implements Runnable {
      
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final String TITLE = "Minigolf";
    private final boolean RESIZABLE = false;
    private JFrame frame;
    private ViewManager manager;
    
    public App() {

    }
    
    private void init() { 
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setTitle(TITLE);
        frame.setResizable(RESIZABLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        frame.getContentPane().add(manager);
    }
    
    /**
     * Ohjelmaa ajava metodi, josta luodaan uusi JFrame ja ViewManger,
     * kutsutaan alustusmetodia (init) sekä lopuksi pakataan komponentit.
     */
    @Override
    public void run() {
        frame = new JFrame();
        manager = new ViewManager(this);
        
        init();
        
        frame.pack();
        frame.setVisible(true);
    }
    
}
