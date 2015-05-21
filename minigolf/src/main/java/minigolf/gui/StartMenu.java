
package minigolf.gui;

import minigolf.App;
import java.awt.*;
import javax.swing.*;

public class StartMenu extends JPanel {
    
    private App app;
    
    public StartMenu(App app) {
        
        super();
        this.app = app;
        initialize();
        addComponents();
        
    }
    
    private void initialize() {
        
        // TODO: Aseta valikolle taustakuva
        // 
        
        // Asettaa valikon layoutiksi BoxLayout:n
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
    }
    
    private void addComponents() {
        
        // TODO:Luo valikon otsikkokomponentti
        // 
        
        // Luodaan uudet painikekomponentit
        JButton newGame = new JButton("New Game");
        JButton tutorial = new JButton("Tutorial");
        JButton quit = new JButton("Quit");
        
        // TODO: Määritä komponenttien fontti
        // 
        
        // Lisätään tapahtumakuuntelijat painikkeille
        newGame.addActionListener(app);
        tutorial.addActionListener(app);
        quit.addActionListener(app);
       
        // Lisää komponentit valikkoon
        add(newGame);
        add(tutorial);
        add(quit);
          
    }

}
