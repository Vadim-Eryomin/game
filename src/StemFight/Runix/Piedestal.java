package StemFight.Runix;

import StemFight.Game;
import StemFight.ImageXY;
import StemFight.Player;
import StemFight.Renderer;

import java.util.HashMap;

public class Piedestal extends Player {
    ImageXY field = new ImageXY("Using/field500.png",0,0);
    RuneEngine myEngine = null;
    boolean keep = false;
    public int energy = 1;
    public HashMap<Integer, String> craft = new HashMap<>();

    public Piedestal() {
        craft.put(0,"brick");
        craft.put(1,"brick");
        craft.put(2,"brick");
        craft.put(3, null);
        craft.put(4,"brick");
        craft.put(5, null);
        craft.put(6,"brick");
        craft.put(7,"brick");
        craft.put(8,"brick");
        craft.put(9,"piedestal");
    }

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.imageXY = new ImageXY("Using/runePiedes.png",0,0);
        keep = true;
        field.x = x - imageXY.w/2;
        field.y = y - imageXY.h/2;
    }

    @Override
    public void update(Game game) {
        if (keep) {
            if (myEngine != null) {
                if (myEngine.energy >= 1) {
                    if (game.collision(myEngine.field, field)) {
                        myEngine.energy--;
                        energy++;
                    }
                }
            }
            else {
                if (game.collision(game.engine.field, field)){
                    myEngine = game.engine;
                }
            }
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
