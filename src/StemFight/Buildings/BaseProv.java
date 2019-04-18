package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Renderer;
import StemFight.Game;

public class BaseProv {
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png",0,0);
    ImageXY base = new ImageXY("../StemFight/Using/base.png",0,0);
    ImageXY extract = new ImageXY("../StemFight/Using/extract.png",0,0);
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
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    public void update(Game game){
        setVisible(!visible);
    }
    public void renderer(Renderer renderer){
        if (visible){
            renderer.drawImage(fon, fon.x, fon.y);
            renderer.drawImage(base, base.x, base.y);
            renderer.drawText(name, stringX, stringY, 0xffffffff);
        }
    }

}
