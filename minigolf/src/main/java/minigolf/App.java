
package minigolf;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import minigolf.game.Game;
import minigolf.gui.StartMenu;
import minigolf.gui.GameCanvas;

public class App extends JFrame implements ActionListener {
      
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    private final String FRAME_TITLE = "Minigolf";
    private final boolean FRAME_RESIZABLE = false;
    
    private JPanel basePanel;
    
    public App() {
        
        super();
        basePanel = new JPanel();
        initialize();
        launch();
        
    }
   
    public static void main(String[] args) {
        
        App app = new App();
        app.run();
        
    }
    
    private void initialize() { 
        
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setTitle(FRAME_TITLE);
        setResizable(FRAME_RESIZABLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        basePanel.setLayout(new CardLayout());
        
        getContentPane().add(basePanel);
        
    }
    
    private void launch() {  
        
        basePanel.add("STARTMENU", new StartMenu(this)); 
        CardLayout layout = (CardLayout) basePanel.getLayout();
        layout.show(basePanel, "STARTMENU");
        
    }
    
    private void launch(Game game) {
        
        basePanel.add("GAME", new GameCanvas(game));
        CardLayout layout = (CardLayout) basePanel.getLayout();
        layout.show(basePanel, "GAME");
        
    }
    
    public void run() { 
        
        pack();
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
   
        if (ae.getActionCommand().equals("New Game")) {
            
            // Käynnistää uuden pelin
            launch(new Game());
            
        }
        
    }
    
}