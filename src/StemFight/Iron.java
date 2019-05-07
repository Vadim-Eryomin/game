package StemFight;

import Engine.Image;
import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;

public class Iron implements Player {
    ImageXY iron = new ImageXY("../StemFight/Using/iron.png",0,0);
    boolean lived = true;
    @Override
    public void create(int x, int y) {
        iron.x = x;
        iron.y = y;
    }

    @Override
    public void update(Game game) {
        if (game.collision(game.hero, iron)){
            death(game);
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(iron, x, y);
    }

    @Override
    public void death(Game game) {
        game.hero.irons++;
        lived = false;
    }
}
