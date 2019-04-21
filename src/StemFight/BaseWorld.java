package StemFight;

import Engine.GameContainer;
import Engine.Image;
import Engine.Renderer;
import StemFight.Buildings.Base;

public class BaseWorld extends Game {
    public BaseWorld() {
        game = this;
        secondsSpawn = 0;
        camera.image = new Image("../StemFight/Using/baseWorldFon.gif");
        portal.maked = new Image("../StemFight/Using/electrumPortal");
    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        System.out.println("eeeeee!");
    }

    @Override
    public void spawn(Game game) {

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
