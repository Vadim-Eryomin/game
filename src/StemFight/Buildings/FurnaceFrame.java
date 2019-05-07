package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Renderer;
import StemFight.CheckCrafts;
import StemFight.Crafts;
import StemFight.Game;

import java.util.HashMap;

public class FurnaceFrame {
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png", 0, 0);
    ImageXY table = new ImageXY("../StemFight/Using/table.png", 0, 0);
    CheckCrafts checkCrafts = new CheckCrafts();

    String name = "Furnace";
    boolean visible = false;
    int stringX = 0;
    int stringY = 0;

    public HashMap<Integer, ImageXY> pictureThings = new HashMap<>();
    public HashMap<Integer, Integer> numbersThings = new HashMap<>();
    public HashMap<Integer, String> numbers = new HashMap<>();
    public HashMap<Integer, ImageXY> pieces = new HashMap<>();

    public HashMap<String, ImageXY> craftResult = new HashMap<>();
    FurnaceProv fp = new FurnaceProv();

    boolean breakable = false;

    int oneTablePiece = 40;

    public void create(int x, int y) {
        fon.x = x;
        fon.y = y;
        table.x = fon.x + 30;
        table.y = fon.y + 20;
        stringX = table.x + 130;
        stringY = table.y;
        pieces.put(0, new ImageXY("../StemFight/Using/piece.png", table.x, table.y));
        pieces.put(1, new ImageXY("../StemFight/Using/piece.png", table.x, table.y + 2 * oneTablePiece));
        pieces.put(2, new ImageXY("../StemFight/Using/piece.png", table.x + oneTablePiece, table.y + oneTablePiece));
    }

    public void setVisible(boolean vis) {
        visible = vis;
    }

    public void update(Game game) {
        breakable = false;
        if (game.gc.input.isButtonDown(1)) {
            for (int i = 0; i < 3; i++) {
                if (game.collision(game.cursor.cursor, pieces.get(i))) {
                    if (game.cursor.imageCarry.number != 0) {
                        if (pictureThings.get(i) == null) {
                            pictureThings.put(i, game.cursor.imageCarry.image);
                            numbers.put(i, game.cursor.imageCarry.imageTag);
                            numbersThings.put(i, 1);
                            game.cursor.imageCarry.number--;
                            break;
                        }
                        else {
                            numbersThings.put(i, numbersThings.get(i)+1);
                            game.cursor.imageCarry.number--;
                            break;
                        }
                    }
                    else {
                        if (numbers.get(i).equals("brick")) game.hero.bricks += numbersThings.get(i);
                        numbersThings.put(i,0);
                        pictureThings.put(i,null);
                        numbers.put(i,null);
                    }
                }
            }
        }
        fp.update(this);
    }

    public void renderer(Renderer renderer) {
        if (visible) {
            renderer.drawImage(fon, fon.x, fon.y);
            for (int i = 0; i < 3; i++) {
                renderer.drawImage(pieces.get(i), pieces.get(i).x, pieces.get(i).y);
                try {
                    renderer.drawImage(pictureThings.get(i), pieces.get(i).x + 5, pieces.get(i).y + 5);
                    renderer.drawText(numbersThings.get(i).toString(), pieces.get(i).x + 5, pieces.get(i).y + 5, 0xffffffff);
                } catch (NullPointerException e) {
                }
            }
        }
    }
}
