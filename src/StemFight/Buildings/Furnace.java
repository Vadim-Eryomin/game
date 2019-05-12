package StemFight.Buildings;

import StemFight.ImageXY;
import StemFight.Renderer;
import StemFight.Game;

import java.awt.event.KeyEvent;

public class Furnace {
    public boolean made = false;
    public ImageXY table = new ImageXY("Using/furnace.png", 0, 0);
    FurnaceFrame ff = new FurnaceFrame();
    public void create(int x, int y) {
        ff.create(0, 500);
        table.x = x;
        table.y = y;
        made = true;
    }

    public void update(Game game) {
        if (made) {
            if (game.gc.input.isKeyDown(KeyEvent.VK_T)) {
                if (game.collision(table, game.hero)) {
                    ff.setVisible(!ff.visible);
                }
            }
            if (!game.collision(table, game.hero)) ff.setVisible(false);
            if (ff.visible)ff.update(game);
        }

    }

    public void renderer(Renderer renderer) {
        if (made) {
            renderer.drawImage(table, table.x, table.y);
            ff.renderer(renderer);
        }
    }
}
