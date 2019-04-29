package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Renderer;
import StemFight.Game;
import java.util.HashMap;

public class CraftingFrame {
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png", 0, 0);
    ImageXY table = new ImageXY("../StemFight/Using/table.png", 0, 0);

    String name = "Craft";
    boolean visible = true;
    int stringX = 0;
    int stringY = 0;

    HashMap<Integer, ImageXY> pictureThings = new HashMap<>();
    HashMap<Integer, Integer> numbersThings = new HashMap<>();
    HashMap<Integer, String> numbers = new HashMap<>();

    int oneTablePiece = 40;

    public void create(int x, int y) {
        fon.x = x;
        fon.y = y;
        table.x = fon.x + 10;
        table.y = fon.y + 20;
        stringX = table.x + 130;
        stringY = table.y;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void update(Game game) {
        if (game.gc.input.isButtonDown(1)) {
            if (game.collision(table, game.cursor.cursor)) {
                int x = game.cursor.cursor.x;
                int y = game.cursor.cursor.y;

                if (game.cursor.imageCarry.image != null) {
                    if (table.x < x && table.x + oneTablePiece > x && table.y < y && table.y + oneTablePiece > y) {
                        if (pictureThings.get(0) == null) {
                            setZero(game);
                        } else {
                            if (numbers.get(0).equals(game.cursor.imageCarry.imageTag)) {
                                numbersThings.put(0, numbersThings.get(0) + 1);
                                game.cursor.imageCarry.number--;
                            } else {
                                if (numbers.get(0).equals("brick")) {
                                    game.hero.bricks += numbersThings.get(0);
                                }
                                if (numbers.get(0).equals("board")) {
                                    game.hero.boards += numbersThings.get(0);
                                }
                                setZero(game);
                            }
                        }
                    }
                } else {
                    if (table.x < x && table.x + oneTablePiece > x && table.y < y && table.y + oneTablePiece > y) {
                        if (pictureThings.get(0) != null){
                            if (numbers.get(0).equals("brick")) {
                                game.hero.bricks += numbersThings.get(0);
                            }
                            if (numbers.get(0).equals("board")) {
                                game.hero.boards += numbersThings.get(0);
                            }
                            pictureThings.put(0,null);
                            numbersThings.put(0,0);
                            numbers.put(0,null);
                        }
                    }
                }


                // TODO: 28.04.2019
            }
        }
    }

    public void setZero(Game game) {
        numbers.put(0, game.cursor.imageCarry.imageTag);
        pictureThings.put(0, game.cursor.imageCarry.image);
        numbersThings.put(0, 1);
        game.cursor.imageCarry.number--;
    }

    public void renderer(Renderer renderer) {
        if (visible) {
            renderer.drawImage(fon, fon.x, fon.y);
            renderer.drawImage(table, table.x, table.y);
            renderer.drawText(name, stringX, stringY, 0xffffffff);
            for (int i = 0; i < 9; i++) {
                if (pictureThings.get(i) != null) renderer.drawImage(pictureThings.get(i), table.x + 5, table.y + 5);
            }
        }
    }
}
