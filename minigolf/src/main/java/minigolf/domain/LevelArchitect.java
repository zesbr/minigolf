package minigolf.domain;

/**
 * Kenttäarkkitehti eli luokka, joka vastaa kenttien rakentamisesta
 * @author zesbr
 */
public class LevelArchitect {
    
    /**
     * Rakentaa ja palauttaa kentän parametrina saadun kentän numeron perusteella  
     * @param id : kentän numero
     * @return uusi kenttä
     */
    public static Level buildLevel(int id) {  
        
        switch (id) {
            case 1:
                return level01();
            case 2:
                return level02();
            case 3:
                return level03();
            case 4:
                return level04();
            case 5:
                return level05();
            case 6:
                return level06();
            case 7:
                return level07();
            case 8:
                return level08();
            case 9:
                return level09();
            default:
                return level01();
        }

    }
    
    // Kenttä #1
    private static Level level01() {
        Level level = new Level(0, 0, 800, 600, new Tee(390, 540), new Hole(385, 60), "1");
        return level;
    }
    
    // Kenttä #2
    private static Level level02() {
        Level level = new Level(0, 0, 800, 600, new Tee(390, 540), new Hole(385, 60), "2");
        level.addObstacle(new Obstacle(200, 200, 400, 20));
        return level;
    }
    
    // Kenttä #3
    private static Level level03() {
        Level level = new Level(0, 0, 800, 600, new Tee(390, 550), new Hole(120, 500), "3");
        level.addObstacle(new Obstacle(120, 100, 580, 20));
        level.addObstacle(new Obstacle(340, 200, 20, 380));
        level.addObstacle(new Obstacle(580, 200, 20, 200));
        return level;
    }
    
    // Kenttä #4
    private static Level level04() {
        Level level = new Level(0, 0, 800, 600, new Tee(100, 550), new Hole(650, 100), "4");
        level.addObstacle(new Obstacle(200, 200, 580, 20));
        level.addObstacle(new Obstacle(20, 400, 580, 20));
        return level;
    }
    
    // Kenttä #5
    private static Level level05() {
        Level level = new Level(0, 0, 800, 600, new Tee(700, 350), new Hole(95, 500), "5");
        level.addObstacle(new Obstacle(200, 150, 20, 530));
        level.addObstacle(new Obstacle(350, 20, 20, 120));
        level.addObstacle(new Obstacle(350, 200, 20, 120));
        level.addObstacle(new Obstacle(220, 400, 560, 20));
        return level;
    }
    
    // Kenttä #6
    // HUOM! TÄSSÄ ON BUGI ELI JÄÄ KULMAAN KIINNI TOISELLA LYÖNNILLÄ DEFAULT LYÖNTIARVOILLA. 
    // JOHTUU HUONOSTA TÖRMÄYKSEN AIHEUTTAMASTA KULMAN LASKENNASTA JOS PALLO OSUU ESTEEN KULMAAN
    private static Level level06() {
        Level level = new Level(0, 0, 800, 600, new Tee(105, 500), new Hole(680, 350), "6");
        level.addObstacle(new Obstacle(200, 150, 20, 530));
        level.addObstacle(new Obstacle(220, 150, 360, 20));
        level.addObstacle(new Obstacle(580, 150, 20, 530));
        return level;
    }
    
    // Kenttä #7
    private static Level level07() {
        Level level = new Level(0, 0, 800, 600, new Tee(390, 290), new Hole(400, 50), "7");
        level.addObstacle(new Obstacle(200, 100, 40, 40));
        level.addObstacle(new Obstacle(560, 100, 40, 40));
        level.addObstacle(new Obstacle(200, 460, 40, 40));
        level.addObstacle(new Obstacle(560, 460, 40, 40));
        return level;
    }
    
    
    // TODO: Kenttä #8
    private static Level level08() {
        Level level = new Level(0, 0, 800, 600, new Tee(600, 120), new Hole(110, 125), "8");
        level.addObstacle(new Obstacle(220, 0, 20, 120));
        level.addObstacle(new Obstacle(220, 180, 20, 120));
        level.addObstacle(new Obstacle(20, 280, 200, 20));
        level.addObstacle(new Obstacle(360, 110, 20, 100));
        level.addObstacle(new Obstacle(320, 280, 400, 20));
        return level;
    }
    
    // Kenttä #9
    private static Level level09() {
        Level level = new Level(0, 0, 800, 600, new Tee(400, 550), new Hole(385, 75), "9");
        level.addObstacle(new Obstacle(20, 80, 300, 20));
        level.addObstacle(new Obstacle(480, 80, 300, 20));
        int startX = 60;
        for (int y = 160; y < 440; y+=80) {  
            for (int x = startX; x < 740; x+=80) {
                level.addObstacle(new Obstacle(x, y, 40, 40));
            }
            if (startX == 60) {
                startX = 100;
            } else {
                startX = 60;
            }
        }
        level.addObstacle(new Obstacle(20, 480, 300, 20));
        level.addObstacle(new Obstacle(480, 480, 300, 20));
        return level;
    }
    
    
}
