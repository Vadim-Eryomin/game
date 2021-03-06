package StemFight;

import Engine.*;
import StemFight.Buildings.Base;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game extends AbsractGame {
    Game game = this;

    Random random = new Random();
    portalRenderer p = new portalRenderer();

    int secondsSpawn = 0;

    Camera camera = new Camera();
    public Hero hero = new Hero();
    Portal portal = new Portal();

    CharFrame charFrame = new CharFrame();

    Base base = new Base();

    skillsGraphFrame sgf = new skillsGraphFrame();
    skillsProgFrame spf = new skillsProgFrame();

    boolean talkWalk = false;
    boolean talkPick = false;
    boolean win = false;
    boolean spawnZombies = true;

    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<AttackParticle> attackParticles = new ArrayList<>();
    ArrayList<BrickParticle> brickParticles = new ArrayList<>();
    ArrayList<PaperSnake> snakes = new ArrayList<>();
    ArrayList<Wall> walls = new ArrayList<>();

    Characteristics chars = new Characteristics();

    SkillsTerminal sk = new SkillsTerminal();

    public GameContainer gc = new GameContainer(this);

    public Game() {
        gc.title = "Stem Fight Version A0.4";

        sgf.create(0,100);
        sgf.setVisible(true);

        spf.create(0,300);
        spf.setVisible(true);

        chars.create(1100,0);

        sk.create(0,700);

        charFrame.create(0,0);
        charFrame.setVisible(true);


        portal.create(1000, 1000);
        hero.create(50, 50);
        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        sk.update(this);
        if (gc.input.isKeyDown(KeyEvent.VK_R) && !base.made) base.create(0,500,hero.x, hero.y);
        if (base != null) {
            base.update(this);
        }
        chars.update(this);
        charFrame.update(this);
        sgf.update(this);
        spf.update(this);
        hero.update(this);
        portal.update(this);
        camera.update(this);

        for (AttackParticle a : attackParticles) a.update(game);
        for (BrickParticle b : brickParticles)b.update(game);
        for (Enemy e : enemies) e.update(this);
        for (PaperSnake p:snakes) p.update(this);
        for (Wall w:walls)w.update(this);

        if (spawnZombies)spawn(this);
        secondsSpawn++;

        for (int i = 0; i < attackParticles.size(); i++) { if (attackParticles.get(i).seconds >= attackParticles.get(i).secondsLives) { attackParticles.remove(i); } }
        for (int i = 0; i < walls.size(); i++) { if (walls.get(i).seconds >= walls.get(i).secondsLives) { walls.remove(i); } }
        for (int i = 0; i < snakes.size(); i++) { if (snakes.get(i).hp <= 0){ snakes.remove(i); } }
        for (Enemy e:enemies) { for (PaperSnake p:snakes) { if (collision(e,p)){ e.hp -=100; p.hp -=10; } } }
        for (int i = 0; i < enemies.size(); i++) { if (enemies.get(i).hp <= 0) { enemies.get(i).death(this); enemies.remove(i); } }
        for (Enemy e : enemies) { if (collision(e, hero)) { hero.hp -= 5; e.hp -= 20;
            new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            hero.x--;
                            e.x++;
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        }
        for (int i = 0; i < brickParticles.size(); i++) {if (!brickParticles.get(i).lived){ brickParticles.remove(i);} }
        for (Enemy e:enemies) { for (int i = 0; i < walls.size(); i++) { if (collision(e,walls.get(i))){ e.hp -= 10; if (e.x > walls.get(i).x) e.x += 100; else e.x-=100; } } }
    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        camera.renderer(renderer);
        charFrame.renderer(renderer);
        portal.renderer(renderer);
        base.renderer(renderer);
        for (AttackParticle a : attackParticles) a.renderer(renderer);
        hero.renderer(renderer);
        for (Enemy e : enemies) e.renderer(renderer);
        for (BrickParticle b:brickParticles)b.renderer(renderer);
        for (PaperSnake p: snakes) p.renderer(renderer);
        for (Wall w: walls)w.renderer(renderer);
        p.update(this);
        sgf.renderer(renderer);
        spf.renderer(renderer);
        chars.renderer(renderer);
        sk.renderer(game,renderer);
    }

    public void spawn(Game game) {
        if (game.secondsSpawn >= 800 && game.enemies.size() < 5) {
            game.secondsSpawn = 0;
            enemies.add(new Enemy());
            enemies.get(enemies.size() - 1).create(random.nextInt(1800), random.nextInt(1800));
        }
    }
    public boolean collision(Enemy A, Hero B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Hero A, Base B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.base.x;
        int objBMaxX = B.base.x + B.base.w;
        int objBMinY = B.base.y;
        int objBMaxY = B.base.y + B.base.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Enemy A, Wall B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Enemy A, AttackParticle B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Enemy A, Bulik B){
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Hero A, BrickParticle B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Hero A, Portal B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }
    public boolean collision(Enemy A, PaperSnake B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }

    public static void main(String[] args) {
        new Game();
    }
}
