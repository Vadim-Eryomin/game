package Platformer;
import java.util.ArrayList;

public class Enemy extends hero {
    ArrayList<Image> d = new ArrayList<>();
    String path = "";
    public Enemy(String path) {
        super(path);
    }

    boolean right = true;

    int x = 0;
    int y = 0;

//    public void create(GameManager gm) {
//        gm.enemy = new Enemy(path);
//        d.add(new Image("Platformer.PNG/Zombie/Poses/zombie_walk1.png"));
//    }
//
//    public void update(GameManager gm) {
//        gm.enemy.lastPosX = gm.enemy.posX;
//        gm.enemy.lastPosY = gm.enemy.posY;
//        gm.enemy.posX = 100;
//        gm.enemy.posY = 100;
//        gm.enemy.image = new Image("Platformer.PNG/Zombie/Poses/zombie_walk1.png");
//    }
//
//    public void draw(GameManager gm, Renderer renderer) {
//        renderer.drawImage(gm.enemy.image, posX, posY);
//    }
}
