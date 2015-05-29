package minigolf.domain;

public abstract class LevelObject implements CollisionManager {
    
    private int x;
    private int y;
    
    public LevelObject(int x, int y) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
        
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
     
    public void setX(int x) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }
     
}
