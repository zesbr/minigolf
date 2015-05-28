package minigolf.domain;

public class Hole extends LevelObject {
    
    private final int RADIUS = 20;
    private final int DIAMETER = RADIUS * 2;
    
    public Hole(int x, int y) {
        super(x, y);
    }

    public int getRADIUS() {
        return RADIUS;
    }

    public int getDIAMETER() {
        return DIAMETER;
    }

}