package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Renderer;
import StemFight.Building;
import StemFight.Game;

import java.awt.event.KeyEvent;

public class Base extends Building {
    public boolean made = false;
    public ImageXY base = new ImageXY("../StemFight/Using/base.png",0,0);
    public BaseFrame bf = new BaseFrame();
    public void create(int x, int y, int createX, int createY) {
        base.x = createX;
        base.y = createY;
        bf.create(x,y);
        made = true;
    }

    @Override
    public void update(Game game) {
        if (game.gc.input.isKeyDown(KeyEvent.VK_G)){
            if (game.collision(game.hero, this)) bf.update(game);
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        bf.renderer(renderer);
        if (made) renderer.drawImage(base, base.x, base.y);
    }
}
