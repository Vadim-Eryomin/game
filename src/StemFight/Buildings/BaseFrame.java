package StemFight.Buildings;

import Engine.Renderer;
import StemFight.Game;


import java.awt.event.KeyEvent;

public class BaseFrame extends BuildingFrame{

    public BaseFrame(String pathFon, String pathBase, String name, boolean angrys) {
        super(pathFon, pathBase, name, angrys);
    }
    public void create(int x, int y){
        super.create(x,y);
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
            renderer.drawText(name, base.x + 120, base.y + 10, 0xffffff);

        }
    }
}
