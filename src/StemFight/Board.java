package StemFight;

import Engine.Image;
import Engine.Renderer;

public class Board {
    Image brick = new Image("../StemFight/Using/board.png");
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    boolean lived = true;
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = brick.w;
        this.h = brick.h;
    }

    public void update(Game game) {
        if (game.collision(game.hero, this)){
            death(game);
        }
    }

    public void renderer(Renderer renderer) {
        renderer.drawImage(brick, x, y);
    }

    public void death(Game game) {
        game.hero.boards++;
        lived = false;
    }
}
