package StemFight;

import Engine.Image;
import Engine.Player;
import Engine.Renderer;

public class Wall extends AttackParticle implements Player {
    Image particle = new Image("../StemFight/Skills/attWall.png");

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
        super.seconds++;
        x = super.x;
        y = super.y;
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
        super.secondsLives = 1000;
        super.particle = particle;

        this.x = game.hero.x + game.hero.w;
        this.y = game.hero.y + 5;
        this.w = particle.w;
        this.h = particle.h;

        super.x = this.x;
        super.y = this.y;
        super.h = this.h;
        super.w = this.w;

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
