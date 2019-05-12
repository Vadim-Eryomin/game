package StemFight.Runix;

import StemFight.Game;
import StemFight.ImageXY;
import StemFight.Player;
import StemFight.Renderer;

public class Piedestal extends Player {
    ImageXY field = new ImageXY("Using/field500.png",0,0);
    RuneEngine myEngine = null;
    boolean keep = false;
    public int energy = 1;
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
        System.out.println(energy);
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
        renderer.drawImage(imageXY, x, y);
    }

    @Override
    public void death(Game game) {

    }
    public void search(){

    }
}
