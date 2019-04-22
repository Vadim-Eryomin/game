package StemFight;

import Engine.AbsractGame;
import Engine.GameContainer;
import Engine.Image;
import Engine.Renderer;
import StemFight.Buildings.Base;

import java.util.ArrayList;

public class BaseWorld extends Game {

    public BaseWorld(Game game) {
        this.game = game;
        camera.image = new Image("../StemFight/Using/baseWorldFon.gif");
        portal.maked = new Image("../StemFight/Using/electrumPortal");
        hero.bricks += 5;
        hero.boards += 10;
        portal.create(1000, 0);
        hero.create(200, 0);
        backpack.create(this);
        enemy.add(new RobotEnemy());
        enemy.get(0).create(200,100);
    }

    @Override
    public void update(GameContainer gc, float dt) {
        camera.update(this);
        chars.update(this);
        charFrame.update(this);
        hero.update(this);
        if (secondsSpawn >=500)spawn(this);
        for (RobotEnemy r : enemy) r.update(game);
        secondsSpawn++;

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        camera.renderer(renderer);
        chars.renderer(renderer);
        charFrame.renderer(renderer);
        for(RobotEnemy r: enemy) r.renderer(renderer);
        portal.renderer(renderer);
        hero.renderer(renderer);
    }

    @Override
    public void spawn(Game game) {
        if (enemy.size() <= 5){
            secondsSpawn = 0;
            enemy.add(new RobotEnemy());
            enemy.get(enemy.size()-1).create(random.nextInt(1800)+10, random.nextInt(1800)+10);
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
