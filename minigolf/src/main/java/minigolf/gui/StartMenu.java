package minigolf.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Sovelluksen alkuvalikko, jonka tehtävänä on luoda alkuvalikon käyttöliittymä 
 * ja komponentit.
 * @author zesbr
 */
public class StartMenu extends JPanel {
    
    private ActionListener handler;
    private JPanel menuPanel;
    private JLabel title;
    private JButton gameButton;
    private JButton quitButton;
    
    public StartMenu(ActionListener handler) {       
        super();  
        this.handler = handler;
        this.menuPanel = new JPanel();
        this.title = new JLabel("MINIGOLF");
        this.gameButton = new JButton("NEW GAME");
        this.quitButton = new JButton("QUIT");
        
        init();
        addComponents();    
    }
    
    // Alustaa päävalikon komponentit
    private void init() {
        setLayout(new GridBagLayout());  
        setBackground(new Color(138, 224, 0));
        
        // Päävalikon komponentit sitova paneeli    
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(CENTER_ALIGNMENT);
        menuPanel.setAlignmentY(TOP_ALIGNMENT);
        menuPanel.setBounds(100, 100, 300, 300);
        menuPanel.setOpaque(false);
        
         // Päävalikon otsikko
        title.setFont((new Font("Liberation Sans", Font.BOLD, 50)));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        
        // Päävalikon "NEW GAME" -painike
        gameButton.setFont((new Font("Liberation Sans", Font.BOLD, 20)));
        gameButton.setAlignmentX(CENTER_ALIGNMENT);
        gameButton.setBackground(Color.WHITE);
        gameButton.setForeground(Color.WHITE);
        gameButton.setOpaque(false);
        gameButton.setBorderPainted(false);
        gameButton.setMargin(new Insets(10, 20, 10, 20));
        gameButton.setFocusPainted(false);
        
        // Päävalikon "QUIT" painike
        quitButton.setFont((new Font("Liberation Sans", Font.BOLD, 20)));
        quitButton.setAlignmentX(CENTER_ALIGNMENT);
        quitButton.setBackground(Color.WHITE);
        quitButton.setForeground(Color.WHITE);
        quitButton.setOpaque(false);
        quitButton.setBorderPainted(false);
        quitButton.setMargin(new Insets(10, 50, 10, 50));
        quitButton.setFocusPainted(false);
        
        // Painikkeiden tapahtumakuuntelijat (ViewManager)
        gameButton.addActionListener(handler);
        quitButton.addActionListener(handler);
        
    }
    
    // Lisää päävalikon komponentit
    private void addComponents() {
        menuPanel.add(title);
        menuPanel.add(gameButton);
        menuPanel.add(quitButton); 
        add(menuPanel);
    }

}
