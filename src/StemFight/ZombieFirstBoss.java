package StemFight;

import Engine.Image;
import Engine.Renderer;

public class ZombieFirstBoss extends Enemy{
    @Override
    public void create(int x, int y) {
        super.hp = 200;
        this.x = x;
        this.y = y;
        d.add(new Image("../StemFight/Using/zombie_standBoss.png"));
        d.add(new Image("../StemFight/Using/zombie_walk1Boss.png"));
        d.add(new Image("../StemFight/Using/zombie_walk2Boss.png"));
        d.add(new Image("../StemFight/Using/zombie_standLBoss.png"));
        d.add(new Image("../StemFight/Using/zombie_walk1LBoss.png"));
        d.add(new Image("../StemFight/Using/zombie_walk2LBoss.png"));
        this.w = d.get(0).w;
        this.h = d.get(0).h;
    }

    @Override
    public void update(Game game) {
        super.update(game);
    }

    @Override
    public void renderer(Renderer renderer) {
        super.renderer(renderer);
    }

    @Override
    public void death(Game game) {
        game.preWin = true;
        game.hero.xp += 200;
        game.key = new Key();
        game.key.create(this.x, this.y);
    }
}
