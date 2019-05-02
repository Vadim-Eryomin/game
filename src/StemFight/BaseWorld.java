package StemFight;

import Engine.AbsractGame;
import Engine.GameContainer;
import Engine.Image;
import Engine.Renderer;
import StemFight.Buildings.Base;

import java.util.ArrayList;

public class BaseWorld extends Game {
    Image image, portals;
    public BaseWorld(Game game) {

    }

    @Override
    public void update(GameContainer gc, float dt) {
        portal.maked = portals;
        backpack.update(this);
        camera.update(this);
        chars.update(this);
        charFrame.update(this);
        sgf.update(this);
        spf.update(this);
        hero.update(this);
        portal.update(this);
        if (secondsSpawn >=500)spawn(this);
        for (AttackParticle a : attackParticles) a.update(game);
        for (BrickParticle b : brickParticles)b.update(game);
        for (RobotEnemy r : enemy) {
            r.update(game);
            for (int i = 0; i < r.codes.size(); i++){
                if (collision(hero, r.codes.get(i))){
                    r.codes.remove(i);
                    hero.hp-=10;
                }
            }
        }
        for (PaperSnake p:snakes) p.update(this);
        for (Wall w:walls)w.update(this);
        for (Board b:boards) b.update(this);
        secondsSpawn++;


        for (int i = 0; i < attackParticles.size(); i++) { if (attackParticles.get(i).seconds >= attackParticles.get(i).secondsLives) { attackParticles.remove(i); } }
        for (int i = 0; i < walls.size(); i++) { if (walls.get(i).seconds >= walls.get(i).secondsLives) { walls.remove(i); } }
        for (RobotEnemy e : enemy) { for (int i = 0; i < attackParticles.size(); i++) { if (collision(e, attackParticles.get(i) )) { e.hp -= 35; attackParticles.remove(i); } } }
        for (int i = 0; i < snakes.size(); i++) { if (snakes.get(i).hp <= 0){ snakes.remove(i); } }
        for (RobotEnemy e:enemy) { for (PaperSnake p:snakes) { if (collision(e,p)){ e.hp -=100; p.hp -=10; } } }
        for (int i = 0; i < enemy.size(); i++) { if (enemy.get(i).hp <= 0) { enemy.get(i).death(this); enemy.remove(i); } }
        for (int i = 0; i < brickParticles.size(); i++) {if (!brickParticles.get(i).lived){ brickParticles.remove(i);} }
        for (int i = 0; i < boards.size(); i++) {if (!boards.get(i).lived){ boards.remove(i);} }
        for (Enemy e:enemies) { for (int i = 0; i < walls.size(); i++) { if (collision(e,walls.get(i))){ e.hp -= 10; if (e.x > walls.get(i).x) e.x += 100; else e.x-=100; } } }

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        camera.renderer(renderer);
        chars.renderer(renderer);
        charFrame.renderer(renderer);
        portal.renderer(renderer);
        for (AttackParticle a:attackParticles) a.renderer(renderer);
        for(RobotEnemy r: enemy) r.renderer(renderer);
        hero.renderer(renderer);
        for (BrickParticle b: brickParticles) b.renderer(renderer);
        for (PaperSnake p:snakes) p.renderer(renderer);
        for (Wall w:walls) w.renderer(renderer);
        for (Board b:boards)b.renderer(renderer);
        p.update(game);
        sgf.renderer(renderer);
        spf.renderer(renderer);
        chars.renderer(renderer);
        sk.renderer(renderer);
        backpack.renderer(renderer);
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

    @Override
    public boolean collision(Hero A, Code B) {
        return super.collision(A, B);
    }
}
