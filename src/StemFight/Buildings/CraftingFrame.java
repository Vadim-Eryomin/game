package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Renderer;
import StemFight.CheckCrafts;
import StemFight.Crafts;
import StemFight.Game;

import java.util.HashMap;

public class CraftingFrame {
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png", 0, 0);
    ImageXY table = new ImageXY("../StemFight/Using/table.png", 0, 0);
    Crafts crafts = new Crafts();
    CheckCrafts checkCrafts = new CheckCrafts();

    String name = "Craft";
    boolean visible = false;
    int stringX = 0;
    int stringY = 0;

    public HashMap<Integer, ImageXY> pictureThings = new HashMap<>();
    public HashMap<Integer, Integer> numbersThings = new HashMap<>();
    public HashMap<Integer, String> numbers = new HashMap<>();
    public HashMap<Integer, ImageXY> pieces = new HashMap<>();
    public HashMap<Integer, String> shovel = new HashMap<>();
    public HashMap<Integer, String> baseBottom = new HashMap();
    public HashMap<Integer, String> baseWall = new HashMap<>();
    public HashMap<String, Boolean> canCraft = new HashMap<>();
    public HashMap<String, ImageXY> craftResult = new HashMap<>();
    boolean breakable = false;

    int oneTablePiece = 40;

    public void create(int x, int y) {
        fon.x = x;
        fon.y = y;
        table.x = fon.x + 10;
        table.y = fon.y + 20;
        stringX = table.x + 130;
        stringY = table.y;
        pieces.put(0, new ImageXY("../StemFight/Using/piece.png", table.x, table.y));
        pieces.put(1, new ImageXY("../StemFight/Using/piece.png", table.x + oneTablePiece, table.y));
        pieces.put(2, new ImageXY("../StemFight/Using/piece.png", table.x + 2 * oneTablePiece, table.y));
        pieces.put(3, new ImageXY("../StemFight/Using/piece.png", table.x, table.y + oneTablePiece));
        pieces.put(4, new ImageXY("../StemFight/Using/piece.png", table.x + oneTablePiece, table.y + oneTablePiece));
        pieces.put(5, new ImageXY("../StemFight/Using/piece.png", table.x + 2 * oneTablePiece, table.y + oneTablePiece));
        pieces.put(6, new ImageXY("../StemFight/Using/piece.png", table.x, table.y + 2 * oneTablePiece));
        pieces.put(7, new ImageXY("../StemFight/Using/piece.png", table.x + oneTablePiece, table.y + 2 * oneTablePiece));
        pieces.put(8, new ImageXY("../StemFight/Using/piece.png", table.x + 2 * oneTablePiece, table.y + 2 * oneTablePiece));
        pieces.put(9, new ImageXY("../StemFight/Using/piece.png", table.x + 3 * oneTablePiece + 10, table.y + oneTablePiece));
        crafts.create(this);

    }

    public void setVisible(boolean visible) {
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
                                }
                                else if (numbers.get(i).equals("board") && game.cursor.imageCarry.imageTag.equals("board")){
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                }
                                else if (numbers.get(i).equals("baseBottom") && game.cursor.imageCarry.imageTag.equals("baseBottom")){
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                }
                                else if (numbers.get(i).equals("baseWall") && game.cursor.imageCarry.imageTag.equals("baseWall")){
                                    try {
                                        numbersThings.put(i, numbersThings.get(i) + 1);
                                    } catch (NullPointerException e) {
                                        numbersThings.put(i, 1);
                                    }
                                    game.cursor.imageCarry.number--;
                                    numbers.put(i, game.cursor.imageCarry.imageTag);
                                }
                                else {
                                    if (numbers.get(i).equals("brick")) {
                                        game.hero.bricks += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i,1);
                                    }
                                    if (numbers.get(i).equals("board")){
                                        game.hero.boards += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i,1);
                                    }
                                    if (numbers.get(i).equals("baseBottom")){
                                        game.hero.baseBottoms += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i,1);
                                    }
                                    if (numbers.get(i).equals("baseWall")){
                                        game.hero.baseWalls += numbersThings.get(i);
                                        game.cursor.imageCarry.number--;
                                        numbers.put(i, game.cursor.imageCarry.imageTag);
                                        pictureThings.put(i, game.cursor.imageCarry.image);
                                        numbersThings.put(i,1);
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
                                if (numbers.get(i).equals("brick")) game.hero.bricks += numbersThings.get(i);
                                if (numbers.get(i).equals("board")) game.hero.boards += numbersThings.get(i);
                                if (numbers.get(i).equals("baseBottom")) game.hero.baseBottoms += numbersThings.get(i);
                                if (numbers.get(i).equals("baseWall")) game.hero.baseWalls += numbersThings.get(i);
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
        checkCrafts.check(this, game);
        for (int i = 0; i < 9; i++) {
            try {
                if (numbersThings.get(i) <= 0) {
                    numbersThings.put(i, 0);
                    pictureThings.put(i, null);
                    numbers.put(i, null);
                }
            } catch (NullPointerException e) {
            }

        }
    }

    public boolean craftCheck(HashMap<Integer, String> abs) {
        for (int i = 0; i < 9; i++) {
            try {
                if (!abs.get(i).equals(numbers.get(i))) return false;
            } catch (NullPointerException e) {
            }
        }
        return true;
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
            renderer.drawImage(pieces.get(9), pieces.get(9).x, pieces.get(9).y);
            if (canCraft.get("shovel")) {
                renderer.drawImage(craftResult.get("shovel"), pieces.get(9).x + (40 - craftResult.get("shovel").w) / 2, pieces.get(9).y + (40 - craftResult.get("shovel").w) / 2);
            }
            if (canCraft.get("baseBottom")) {
                renderer.drawImage(craftResult.get("baseBottom"), pieces.get(9).x + (40 - craftResult.get("baseBottom").w) / 2, pieces.get(9).y + (40 - craftResult.get("baseBottom").w) / 2);
            }
            if (canCraft.get("baseWall")) {
                renderer.drawImage(craftResult.get("baseWall"), pieces.get(9).x + (40 - craftResult.get("baseWall").w) / 2, pieces.get(9).y + (40 - craftResult.get("baseWall").w) / 2);
            }
        }
    }
}
