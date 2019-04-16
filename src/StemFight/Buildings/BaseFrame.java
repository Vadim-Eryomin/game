package StemFight.Buildings;

import Engine.Image;
import Engine.ImageXY;
import Engine.Renderer;
import StemFight.Game;

import java.awt.event.KeyEvent;

public class BaseFrame {
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png",0,0);
    ImageXY base = new ImageXY("../StemFight/Using/base.png",0,0);
    ImageXY angry = new ImageXY("../StemFight/Using/angry.png",0,0);
    ImageXY exp = new ImageXY("../StemFight/Skills/experience.png",0,0);
    ImageXY hp = new ImageXY("../StemFight/Skills/heart.png",0,0);

    boolean angrys = false;
    String name = "Base";
    boolean visible = false;

    int stringX = 0;
    int stringY = 0;

    Integer buildHp = 0;
    Integer saveExp = 0;

    public void create(int x, int y){
        fon.x = x;
        fon.y = y;
        base.x = fon.x;
        base.y = fon.y + 20;
        stringX = base.x + 90;
        stringY = base.y;
        exp.x = stringX;
        exp.y = stringY + 30;
        hp.x = stringX;
        hp.y = exp.y + 30;
        angry.x = hp.x;
        angry.y = hp.y + 30;
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
            renderer.drawImage(angry, angry.x, angry.y);
            renderer.drawImage(exp, exp.x, exp.y);
            renderer.drawText(saveExp.toString(), exp.x +20, exp.y, 0xffffffff);
            renderer.drawImage(hp, hp.x, hp.y);
            renderer.drawText(buildHp.toString(), hp.x + 20, hp.y, 0xffffffff);
            if (buildHp >= 0) renderer.drawText("BREAKED!", base.x +10, base.y+120, 0xffffffff);
        }
    }
}
