package StemFight.Buildings;

import StemFight.ImageXY;
import StemFight.Renderer;
import StemFight.Game;

public class BaseProv {
    ImageXY fon = new ImageXY("Using/fonBase.png",0,0);
    ImageXY base = new ImageXY("Using/baseBuild.png",0,0);
    ImageXY extract = new ImageXY("Using/extract.png",0,0);
    String name = "Base";
    boolean visible = false;
    int stringX = 0;
    int stringY = 0;

    public void create(int x, int y){
        fon.x = x;
        fon.y = y;
        base.x = fon.x;
        base.y = fon.y + 20;
        stringX = base.x + 90;
        stringY = base.y;
        extract.x = stringX;
        extract.y = stringY + 10;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    public void update(Game game){
        if (game.collision(game.cursor.cursor, extract)){
            if (game.gc.input.isButtonDown(1)){
                if (game.backpack.boards >= 2 && game.backpack.brickParcticle >= 2){
                    game.backpack.extracts++;
                    game.backpack.boards-=2;
                    game.backpack.brickParcticle-=2;
                }
            }
        }
    }
    public void renderer(Renderer renderer){
        if (visible){
            renderer.drawImage(fon, fon.x, fon.y);
            renderer.drawImage(base, base.x, base.y);
            renderer.drawText(name, stringX, stringY, 0xffffffff);
            renderer.drawImage(extract, extract.x, extract.y);
        }
    }

}
