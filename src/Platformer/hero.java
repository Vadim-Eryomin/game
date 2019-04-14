package Platformer;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class hero extends Image {
    ArrayList<Image> d = new ArrayList<>();
    ArrayList<Integer> drew = new ArrayList<>();

    public hero(String path) {
        super(path);

    }

    boolean right = true;
    boolean left = false;
    // для других классов
    boolean down = false;
    boolean up = false;
    //*******************
    int hp = 100;
    int seconds = 0;
    int x = 0;
    int y = 0;
    int w = new Image("PNG/Adventurer/Poses/adventurer_standAT.png").w;
    int h = new Image("PNG/Adventurer/Poses/adventurer_standAT.png").h;
    int xp = 0;

    public void create(int x, int y) {
        d.add(new Image("PNG/Adventurer/Poses/adventurer_standAT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk1AT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk2AT.png"));

        d.add(new Image("PNG/Adventurer/Poses/adventurer_standLAT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk1LAT.png"));
        d.add(new Image("PNG/Adventurer/Poses/adventurer_walk2LAT.png"));

        this.x = x;
        this.y = y;
    }

    public void update(GameManager gm, boolean lockDown) {
        motions(gm, lockDown);
    }

    public void motions(GameManager gm, boolean lockDown) {
        if (gm.gc.input.isKeyUp(KeyEvent.VK_D) || gm.gc.input.isKeyUp(KeyEvent.VK_A) || gm.gc.input.isKeyUp(KeyEvent.VK_W) || gm.gc.input.isKeyUp(KeyEvent.VK_S)) {
            seconds = 0;
        }
        if (gm.gc.input.isKey(KeyEvent.VK_D) && ! lockDown) {
            right = true;
            left = false;
            x+=1;
            seconds++;

        }
        if (gm.gc.input.isKey(KeyEvent.VK_A)) {
            right = false;
            left = true;
            x-=1;
            seconds++;

        }
        if (gm.gc.input.isKeyDown(KeyEvent.VK_W) || gm.gc.input.isKeyDown(KeyEvent.VK_SPACE)) {
            new Thread(){
                public void run(){
                    for (int i = 0; i < 20; i++) {
                        y-=20-i;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int i = 0; i < 20; i++) {
                        y+=i;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();

        }

        if (gm.gc.input.isKey(KeyEvent.VK_S)) {
            y+=1;
            seconds++;

        }
    }

    public void draw(Renderer renderer, int x, int y) {
        if (right) {
            if (seconds == 0) {
                renderer.drawImageUp(d.get(0), x, y, drew);
            } else if (0 < seconds % 60 && seconds % 60 < 30) {
                renderer.drawImageUp(d.get(1), x, y, drew);
            } else {
                renderer.drawImageUp(d.get(2), x, y, drew);
            }
        }
        if (left) {
            if (seconds == 0) {
                renderer.drawImageUp(d.get(3), x, y, drew);
            } else if (0 < seconds % 60 && seconds % 60 < 30) {
                renderer.drawImageUp(d.get(4), x, y, drew);
            } else {
                renderer.drawImageUp(d.get(5), x, y, drew);
            }
        }
        this.x = x;
        this.y = y;


    }
    int ex = 0;
    int ey = 0;
}
