package StemFight.Buildings;

import StemFight.ImageXY;
import StemFight.Renderer;
import StemFight.Game;

import java.awt.event.KeyEvent;

public class Chest {
    public boolean made = false;
    public ImageXY chest = new ImageXY("Using/chest.png", 0, 0);
    ChestFrame cf = new ChestFrame();
    public void create(int x, int y, int createX, int createY) {
        chest.x = createX;
        chest.y = createY;
        cf.create(x, y);
        made = true;
    }

    public void update(Game game) {
        if (cf.visible)cf.update(game);
        if (game.gc.input.isKeyDown(KeyEvent.VK_T)){
            if (game.collision(game.hero, chest))
                cf.setVisible(!cf.visible);
        }
        if (!game.collision(game.hero, chest)) cf.setVisible(false);
    }

    public void renderer(Renderer renderer) {
        if (made) renderer.drawImage(chest, chest.x, chest.y);
        cf.renderer(renderer);
    }

}
