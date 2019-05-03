package StemFight;

import Engine.*;
import StemFight.Buildings.Base;
import StemFight.Buildings.CraftingFrame;
import StemFight.Buildings.CraftingTable;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game extends AbsractGame {
    Key key;

    Game game = this;
    Game alls = this;

    Random random = new Random();
    portalRenderer p = new portalRenderer();

    int secondsSpawn = 0;

    public Camera camera = new Camera();
    public Hero hero = new Hero();
    public Portal portal = new Portal();

    public CharFrame charFrame = new CharFrame();

    public Cursor cursor = new Cursor();

    Base base = new Base();
    public Backpack backpack = new Backpack();
    CraftingTable craftingTable = new CraftingTable();

    skillsGraphFrame sgf = new skillsGraphFrame();
    skillsProgFrame spf = new skillsProgFrame();

    boolean talkWalk = false;
    boolean talkPick = false;
    boolean pickBlocks = false;
    boolean pickBoards = false;
    boolean pleasePress = false;

    boolean preWin = false;
    boolean win = false;
    boolean reverse = true;

    boolean spawnZombies = true;
    boolean spawnRobots = false;

    boolean firstUpdate = true;
    boolean firstRender = true;
    boolean secondUpdate = false;
    boolean secondRender = false;

    boolean going = false;
    boolean preGoing = false;

    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<RobotEnemy> enemy = new ArrayList<>();
    ArrayList<AttackParticle> attackParticles = new ArrayList<>();
    ArrayList<BrickParticle> brickParticles = new ArrayList<>();
    ArrayList<PaperSnake> snakes = new ArrayList<>();
    ArrayList<Wall> walls = new ArrayList<>();
    ArrayList<Board> boards = new ArrayList<>();

    Characteristics chars = new Characteristics();

    SkillsTerminal sk = new SkillsTerminal();
    UpdateCore updateCore = new UpdateCore();
    Image image;
    Image portals;
    ImageXY loading = new ImageXY("../StemFight/Using/loading.png",0,0);

    int heal = 0;

    SkillsTree skt = new SkillsTree();

    public GameContainer gc = new GameContainer(this);

    public Game() {
        gc.title = "Stem Fight Version A0.8";
        skt.create(0, 100);
        skt.setVisible(true);
        chars.create(1100, 0);
        sk.create(0, 700);
        charFrame.create(0, 0);
        charFrame.setVisible(true);
        portal.create(1000, 0);
        hero.create(50, 50);
        backpack.create(1150, 200);
        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if (hero.shovels >= 1 && !has("shovel")) backpack.addThings("shovel");
        if (hero.boards >= 1 && !has("board")) backpack.addThings("board");
        if (hero.craftingTables >= 1 && !has("crafts")) backpack.addThings("crafts");
        if (hero.baseBottoms >= 1 && !has("baseBottom")) backpack.addThings("baseBottom");
        if (hero.baseWalls >= 1 && !has("baseWall")) backpack.addThings("baseWall");
        if (hero.baseRoofs >= 1 && !has("baseRoof")) backpack.addThings("baseRoof");

        if (firstUpdate){
            updateCore.updateFirst(this);
        }

        if (!firstUpdate && !secondUpdate){
            image = new Image("../StemFight/Using/baseWorldFon.gif");
            portals = new Image("../StemFight/Using/electrumPortal.png");
            enemy.add(new RobotEnemy());
            enemy.get(0).create(200,100);
            secondUpdate = true;
            secondRender = true;
        }
        if (secondUpdate){
            updateCore.updateSecond(this);
        }

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        if (firstRender) {
            camera.renderer(renderer);
            skt.renderer(renderer);
            base.renderer(renderer);
            charFrame.renderer(renderer);
            portal.renderer(renderer);
            craftingTable.renderer(renderer);
            for (AttackParticle a : attackParticles) a.renderer(renderer);
            if (key != null) key.renderer(renderer);
            hero.renderer(renderer);
            for (Enemy e : enemies) e.renderer(renderer);
            for (BrickParticle b : brickParticles) b.renderer(renderer);
            for (PaperSnake p : snakes) p.renderer(renderer);
            for (Wall w : walls) w.renderer(renderer);
            for (Board b : boards) b.renderer(renderer);
            p.update(this);
            chars.renderer(renderer);
            backpack.renderer(renderer);
            cursor.renderer(renderer);
        }
        if (preGoing){
            renderer.drawImage(loading, loading.x, loading.y);
        }
        if (secondRender){
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
            skt.renderer(renderer);
            chars.renderer(renderer);
            sk.renderer(renderer);
            backpack.renderer(renderer);
        }

    }

    public void spawn(Game game) {
        if (game.secondsSpawn >= 800 && game.enemies.size() < 5) {
            game.secondsSpawn = 0;
            enemies.add(new Enemy());
            enemies.get(enemies.size() - 1).create(random.nextInt(1800), random.nextInt(1800));
        }
    }
    public void spawnRobot(Game game) {
        if (game.secondsSpawn >= 800 && enemy.size() <= 5){
            secondsSpawn = 0;
            enemy.add(new RobotEnemy());
            enemy.get(enemy.size()-1).create(random.nextInt(1800)+10, random.nextInt(1800)+10);
        }
    }

    public boolean has(String tag) {
        for (int i = 0; i < backpack.images.size(); i++) {
            if (backpack.numbers.get(i).equals(tag)) {
                return true;
            }
        }
        return false;
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

    public boolean collision(ImageXY A, Hero B) {
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

    public boolean collision(Enemy A, Bulik B) {
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

    public boolean collision(Hero A, Board B) {
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

    public boolean collision(Hero A, Key B) {
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

    public boolean collision(Hero A, ImageXY B) {
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

    public boolean collision(Hero A, Code B) {
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

    public boolean collision(RobotEnemy A, AttackParticle B) {
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

    public boolean collision(RobotEnemy A, PaperSnake B) {
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

    public boolean collision(ImageXY A, ImageXY B) {
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

    public boolean collisionPoint(ImageXY A, int x, int y) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;
        return (objAMinX < x && objAMaxX > x && objAMinY < y && objAMaxY > y);
    }

    public static void main(String[] args) {
        new Game();
    }
}