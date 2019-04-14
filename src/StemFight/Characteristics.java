package StemFight;

import Engine.ImageXY;
import Engine.Renderer;

public class Characteristics {
    ImageXY fon = new ImageXY("../StemFight/Using/charFon.png",0,0);
    ImageXY person = new ImageXY("../StemFight/Using/person.png",0,0);
    int x, y;
    String name = "";
    public void create(int x, int y){
        fon.x = x;
        fon.y = y;
        person.x = fon.x + 20;
        person.y = fon.y + 20;
        this.x = person.x + 10;
        this.y = person.y + 1;
    }
    public void update(Game game){
        name = game.hero.name;
    }
    public void renderer(Renderer renderer){
        renderer.drawImage(fon, fon.x, fon.y);
        renderer.drawImage(person, person.x, person.y);
        renderer.drawText(name, x, y, 0x7DF9FF);
    }
}
