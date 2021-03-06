package StemFight;

import Engine.Image;
import Engine.Player;
import Engine.Renderer;

public class Gear extends AttackParticle implements Player {
    Image particle = new Image("../StemFight/Skills/attGear.png");

    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;

    int secondsLived = 0;

    boolean up = false;
    boolean right = false;
    boolean left = false;
    boolean down = false;

    @Override
    public void update(Game game) {
        super.seconds = secondsLived;
        super.up = up;
        super.left = left;
        super.right = right;
        super.down = down;
        x = super.x;
        y = super.y;
        super.update(game);
    }

    @Override
    public void renderer(Renderer renderer) {
        super.particle = this.particle;
        super.x = x;
        super.y = y;
        super.renderer(renderer);
    }

    @Override
    public void create(Game game) {
        super.secondsLives = 750;
        super.particle = particle;
        super.create(game);
        up = super.up;
        down = super.down;
        right = super.right;
        left = super.left;
    }

    @Override
    public void death(Game game) {
        super.death(game);
    }
}
