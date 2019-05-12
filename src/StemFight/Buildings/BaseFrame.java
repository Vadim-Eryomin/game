package StemFight.Buildings;

import StemFight.ImageXY;
import StemFight.Renderer;
import StemFight.Game;

public class BaseFrame {
    ImageXY fon = new ImageXY("Using/fonBase.png",0,0);
    ImageXY base = new ImageXY("Using/baseBuild.png",0,0);
    ImageXY angry = new ImageXY("Using/angry.png",0,0);
    ImageXY exp = new ImageXY("Skills/experience.png",0,0);
    ImageXY hp = new ImageXY("Skills/heart.png",0,0);

    boolean angrys = false;
    String name = "Base";
    boolean visible = false;

    int stringX = 0;
    int stringY = 0;

    public Integer buildHp = 100;
    public Integer saveExp = 0;

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
