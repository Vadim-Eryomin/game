package StemFight;

import Engine.Image;
import Engine.Player;
import Engine.Renderer;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Portal implements Player {
    Image nulled = new Image("../StemFight/Using/breakPortal.png");
    Image maked = new Image("../StemFight/Using/madePortal.png");
    Image using;
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    boolean making = false;

    @Override
    public void create(int x, int y) {
        using = nulled;
        this.x = x;
        this.y = y;
        this.w = nulled.w;
        this.h = nulled.h;
    }

    @Override
    public void update(Game game) {
        if (!making){
            if (game.gc.input.isKeyDown(KeyEvent.VK_E)) {
                if (game.collision(game.hero, this)) {
                    if (game.hero.bricks >= 20) {
                        game.hero.bricks -= 20;
                        using = maked;
                        making = true;
                    }
                    else {
                        game.talkPick = true;
                    }
                }
                else{
                    game.talkWalk = true;
                }
            }
        }
        else {
            if (game.gc.input.isKeyDown(KeyEvent.VK_E)){
                game.win = true;
                game.spawnZombies = false;
            }
        }

    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(using, x, y);
    }

    @Override
    public void death(Game game) {

    }
}
