package StemFight;

import Engine.Image;
import Engine.Player;
import Engine.Renderer;
import static Engine.Max.range;

public class Camera implements Player {
    private Image image = new Image("../StemFight/Using/fon.gif");
    private int x = 0;
    private int y = 0;

    @Override
    public void create(int x, int y) {

    }

    @Override
    public void update(Game game) {
        if (game.hero.x >= 1000){
            if (x != 600){
                x--;
                game.hero.x--;
                game.portal.x--;
                for (Enemy e:game.enemies)e.x--;
                for (AttackParticle a:game.attackParticles) a.x--;
                for (BrickParticle b:game.brickParticles) b.x--;
                game.base.base.x--;
                for (Board b:game.boards)b.x--;
            }

        }
        if (game.hero.x <= 200){
            if (x != 0){
                x++;
                game.hero.x++;
                game.portal.x++;
                for (Enemy e:game.enemies)e.x++;
                for (AttackParticle a:game.attackParticles) a.x++;
                for (BrickParticle b:game.brickParticles) b.x++;
                game.base.base.x++;
                for (Board b:game.boards)x++;
            }
        }
        // TODO: 16.04.2019 при пробеге карта проматывается
        if (game.hero.y >= 750){
            System.out.println(y);
            if (y >= -1200){
                y--;
                game.hero.y--;
                game.portal.y--;
                for (Enemy e:game.enemies)e.y--;
                for (AttackParticle a:game.attackParticles) a.y--;
                for (BrickParticle b:game.brickParticles) b.y--;
                game.base.base.y--;
                for (Board b:game.boards)y--;
            }
        }
        if (game.hero.y <= 50){
            if (y != 0){
                y++;
                game.hero.y++;
                game.portal.y++;
                for (Enemy e:game.enemies)e.y++;
                for (AttackParticle a:game.attackParticles) a.y++;
                for (BrickParticle b:game.brickParticles) b.y++;
                game.base.base.y++;
                for (Board b:game.boards)b.y++;
            }

        }
        x = range(x, -600,0);
        y = range(y, -1200,0);
    }
    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(image, x, y);
    }

    @Override
    public void death(Game game) {}
}