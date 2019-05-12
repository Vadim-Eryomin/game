package StemFight.Runix;

import StemFight.*;

public class RuneOfRegeneration extends Player {
    ImageXY field = new ImageXY("Using/field500.png", 0, 0);
    boolean keep = false;
    Piedestal myPiedestal = null;
    int seconds = 0;

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
        renderer.drawImage(imageXY, x, y);
    }

    @Override
    public void death(Game game) {

    }
}
