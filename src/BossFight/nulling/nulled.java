package BossFight.nulling;

import BossFight.AbsractGame;
import BossFight.GameContainer;
import BossFight.Image;
import BossFight.Renderer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class nulled extends AbsractGame {
    public ArrayList<ImageXY> enemy = new ArrayList<>();
    ArrayList<Hero> hero = new ArrayList<>();
    Image fon = new Image("fon.png");
    GameContainer gc = new GameContainer(this);

    boolean lockDown = false;
    boolean lockUp = false;
    boolean lockRight = false;
    boolean lockLeft = false;

    int seconds = 0;
    boolean right = true;

    public nulled() {
        hero.add(new Hero("nulling/PNG/Block/platformPack_tile001.png",0,0));
        hero.get(hero.size()-1).create();
        new CreateMap().create(this);

        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        hero.get(hero.size()-1).update(this);

    }


    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        renderer.drawImage(fon,0,0);
        int x = hero.get(0).x;
        int y = hero.get(0).y;

        ImageXY imageXY = hero.get(0).updater(this);
        for (ImageXY im: hero)renderer.drawImage(imageXY,im.x,im.y);
        for (ImageXY im: enemy)renderer.drawImage(im,im.x,im.y);

    }
    public  void collision(ImageXY e, ImageXY h){
        int relay = 0;
        if (h.x < e.x-1 && h.x + h.w > e.x-1) relay++;
        else if (h.x < e.x-1 + e.w-1 && e.x-1 + e.w-1 < h.x + h.w) relay++;
        if (h.y < e.y && h.y + h.h > e.y) relay++;
        else if (h.y < e.y + e.h && e.y + e.h < h.y + h.h) relay++;
        if (relay == 2){
            if (h.y < e.y && h.y + h.h > e.y) h.y--;
            if (h.y < e.y + e.h && e.y + h.h < h.y + h.h) h.y++;
        }
    }
    public boolean isCollision(ImageXY e, ImageXY h){
        int relay = 0;
        if (h.x < e.x-1 && h.x + h.w > e.x-1) relay++;
        else if (h.x < e.x-1 + e.w-1 && e.x-1 + e.w-1 < h.x + h.w) relay++;
        if (h.y < e.y && h.y + h.h > e.y) relay++;
        else if (h.y < e.y + e.h && e.y + e.h < h.y + h.h) relay++;
        if (relay == 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new nulled();
    }

}
