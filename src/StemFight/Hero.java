package StemFight;

import Engine.Player;
import Engine.Renderer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Engine.Max.range;

public class Hero implements Player {
    SkillsTerminal sk = new SkillsTerminal();
    String name = "Player";
    boolean right = true;

    ArrayList<Engine.Image> d = new ArrayList<>();
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    int hp = 100;
    int xp = 0;

    public int bricks = 0;
    public int boards = 0;
    public int nails = 0;
    public int extracts = 0;
    public int shovels = 0;
    public int craftingTables = 1;

    boolean keyFirst = false;

    int delayFirstSkill = 0;
    int delaySecondSkill = 20;
    int delayThirdSkill = 300;

    int lastFirstSkill = 0;
    int lastSecondSkill = 0;
    int lastThirdSkill = 0;

    private int seconds = 0;

    ExperienceAndLevels exps = new ExperienceAndLevels();

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;

        d.add(new Engine.Image("../StemFight/Using/adventurer_stand.png"));
        d.add(new Engine.Image("../StemFight/Using/adventurer_walk1.png"));
        d.add(new Engine.Image("../StemFight/Using/adventurer_walk2.png"));

        d.add(new Engine.Image("../StemFight/Using/adventurer_standL.png"));
        d.add(new Engine.Image("../StemFight/Using/adventurer_walk1L.png"));
        d.add(new Engine.Image("../StemFight/Using/adventurer_walk2L.png"));

        this.w = d.get(0).w;
        this.h = d.get(0).h;
    }

    @Override
    public void update(Game game) {
        hp = range(hp,0,100);
        if (game.gc.input.isKeyUp(KeyEvent.VK_A) || game.gc.input.isKeyUp(KeyEvent.VK_A) || game.gc.input.isKeyUp(KeyEvent.VK_A) || game.gc.input.isKeyUp(KeyEvent.VK_A)) {
            seconds = 0;
        }
        if (game.gc.input.isKey(KeyEvent.VK_A)) {
            right = false;
            x--;
            seconds++;
        }
        if (game.gc.input.isKey(KeyEvent.VK_D)) {
            right = true;
            x++;
            seconds++;
        }
        if (game.gc.input.isKey(KeyEvent.VK_W)) {
            y--;
            seconds++;
        }
        if (game.gc.input.isKey(KeyEvent.VK_S)) {
            y++;
            seconds++;
        }
        x = range(x, 200, 1320);
        y = range(y, 0, 790);
        createParticle(game);
        if (hp <= 0) death(game);
        exps.update(game);
    }

    @Override
    public void renderer(Renderer renderer) {

        if (right) {
            if (0 <= seconds % 180 && seconds % 180 <= 60) renderer.drawImage(d.get(0), x, y);
            if (60 < seconds % 180 && seconds % 180 <= 120) renderer.drawImage(d.get(1), x, y);
            if (120 < seconds % 180 && seconds % 180 <= 180) renderer.drawImage(d.get(2), x, y);
        } else {
            if (0 <= seconds % 180 && seconds % 180 <= 60) renderer.drawImage(d.get(3), x, y);
            if (60 < seconds % 180 && seconds % 180 <= 120) renderer.drawImage(d.get(4), x, y);
            if (120 < seconds % 180 && seconds % 180 <= 180) renderer.drawImage(d.get(5), x, y);
        }
    }

    @Override
    public void death(Game game) {
        x = 0;
        y = 0;
    }

    public void createParticle(Game game) {
        if (game.gc.input.isKeyDown(KeyEvent.VK_1)) {
            sk.terminal = 0;
        }
        if (game.gc.input.isKeyDown(KeyEvent.VK_2)) {
            sk.terminal = 1;
        }
        if (game.gc.input.isKeyDown(KeyEvent.VK_3)) {
            sk.terminal = 2;
        }
        if (game.skt.buliks){
            game.skt.choiceProgr = false;
        }
        if (game.skt.codes){
            game.skt.choiceGraph = false;
        }
        if (game.skt.choiceGraph){
            if (game.gc.input.isButtonDown(1)) {
                if (game.skt.choiceGraph && sk.terminal == 0 && game.skt.buliks ) {
                    game.attackParticles.add(new Bulik());
                    game.attackParticles.get(game.attackParticles.size() - 1).create(game);
                }
                if (game.skt.choiceGraph && sk.terminal == 1 && game.skt.arrows ) {
                    game.attackParticles.add(new Arrow());
                    game.attackParticles.get(game.attackParticles.size() - 1).create(game);
                }
                if (game.skt.choiceGraph && sk.terminal == 2 && game.skt.snakes ) {
                    game.snakes.add(new PaperSnake());
                    game.snakes.get(game.snakes.size() - 1).create(x,y);
                }
            }
        }
        else if (game.skt.choiceProgr){
            if (game.gc.input.isButtonDown(1)) {
                if (game.skt.choiceProgr && sk.terminal == 0 && game.skt.codes ) {
                    game.attackParticles.add(new Code());
                    game.attackParticles.get(game.attackParticles.size() - 1).create(game);
                }
                if (game.skt.choiceProgr && sk.terminal == 1 && game.skt.heals ) {
                    game.attackParticles.add(new Heal());
                    game.attackParticles.get(game.attackParticles.size() - 1).create(game.hero.x, game.hero.y-20);
                }
                if (game.skt.choiceProgr && sk.terminal == 2 && game.skt.walls ) {
                    game.walls.add(new Wall());
                    game.walls.get(game.walls.size() - 1).create(game);
                }
            }
        }


    }
}

