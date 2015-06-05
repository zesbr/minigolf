package minigolf;

import javax.swing.SwingUtilities;

/**
 * Sovelluksen käynnistävä luokka, joka sisältää main metodin, jossa luodaan 
 * uusi sovellus-instanssi ja käynnistetään sovellus.
 * @author zesbr
 */
public class Main {
    
    public static void main(String[] args) {
        App app = new App();
        SwingUtilities.invokeLater(app);
    }
    
}
