package StemFight.Runix;

import StemFight.Game;
import StemFight.ImageXY;
import StemFight.Player;
import StemFight.Renderer;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class RuneEngine extends Player {
    HashMap<Integer, String> numbers = new HashMap<>();
    HashMap<Integer, ImageXY> pictureThing = new HashMap<>();
    HashMap<Integer, Integer> numbersThing = new HashMap<>();
    ImageXY field = new ImageXY("Using/field500.png", 0, 0);
    boolean keep = false;
    int energy = 0;
    RuneEngineProv engineProv = new RuneEngineProv();

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.imageXY = new ImageXY("Using/engine.png", x, y);
        keep = true;
        field.x = x - imageXY.w / 2;
        field.y = y - imageXY.h / 2;
        engineProv.create(0,500);
    }

    @Override
    public void update(Game game) {
        if (keep) {
            if (game.gc.input.isKeyDown(KeyEvent.VK_T)) {
                if (game.collision(game.hero, imageXY)) {
                    engineProv.setVisible(!engineProv.visible);
                }
            }
            if (!game.collision(imageXY, game.hero)) engineProv.setVisible(false);
            if (engineProv.visible) engineProv.update(game);
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        if (keep) {
            renderer.drawImage(imageXY, x, y);
            if (engineProv.visible) engineProv.renderer(renderer);
        }
    }

    @Override
    public void death(Game game) {

    }
}
