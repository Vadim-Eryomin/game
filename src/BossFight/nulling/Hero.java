package BossFight.nulling;

import BossFight.GameContainer;
import BossFight.Image;
import BossFight.Renderer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static BossFight.Max.range;

public class Hero extends ImageXY {
    public ArrayList<ImageXY> heros = new ArrayList<>();
    int x = 0;
    int y = 0;


    public Hero(String path, int x, int y) {
        super(path, x, y);
    }

    public void create() {
        heros.add(new ImageXY("nulling/PNG/Adv/adventurer_stand.png", x, y));
        heros.add(new ImageXY("nulling/PNG/Adv/adventurer_walk1.png", x, y));
        heros.add(new ImageXY("nulling/PNG/Adv/adventurer_walk2.png", x, y));
        heros.add(new ImageXY("nulling/PNG/Adv/adventurer_standL.png", x, y));
        heros.add(new ImageXY("nulling/PNG/Adv/adventurer_walk1L.png", x, y));
        heros.add(new ImageXY("nulling/PNG/Adv/adventurer_walk2L.png", x, y));
    }

    public void update(nulled nulled) {
        for (ImageXY he : nulled.hero) {
            if (!nulled.lockUp) he.y++;
            if (nulled.gc.input.isKeyDown(KeyEvent.VK_W) && !nulled.lockUp || nulled.gc.input.isKeyDown(KeyEvent.VK_SPACE) && !nulled.lockUp) {
                new Thread() {
                    public void run() {
                        int seconds = 3;
                        int ups = 70;
                        for (int i = 0; i < ups; i++) {
                            nulled.lockUp = true;
                            he.y -= 2;
                            try {
                                Thread.sleep(seconds);
                            } catch (InterruptedException e) {
                            }
                        }
                        for (int i = 0; i < ups; i++) {
                            he.y += 2;
                            try {
                                Thread.sleep(seconds);
                            } catch (InterruptedException e) {
                            }
                        }
                        nulled.lockUp = false;
                    }
                }.start();
            }
            if (nulled.gc.input.isKey(KeyEvent.VK_A) && !nulled.lockLeft) {
                he.x--;
                nulled.right = false;
            }
            if (nulled.gc.input.isKey(KeyEvent.VK_D) && !nulled.lockRight) {
                he.x++;
                nulled.right = true;
            }
            he.x = range(he.x, 0, 1400 - heros.get(0).w);
            he.y = range(he.y, 0, 900 - heros.get(0).h);
        }
        if (nulled.gc.input.isKeyUp(KeyEvent.VK_W) || nulled.gc.input.isKeyUp(KeyEvent.VK_A) || nulled.gc.input.isKeyUp(KeyEvent.VK_S) || nulled.gc.input.isKeyUp(KeyEvent.VK_D))
            nulled.seconds = 0;
        if (nulled.gc.input.isKey(KeyEvent.VK_W) || nulled.gc.input.isKey(KeyEvent.VK_A) || nulled.gc.input.isKey(KeyEvent.VK_S) || nulled.gc.input.isKey(KeyEvent.VK_D))
            nulled.seconds++;
        for (ImageXY en : nulled.enemy) for (ImageXY he : nulled.hero) nulled.collision(en, he);


    }

    public ImageXY updater(nulled nulled) {
        if (nulled.right) return heros.get(nulled.seconds / 30 % 3);
        else return heros.get((nulled.seconds / 30 % 3) + 3);
    }
}
