package StemFight;

import Engine.GameContainer;
import Engine.Image;
import Engine.Renderer;
import StemFight.Buildings.Base;

import java.util.ArrayList;

public class BaseWorld extends Game {
    ArrayList<RobotEnemy> enemies = new ArrayList<>();

    public BaseWorld() {
        game = this;
        secondsSpawn = 0;
        camera.image = new Image("../StemFight/Using/baseWorldFon.gif");
        portal.maked = new Image("../StemFight/Using/electrumPortal");
        enemies.clear();
        snakes.clear();
        walls.clear();
        base.made = false;
        hero.bricks += 5;
        hero.boards += 10;
        base.bf.buildHp = 0;

        portal.create(1000, 0);
        hero.create(200, 0);
        backpack.create(this);
        enemies.add(new RobotEnemy());
        enemies.get(0).create(200,100);
    }

    @Override
    public void update(GameContainer gc, float dt) {
        camera.update(this);
        hero.update(this);
        chars.update(this);
        charFrame.update(this);
        spawn(this);
        if (enemies != null) for (RobotEnemy r : enemies) r.update(this);
    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        camera.renderer(renderer);
        hero.renderer(renderer);
        if (enemies != null)for(RobotEnemy r: enemies) r.renderer(renderer);
    }

    @Override
    public void spawn(Game game) {
        if (secondsSpawn >= 500) {
            secondsSpawn = 0;
            enemies.add(new RobotEnemy());
            enemies.get(enemies.size()-1).create(random.nextInt(1800)+10, random.nextInt(1800)+10);
        }
    }

    @Override
    public boolean collision(Enemy A, Hero B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Hero A, Base B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Enemy A, Wall B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Enemy A, AttackParticle B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Enemy A, Bulik B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Hero A, BrickParticle B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Hero A, Portal B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Enemy A, PaperSnake B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Hero A, Board B) {
        return super.collision(A, B);
    }

    @Override
    public boolean collision(Hero A, Key B) {
        return super.collision(A, B);
    }
}
