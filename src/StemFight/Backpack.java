package StemFight;

import Engine.ImageXY;
import Engine.Renderer;

import java.util.ArrayList;

public class Backpack {
    Integer brickParcticle = 0;
    ImageXY bricks;

    int flashes = 0;
    ImageXY flash;

    int boards = 0;
    ImageXY board;

    int nails = 0;
    ImageXY nail;

    int x = 0;
    int y = 0;
    public void create(Game game){
        x = game.chars.x + 10;
        y = game.chars.y + 200;

        bricks = new ImageXY("../StemFight/Using/platformPack_tile004.png",0,0);
        bricks.x = x;
        bricks.y = y;
    }
    public void update(Game game){
        brickParcticle = game.hero.bricks;
    }
    public void renderer(Renderer renderer){
        renderer.drawImage(bricks, bricks.x, bricks.y);
        renderer.drawText(brickParcticle.toString(), bricks.x + 40, bricks.y, 0xffffffff);
    }

}
