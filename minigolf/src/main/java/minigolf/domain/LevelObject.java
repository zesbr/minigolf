package minigolf.domain;

public abstract class LevelObject implements CollisionManager {
    
    private int x;
    private int y;
    
    public LevelObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" + "x=" + x + ", y=" + y + "}";
    }
     
}
