package StemFight.Buildings;

import StemFight.ImageXY;
import StemFight.Renderer;
import StemFight.Building;
import StemFight.Game;

import java.awt.event.KeyEvent;

public class Base extends Building {
    public boolean made = false;
    public ImageXY base = new ImageXY("Using/baseBuild.png", 0, 0);
    public BaseFrame bf = new BaseFrame();
    public BaseProv bp = new BaseProv();

    public void create(int x, int y, int createX, int createY) {
        base.x = createX;
        base.y = createY;
        bf.create(x, y);
        bp.create(x, y);
        made = true;
    }

    @Override
    public void update(Game game) {
        if (bp.visible) bp.update(game);
        if (bf.visible) bf.update(game);

        if (game.gc.input.isKeyDown(KeyEvent.VK_G)) {
            if (game.collision(game.hero, this)) {
                bf.setVisible(true);
                bp.setVisible(false);
            }
        }
        if (!game.collision(game.hero, this)) {
            bf.setVisible(false);
            bp.setVisible(false);
        }
        if (game.gc.input.isKeyDown(KeyEvent.VK_T)) {
            if (game.collision(game.hero, this)) {
                bf.setVisible(false);
                bp.setVisible(true);
            }
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        bf.renderer(renderer);
        if (made) renderer.drawImage(base, base.x, base.y);
        bp.renderer(renderer);
    }
}
