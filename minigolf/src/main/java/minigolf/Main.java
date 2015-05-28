package minigolf;

/**
 * Ohjelman käynnistävä luokka, joka sisältää main metodin. Luokan main
 * metodista luodaan uusi App instanssi, sekä kutsutaan ohjelmaa ajavaa run 
 * metodia.
 * @author zesbr
 */
public class Main {
    
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    
}
