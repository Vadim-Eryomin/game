package StemFight.Runix;

import StemFight.Game;
import StemFight.ImageXY;
import StemFight.Player;
import StemFight.Renderer;

public class Piedestal extends Player {
    ImageXY field = new ImageXY("",0,0);
    public int energy = 0;
    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.imageXY = new ImageXY("",0,0);
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void renderer(Renderer renderer) {

    }

    @Override
    public void death(Game game) {

    }
    public void search(){

    }
}
