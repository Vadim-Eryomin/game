package StemFight.Runix;

import StemFight.*;

import java.util.HashMap;

public class RuneOfRegeneration extends Player {
    ImageXY field = new ImageXY("Using/field500.png", 0, 0);
    boolean keep = false;
    Piedestal myPiedestal = null;
    int seconds = 0;
    public HashMap<Integer, String> craft = new HashMap<>();

    public RuneOfRegeneration() {
        craft.put(0,"brick");
        craft.put(1,"board");
        craft.put(2,"brick");
        craft.put(3,"brick");
        craft.put(4,"board");
        craft.put(5,"brick");
        craft.put(6,"brick");
        craft.put(7,"board");
        craft.put(8,"brick");
        craft.put(9,"runeOfRegeneration");
    }

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.imageXY = new ImageXY("Using/runeOfRegen.png", 0, 0);
        keep = true;
        field.x = x - imageXY.w/2;
        field.y = y - imageXY.h/2;

    }

    @Override
    public void update(Game game) {
        if (keep) {
            if (myPiedestal != null) {
                x = myPiedestal.x;
                y = myPiedestal.y - imageXY.h;
                field.x = x - field.w/2;
                field.y = y - field.h/2;
                if (myPiedestal.energy >= 1) {
                    if (game.collision(game.hero, field)) {
                        seconds++;
                        myPiedestal.energy--;
                    }
                }
            }
            else {
                if (game.collision(game.pied.field, field)){
                    myPiedestal = game.pied;
                }
            }
        }
        if (seconds >= 60){
            seconds = 0;
            game.hero.hp++;
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        if (imageXY != null) {
            renderer.drawImage(imageXY, x, y);
        }

    }

    @Override
    public void death(Game game) {

    }
}
