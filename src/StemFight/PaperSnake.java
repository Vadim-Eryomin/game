package StemFight;

import Engine.Image;
import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;

public class PaperSnake implements Player {
    Image[] snakes = new Image[4];
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;

    int hp = 1;

    boolean right = false;

    int seconds = 0;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        snakes[0] = new Image("../StemFight/Using/snake_walk1.png");
        snakes[1] = new Image("../StemFight/Using/snake_walk2.png");
        snakes[2] = new Image("../StemFight/Using/snake_walk1L.png");
        snakes[3] = new Image("../StemFight/Using/snake_walk2L.png");
        this.w = snakes[0].w;
        this.h = snakes[0].h;
    }

    @Override
    public void update(Game game) {
        if (!game.enemies.isEmpty()){
            if (!(game.enemies.get(0).x == x)) {
                if (game.enemies.get(0).x < x) {
                    right = false;
                    seconds++;
                    x--;
                } else {
                    right = true;
                    seconds++;
                    x++;
                }
            }
            if (!(game.enemies.get(0).y == y)){
                if (game.enemies.get(0).y < y) {
                    seconds++;
                    y--;
                } else {
                    seconds++;
                    y++;
                }
            }
        }

    }

    @Override
    public void renderer(Renderer renderer) {
        if (right) {
            if (0 < seconds % 60 && seconds % 60 <= 30) renderer.drawImage(snakes[0], x, y);
            if (30 < seconds % 60 && seconds % 60 <= 60) renderer.drawImage(snakes[1], x, y);
        } else {
            if (0 < seconds % 60 && seconds % 60 <= 30) renderer.drawImage(snakes[2], x, y);
            if (30 < seconds % 60 && seconds % 60 <= 60) renderer.drawImage(snakes[3], x, y);
        }
    }

    @Override
    public void death(Game game) {

    }
}
