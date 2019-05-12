package StemFight.Runix;

import StemFight.*;

public class RuneOfRegeneration extends Player {
    ImageXY field = new ImageXY("Using/field500.png",0,0);
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
}
