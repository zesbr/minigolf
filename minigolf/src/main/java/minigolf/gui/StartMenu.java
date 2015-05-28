package minigolf.gui;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Sovelluksen alkuvalikko, jonka tehtävänä on luoda alkuvalikon käyttöliittymä 
 * ja komponentit.
 * @author zesbr
 */
public class StartMenu extends JPanel {
    
    private ActionListener handler;
    private BoxLayout layout;
    
    public StartMenu(ActionListener handler) {       
        super();  
        this.handler = handler;
        this.layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        init();
        addComponents();    
    }
    
    private void init() {
        setLayout(layout);   
    }
    
    private void addComponents() {
        JButton game = new JButton("New Game");
        JButton tutorial = new JButton("Tutorial");
        JButton quit = new JButton("Quit");
        
        game.addActionListener(handler);
        tutorial.addActionListener(handler);
        quit.addActionListener(handler);
       
        add(game);
        add(tutorial);
        add(quit);   
    }

}
