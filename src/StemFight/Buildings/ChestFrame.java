package StemFight.Buildings;

import StemFight.ImageXY;
import StemFight.Renderer;
import StemFight.Game;

import java.util.HashMap;

public class ChestFrame {

    String name = "Chest";
    boolean visible = false;
    int stringX = 0;
    int stringY = 0;
    public HashMap<Integer, ImageXY> pictureThings = new HashMap<>();
    public HashMap<Integer, Integer> numbersThings = new HashMap<>();
    public HashMap<Integer, String> numbers = new HashMap<>();
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png", 0, 0);
    ImageXY table = new ImageXY("../StemFight/Using/table.png", 0, 0);
    public HashMap<Integer, ImageXY> pieces = new HashMap<>();
    boolean breakable = false;
    int oneTablePiece = 40;


    public void create(int x, int y) {
        fon.x = x;
        fon.y = y;
        table.x = fon.x + 10;
        table.y = fon.y + 20;
        stringX = table.x + 130;
        stringY = table.y;
        pieces.put(0, new ImageXY("Using/piece.png", table.x, table.y));
        pieces.put(1, new ImageXY("Using/piece.png", table.x + oneTablePiece, table.y));
        pieces.put(2, new ImageXY("Using/piece.png", table.x + 2 * oneTablePiece, table.y));
        pieces.put(3, new ImageXY("Using/piece.png", table.x, table.y + oneTablePiece));
        pieces.put(4, new ImageXY("Using/piece.png", table.x + oneTablePiece, table.y + oneTablePiece));
        pieces.put(5, new ImageXY("Using/piece.png", table.x + 2 * oneTablePiece, table.y + oneTablePiece));
        pieces.put(6, new ImageXY("Using/piece.png", table.x, table.y + 2 * oneTablePiece));
        pieces.put(7, new ImageXY("Using/piece.png", table.x + oneTablePiece, table.y + 2 * oneTablePiece));
        pieces.put(8, new ImageXY("Using/piece.png", table.x + 2 * oneTablePiece, table.y + 2 * oneTablePiece));
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
    public void update(Game game) {
        breakable = false;
        if (game.gc.input.isButtonDown(1)) {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    int i = x + y * 3;
                    if (game.collision(game.cursor.cursor, pieces.get(i))) {
                        if (game.cursor.imageCarry.number > 0) {
                            if (pictureThings.get(i) != null) {
                                if (numbers.get(i).equals("brick") && game.cursor.imageCarry.imageTag.equals("brick")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else if (numbers.get(i).equals("board") && game.cursor.imageCarry.imageTag.equals("board")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else if (numbers.get(i).equals("baseBottom") && game.cursor.imageCarry.imageTag.equals("baseBottom")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else if (numbers.get(i).equals("baseWall") && game.cursor.imageCarry.imageTag.equals("baseWall")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else if (numbers.get(i).equals("baseRoof") && game.cursor.imageCarry.imageTag.equals("baseRoof")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else if (numbers.get(i).equals("base") && game.cursor.imageCarry.imageTag.equals("base")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else if (numbers.get(i).equals("extract") && game.cursor.imageCarry.imageTag.equals("extract")) {
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                } else {
                                    if (numbers.get(i).equals("brick")) {
                                        game.backpack.brickParcticle += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                    if (numbers.get(i).equals("board")) {
                                        game.backpack.boards += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                    if (numbers.get(i).equals("baseBottom")) {
                                        game.backpack.baseBottoms += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                    if (numbers.get(i).equals("baseWall")) {
                                        game.backpack.baseWalls += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                    if (numbers.get(i).equals("baseRoof")) {
                                        game.backpack.baseRoofs += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                    if (numbers.get(i).equals("base")) {
                                        game.backpack.bases += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                    if (numbers.get(i).equals("extract")) {
                                        game.backpack.extracts += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i, 1);
                                    }
                                }

                            } else {
                                pictureThings.put(i, game.cursor.imageCarry.image);
                                try {
                                    numbersThings.put(i, numbersThings.get(i) + 1);
                                } catch (NullPointerException e) {
                                    numbersThings.put(i, 1);
                                }
                                game.cursor.imageCarry.number--;
                                numbers.put(i, game.cursor.imageCarry.imageTag);
                            }
                        } else {
                            if (pictureThings.get(i) != null) {
                                if (numbers.get(i).equals("brick")) game.backpack.brickParcticle += numbersThings.get(i);
                                if (numbers.get(i).equals("board")) game.backpack.boards += numbersThings.get(i);
                                if (numbers.get(i).equals("baseBottom")) game.backpack.baseBottoms += numbersThings.get(i);
                                if (numbers.get(i).equals("baseWall")) game.backpack.baseWalls += numbersThings.get(i);
                                if (numbers.get(i).equals("baseRoof")) game.backpack.baseRoofs += numbersThings.get(i);
                                if (numbers.get(i).equals("base")) game.backpack.bases += numbersThings.get(i);
                                if (numbers.get(i).equals("extract")) game.backpack.extracts += numbersThings.get(i);
                                pictureThings.put(i, null);
                                numbersThings.put(i, 0);
                                numbers.put(i, null);
                            }
                        }
                        breakable = true;
                    }
                    if (breakable) break;
                }
                if (breakable) break;
            }
        }
    }
    public void renderer(Renderer renderer) {
        if (visible) {
            renderer.drawImage(fon, fon.x, fon.y);
            renderer.drawText(name, stringX, stringY, 0xffffffff);
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    int i = x + y * 3;
                    renderer.drawImage(pieces.get(i), pieces.get(i).x, pieces.get(i).y);
                    try {
                        renderer.drawImage(pictureThings.get(i), pieces.get(i).x + (40 - pictureThings.get(i).w) / 2, pieces.get(i).y + (40 - pictureThings.get(i).w) / 2);
                        renderer.drawText(numbersThings.get(i).toString(), pieces.get(i).x + 5, pieces.get(i).y + 5, 0xffffffff);
                    } catch (NullPointerException e) {

                    }
                }
            }
        }
    }

}
