package BossFight;

import BossFight.nulling.ImageXY;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class hero extends ImageXY {
    ArrayList<Integer> drawed =  new ArrayList<>();

    public hero(String path, int x, int y) {
        super(path, x, y);
    }

    public boolean right = true;
    public boolean left = false;
    // для других классов
    public boolean down = false;
    public boolean up = false;
    //*******************
    public int hp = 100;
    public int seconds = 0;
    public int x = 0;
    public int y = 0;
    public int xp = 0;
    ArrayList<Image> d = new ArrayList<>();
    public void create(){
        d.add(new Image("PNG/Adventurer/Poses/adventurer_standAT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk1AT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk2AT.png"));

        d.add(new Image("PNG/Adventurer/Poses/adventurer_standLAT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk1LAT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk2LAT.png"));

    }
    public void update(GameManager gm){
        motions(gm);
    }
    public void motions(GameManager gm){
        if (gm.gc.input.isKey(KeyEvent.VK_D)){
            right = true;
            left = false;
            seconds++;
            gm.heroX++;
        }
        if (gm.gc.input.isKeyUp(KeyEvent.VK_D) || gm.gc.input.isKeyUp(KeyEvent.VK_A) || gm.gc.input.isKeyUp(KeyEvent.VK_W) || gm.gc.input.isKeyUp(KeyEvent.VK_S)){
            seconds = 0;
        }
        if (gm.gc.input.isKey(KeyEvent.VK_A)){
            right = false;
            left = true;
            seconds++;
            gm.heroX--;
        }
        if (gm.gc.input.isKey(KeyEvent.VK_W)){

            seconds++;
            gm.heroY--;
        }
        if (gm.gc.input.isKey(KeyEvent.VK_S)){
            seconds++;
            gm.heroY++;
        }
    }
    public void draw(Renderer renderer, int x, int y){
        if (right){
            if (seconds == 0){
                renderer.drawImage(d.get(0),x,y);
            }
            else if (0 < seconds % 60 && seconds % 60 < 30){
                renderer.drawImage(d.get(1),x,y);
            }
            else {
                renderer.drawImage(d.get(2),x,y);
            }
        }
        if (left){
            if (seconds == 0){
                renderer.drawImage(d.get(3),x,y);
            }
            else if (0 < seconds % 60 && seconds % 60 < 30){
                renderer.drawImage(d.get(4),x,y);
            }
            else {
                renderer.drawImage(d.get(5),x,y);
            }
        }
        this.x = x;
        this.y = y;


    }
}
