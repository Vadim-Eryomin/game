package StemFight;

import java.awt.event.KeyEvent;

public class UpdateCore {
    public void updateFirst(Game game) {
        game.cursor.update(game);
        game.craftingTable.update(game);
        game.furnace.update(game);
        if (game.win) {
            game.world = game.SECOND_WORLD;
        }
        if (game.reverse) {
            game.world = game.OUR_WORLD;
        }
        if (game.key != null) game.key.update(game);
        game.backpack.update(game);
        game.sk.update(game);
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

        new Thread(){
            @Override
            public void run() {
                game.chars.update(game);
                game.charFrame.update(game);
                game.portal.update(game);
                game.camera.update(game);
                if (game.chest.made) game.chest.update(game);
            }
        }.start();
        game.hero.update(game);
        game.engine.update(game);

        new Thread(){
            @Override
            public void run() {
                for (AttackParticle a : game.attackParticles) a.update(game);
                for (Iron i: game.irons) i.update(game);
                for (BrickParticle b : game.brickParticles) b.update(game);
                for (PaperSnake p : game.snakes) p.update(game);
                for (Wall w : game.walls) w.update(game);
                for (Board b : game.boards) b.update(game);
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                for (Enemy e : game.enemies) e.update(game);
                if (game.spawnZombies) game.spawn(game);
                game.secondsSpawn++;
            }
        }.start();
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
        game.rune.update(game);
        for (Enemy e : game.enemies) {
            if (game.collision(e, game.hero)) {
                game.hero.hp -= (5 / game.chars.defence);
                e.hp -= 20 * game.chars.attack;
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            game.hero.x--;
                            e.x++;
                            try {
                                Thread.sleep(3);
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
        game.pied.update(game);
        for (int i = 0; i < game.irons.size(); i++) {
            if(!game.irons.get(i).lived) game.irons.remove(i);
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
        new Thread(){
            @Override
            public void run() {
                game.heal++;
                if (game.heal >= 800) {
                    game.hero.hp += 1;
                    game.heal = 0;
                }
            }
        }.start();

    }

    public void updateSecond(Game game) {
        game.cursor.update(game);
        game.portal.maked = game.portals;
        game.backpack.update(game);
        game.camera.update(game);
        game.chars.update(game);
        game.charFrame.update(game);
        game.skt.update(game);
        game.hero.update(game);
        game.portal.update(game);
        game.spawnRobot(game);
        for (AttackParticle a : game.attackParticles) a.update(game);
        for (BrickParticle b : game.brickParticles) b.update(game);
        for (RobotEnemy r : game.enemy) {
            r.update(game);
            for (int i = 0; i < r.codes.size(); i++) {
                if (game.collision(game.hero, r.codes.get(i))) {
                    r.codes.remove(i);
                    game.hero.hp -= 10;
                }
            }
        }
        for (PaperSnake p : game.snakes) p.update(game);
        for (Wall w : game.walls) w.update(game);
        for (Board b : game.boards) b.update(game);
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
        for (RobotEnemy e : game.enemy) {
            for (int i = 0; i < game.attackParticles.size(); i++) {
                if (game.collision(e, game.attackParticles.get(i))) {
                    e.hp -= 35;
                    game.attackParticles.remove(i);
                }
            }
        }
        for (int i = 0; i < game.snakes.size(); i++) {
            if (game.snakes.get(i).hp <= 0) {
                game.snakes.remove(i);
            }
        }
        for (RobotEnemy e : game.enemy) {
            for (PaperSnake p : game.snakes) {
                if (game.collision(e, p)) {
                    e.hp -= 100;
                    p.hp -= 10;
                }
            }
        }
        for (int i = 0; i < game.enemy.size(); i++) {
            if (game.enemy.get(i).hp <= 0) {
                game.enemy.get(i).death(game);
                game.enemy.remove(i);
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
                    e.hp -= 10;
                    if (e.x > game.walls.get(i).x) e.x += 100;
                    else e.x -= 100;
                }
            }
        }
    }
    public void modifUpdate(Game game){
        game.cursor.update(game);
        game.craftingTable.update(game);
        game.furnace.update(game);
        game.backpack.update(game);
        game.sk.update(game);
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

        if (game.chest.made) game.chest.update(game);

        for (AttackParticle a : game.attackParticles) a.update(game);
        for (Iron i: game.irons) i.update(game);
        for (BrickParticle b : game.brickParticles) b.update(game);
        for (Wall w : game.walls) w.update(game);
        for (Board b : game.boards) b.update(game);

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
        for (int i = 0; i < game.brickParticles.size(); i++) {
            if (!game.brickParticles.get(i).lived) {
                game.brickParticles.remove(i);
            }
        }
        for (int i = 0; i < game.irons.size(); i++) {
            if(!game.irons.get(i).lived) game.irons.remove(i);
        }
        for (int i = 0; i < game.boards.size(); i++) {
            if (!game.boards.get(i).lived) {
                game.boards.remove(i);
            }
        }
        game.skt.update(game);
    }
}
