package StemFight.Runix;

import StemFight.CheckCrafts;
import StemFight.Game;
import StemFight.ImageXY;
import StemFight.Renderer;

import java.util.HashMap;

import static StemFight.Change.getChange;

public class RuneEngineProv {
    ImageXY fon = new ImageXY("Using/fonBase.png", 0, 0);
    ImageXY table = new ImageXY("Using/table.png", 0, 0);

    String name = "Rune Engine";
    boolean visible = false;
    int stringX = 0;
    int stringY = 0;

    public HashMap<Integer, ImageXY> pictureThings = new HashMap<>();
    public HashMap<Integer, Integer> numbersThings = new HashMap<>();
    public HashMap<Integer, String> numbers = new HashMap<>();
    public HashMap<Integer, ImageXY> pieces = new HashMap<>();

    int oneTablePiece = 40;

    public void create(int x, int y) {
        fon.x = x;
        fon.y = y;
        table.x = fon.x + 30;
        table.y = fon.y + 20;
        stringX = table.x + 130;
        stringY = table.y;
        pieces.put(0, new ImageXY("Using/piece.png",table.x + oneTablePiece,table.y + oneTablePiece));
    }

    public void setVisible(boolean vis) {
        visible = vis;
    }

    public void update(Game game) {
        System.out.println(game.engine.energy);
        if (visible) {
            if (game.gc.input.isButtonDown(1)) {
                for (int i = 0; i < 1; i++) {
                    if (game.collision(game.cursor.cursor, pieces.get(i))) {
                        if (game.cursor.imageCarry.number != 0) {
                            if (pictureThings.get(i) == null) {
                                pictureThings.put(i, game.cursor.imageCarry.image);
                                numbers.put(i, game.cursor.imageCarry.imageTag);
                                numbersThings.put(i, 1);
                                game.cursor.imageCarry.number--;
                                break;
                            } else {
                                numbersThings.put(i, numbersThings.get(i) + 1);
                                game.cursor.imageCarry.number--;
                                break;
                            }
                        } else {
                            try {
                                if (numbers.get(i).equals("brick"))
                                    game.backpack.brickParcticle += numbersThings.get(i);
                                if (numbers.get(i).equals("board")) game.backpack.boards += numbersThings.get(i);
                                numbersThings.put(i, 0);
                                pictureThings.put(i, null);
                                numbers.put(i, null);
                            } catch (NullPointerException e) {
                            }
                        }
                    }
                }
            }
            try {
                if (numbersThings.get(0) >= 1 && numbers.get(0).equals("board")) {
                    numbersThings.put(0, numbersThings.get(0) - 1);
                    game.engine.energy+=200;
                }
            } catch (NullPointerException e) {
            }
        }
    }


    public void renderer(Renderer renderer) {
        if (visible) {
            renderer.drawImage(fon, fon.x, fon.y);
            renderer.drawImage(pieces.get(0), pieces.get(0).x, pieces.get(0).y);
            try {
                renderer.drawImage(pictureThings.get(0), pieces.get(0).x + 5, pieces.get(0).y + 5);
                renderer.drawText(numbersThings.get(0).toString(), pieces.get(0).x + 5, pieces.get(0).y + 5, 0xffffffff);
            } catch (NullPointerException e) {
            }

        }
    }
}