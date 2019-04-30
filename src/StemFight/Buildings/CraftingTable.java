package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Renderer;
import StemFight.Building;
import StemFight.Game;

import java.awt.event.KeyEvent;

public class CraftingTable extends Building {
    public boolean made = false;
    public ImageXY table = new ImageXY("../StemFight/Using/craftingTable.png", 0, 0);
    boolean renderFrame = false;
    CraftingFrame cf = new CraftingFrame();

    @Override
    public void create(int x, int y) {
        cf.create(0, 500);
        table.x = x;
        table.y = y;
        made = true;
    }

    @Override
    public void update(Game game) {
        if (made) {
            if (game.gc.input.isKeyDown(KeyEvent.VK_T)) {
                if (game.collision(table, game.hero)) {
                    cf.setVisible(!cf.visible);
                }
            }
            if (!game.collision(table, game.hero)) cf.setVisible(false);
            cf.update(game);
        }

    }

    @Override
    public void renderer(Renderer renderer) {
        if (made) {
            renderer.drawImage(table, table.x, table.y);
            cf.renderer(renderer);
        }
    }
}
