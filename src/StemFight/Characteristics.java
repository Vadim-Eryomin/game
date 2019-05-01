package StemFight;

import Engine.ImageXY;
import Engine.Renderer;

public class Characteristics {
    ImageXY fon = new ImageXY("../StemFight/Using/charFon.png", 0, 0);
    ImageXY person = new ImageXY("../StemFight/Using/person.png", 0, 0);
    ImageXY hp = new ImageXY("../StemFight/Skills/heart.png", 0, 0);
    ImageXY defenced = new ImageXY("../StemFight/Using/defence.png", 0, 0);
    ImageXY attacked = new ImageXY("../StemFight/Using/attack.png", 0, 0);
    int x, y;
    Integer hps = 0;
    Integer defs = 0;
    Integer atts = 0;
    int maxHp = 100;
    float attack = 1;
    float defence = 1;
    String name = "";

    public void create(int x, int y) {
        fon.x = x;
        fon.y = y;
        person.x = fon.x + 20;
        person.y = fon.y + 20;
        this.x = person.x + 10;
        this.y = person.y + 1;
        hp.x = this.x + 100;
        hp.y = this.y + 50;
        defenced.x = hp.x + 40;
        defenced.y = hp.y;
        attacked.x = defenced.x + 40;
        attacked.y = defenced.y;
    }

    public void update(Game game) {
        name = game.hero.name;
        if (game.hero.charsUp >= 1) {
            if (isClick(hp, game)) {
                hps++;
                maxHp += 10;
                game.hero.charsUp--;
            }
            if (isClick(defenced, game)) {
                defs++;
                defence += 0.1;
                game.hero.charsUp--;
            }
            if (isClick(attacked, game)) {
                atts++;
                attack += 0.1;
                game.hero.charsUp--;
            }
        }
    }

    public void renderer(Renderer renderer) {
        renderer.drawImage(fon, fon.x, fon.y);
        renderer.drawImage(person, person.x, person.y);
        renderer.drawText(name, x, y, 0xffffffff);
        renderer.drawImage(hp, hp.x, hp.y);
        renderer.drawImage(defenced, defenced.x, defenced.y);
        renderer.drawImage(attacked, attacked.x, attacked.y);
        renderer.drawText(hps.toString(), hp.x, hp.y, 0xffffffff);
        renderer.drawText(defs.toString(), defenced.x, defenced.y, 0xffffffff);
        renderer.drawText(atts.toString(), attacked.x, attacked.y, 0xffffffff);
    }

    public boolean isClick(ImageXY im, Game game) {
        if (game.gc.input.isButtonDown(1) && game.gc.input.mouseX > im.x && game.gc.input.mouseX < im.x + im.w && game.gc.input.mouseY > im.y && game.gc.input.mouseY < im.y + im.h)
            return true;
        return false;
    }
}
