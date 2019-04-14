package BossFight;



import BossFight.nulling.ImageXY;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import static BossFight.Max.range;
import static BossFight.Colllision.*;

public class GameManager extends AbsractGame {

    ArrayList<Integer> texts = new ArrayList<>();



    Collision c = new Collision();

    public int secondsRespawn = 0;
    public Random random = new Random();
    float cameraX = 0;
    float cameraY = 0;
    float heroX = 0;
    float heroY = 0;
    Map map = new Map("fon.png");
    hero hero = new hero("Hero.png",0,0);
    Attack attack = new Attack(this);
    ArrayList<Enemy> enemys = new ArrayList<>();
    Enemy enemy;
    GameContainer gc = new GameContainer(this);


    public GameManager() {
        hero.create();
        map.create();
        for (int i = 0; i < 1; i++) {
            enemys.add(new Enemy("Hero.png",0,0));
            enemy = enemys.get(i);
            enemy.create(1800 + i * 200, 500);
        }


        gc.start();
    }

    Dimension d = new Dimension(1400, 900);
    int coef = map.w / d.width;

    @Override
    public void update(GameContainer gc, float dt) {
        enemy = enemys.get(0);
        hero.update(this);
        attack.update(this);
//        enemy.spawn(this);
        new CameraAndHero().setCameraAndHero(this);
        try {Thread.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
        for (Enemy e:enemys) {
            e.update(this, (int) heroX, (int) heroY, hero);
            if (e.hp <= 0) enemys.remove(e);
        }

        if (hero.hp <= 0) {
            heroX = 0;
            heroY = 0;
        }
        if (gc.input.isButtonDown(1))attack.create(this);
        for (Enemy e:enemys) {
            collision(e,hero);
        }
        secondsRespawn++;
    }


    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        map.draw(this, renderer);
        if (!enemys.isEmpty()) {
            for (int i = 0; i < enemys.size(); i++) {
                enemys.get(i).draw(renderer);
            }
        }
        attack.draw(renderer);
        renderer.drawText("HP:" + hero.hp, 0, 0, 0xffffff);
        renderer.drawText("XP:" + hero.xp, 0, 20, 0xffffff);
    }
//    public  void collision(ImageXY e, ImageXY h){
//        int relay = 0;
//        if (h.x < e.x-1 && h.x + h.w > e.x-1) relay++;
//        else if (h.x < e.x-1 + e.w-1 && e.x-1 + e.w-1 < h.x + h.w) relay++;
//        if (h.y < e.y && h.y + h.h > e.y) relay++;
//        else if (h.y < e.y + e.h && e.y + e.h < h.y + h.h) relay++;
//        if (relay == 2){
//            if (h.y < e.y && h.y + h.h > e.y) h.y--;
//            if (h.y < e.y + e.h && e.y + h.h < h.y + h.h) h.y++;
//        }
//    }
    public boolean collision(ImageXY A, ImageXY B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;


        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;


        return true;
    }

    public static void main(String[] args) {
        new GameManager();
    }

}
