package StemFight;

import Engine.ImageXY;
import Engine.Renderer;

public class Characteristics {
    ImageXY fon = new ImageXY("../StemFight/Using/charFon.png",0,0);
    ImageXY person = new ImageXY("../StemFight/Using/person.png",0,0);
    ImageXY hp = new ImageXY("../StemFight/Skills/heart.png",0,0);
    ImageXY defenced = new ImageXY("../StemFight/Using/defence.png",0,0);
    ImageXY attacked = new ImageXY("../StemFight/Using/attack.png",0,0);
    int x, y;
    int maxHp = 100;
    int attack = 1;
    int defence = 1;
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
        renderer.drawText(name, x, y, 0xffffffff);
    }
}
