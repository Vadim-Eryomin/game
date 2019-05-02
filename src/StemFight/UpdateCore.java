package StemFight;

import java.awt.event.KeyEvent;

public class UpdateCore {
    public void updateFirst(Game game){
        game.cursor.update(game);
        game.craftingTable.update(game);
        if (game.win) {
            game.thisWorldRenderer = false;
            game.thisWorldUpdate = false;
        }
        if (game.key != null) game.key.update(game);
        game.backpack.update(game);
        game.sk.update(game);
        if (game.gc.input.isKeyDown(KeyEvent.VK_R)) {
            if (!game.base.made && game.hero.bricks >= 5 && game.hero.boards >= 10)
                game.base.create(0, 500, game.hero.x, game.hero.y);
            else {
                if (game.base.made && game.hero.boards >= 5) {
                    game.base.bf.buildHp += 10;
                    game.hero.boards -= 5;
                } else if (game.hero.bricks < 5) game.pickBlocks = true;
                else if (game.hero.boards < 10) game.pickBoards = true;
            }
        }
        game.pleasePress = game.collision(game.hero, game.base);
        if (game.gc.input.isKeyDown(KeyEvent.VK_F) && game.base != null && game.base.made) {
            game.base.bf.saveExp += game.hero.xp;
            game.hero.xp = 0;
        }
        if (game.gc.input.isKeyDown(KeyEvent.VK_H) && game.base != null && game.base.made) {
            game.hero.xp += game.base.bf.saveExp;
            game.base.bf.saveExp = 0;
        }
        if (game.base != null) {
            game.base.update(game);
        }
        game.chars.update(game);
        game.charFrame.update(game);
        game.hero.update(game);
        game.portal.update(game);
        game.camera.update(game);

        for (AttackParticle a : game.attackParticles) a.update(game);
        for (BrickParticle b : game.brickParticles) b.update(game);
        for (Enemy e : game.enemies) e.update(game);
        for (PaperSnake p : game.snakes) p.update(game);
        for (Wall w : game.walls) w.update(game);
        for (Board b : game.boards) b.update(game);

        if (game.spawnZombies) game.spawn(game);
        game.secondsSpawn++;

        for (int i = 0; i < game.attackParticles.size(); i++) {
            if (game.attackParticles.get(i).seconds >= game.attackParticles.get(i).secondsLives) {
                game.attackParticles.remove(i);
            }
        }
        for (int i = 0; i < game.walls.size(); i++) {
            if (game.walls.get(i).seconds >= game.walls.get(i).secondsLives) {
                game.walls.remove(i);
            }
        }
        for (Enemy e : game.enemies) {
            for (int i = 0; i < game.attackParticles.size(); i++) {
                if (game.collision(e, game.attackParticles.get(i))) {
                    e.hp -= 35 * game.chars.attack;
                    game.attackParticles.remove(i);
                }
            }
        }
        for (int i = 0; i < game.snakes.size(); i++) {
            if (game.snakes.get(i).hp <= 0) {
                game.snakes.remove(i);
            }
        }
        for (Enemy e : game.enemies) {
            for (PaperSnake p : game.snakes) {
                if (game.collision(e, p)) {
                    e.hp -= 100 * game.chars.attack;
                    p.hp -= 10;
                }
            }
        }
        for (int i = 0; i < game.enemies.size(); i++) {
            if (game.enemies.get(i).hp <= 0) {
                game.enemies.get(i).death(game);
                game.enemies.remove(i);
            }
        }
        for (Enemy e : game.enemies) {
            if (game.collision(e, game.hero)) {
                game.hero.hp -= (5 / game.chars.defence);
                e.hp -= 20 * game.chars.attack;
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            game.hero.x--;
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
        for (int i = 0; i < game.brickParticles.size(); i++) {
            if (!game.brickParticles.get(i).lived) {
                game.brickParticles.remove(i);
            }
        }
        for (int i = 0; i < game.boards.size(); i++) {
            if (!game.boards.get(i).lived) {
                game.boards.remove(i);
            }
        }
        for (Enemy e : game.enemies) {
            for (int i = 0; i < game.walls.size(); i++) {
                if (game.collision(e, game.walls.get(i))) {
                    e.hp -= 10 * game.chars.attack;
                    if (e.x > game.walls.get(i).x) e.x += 100;
                    else e.x -= 100;
                }
            }
        }
        game.skt.update(game);
        game.heal++;
        if (game.heal >= 800) {
            game.hero.hp += 1;
            game.heal = 0;
        }
    }
    public void updateSecond(Game game){

    }
}
