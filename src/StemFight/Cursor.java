package StemFight;

import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;

public class Cursor {
    ImageXY cursor = new ImageXY("../StemFight/Using/cursor.png", 0, 0);
    ImageCarry imageCarry = new ImageCarry();

    public void create(int x, int y) {
    }

    public void update(Game game) {
        cursor.x = game.gc.input.mouseX - cursor.w/2;
        cursor.y = game.gc.input.mouseY;
        if (game.gc.input.isButtonDown(1)) {
            for (int i = 0; i < game.backpack.numbers.size(); i++) {
                if (game.backpack.pictureThings.get(game.backpack.numbers.get(i)).x < cursor.x && game.backpack.pictureThings.get(game.backpack.numbers.get(i)).x + game.backpack.pictureThings.get(game.backpack.numbers.get(i)).w > cursor.x){
                    if (game.backpack.pictureThings.get(game.backpack.numbers.get(i)).y < cursor.y && game.backpack.pictureThings.get(game.backpack.numbers.get(i)).y + game.backpack.pictureThings.get(game.backpack.numbers.get(i)).h > cursor.y){
                        if (imageCarry.image == null) {
                            imageCarry.get(game.backpack.pictureThings.get(game.backpack.numbers.get(i)), game.backpack.numbersThings.get(game.backpack.numbers.get(i)));
                            if (game.backpack.numbers.get(i).equals("brick")) game.hero.bricks -= imageCarry.number;
                            game.backpack.numbersThings.put(game.backpack.numbers.get(i), game.backpack.numbersThings.get(game.backpack.numbers.get(i)) - imageCarry.number);
                        }
                        else {
                            imageCarry.set();
                        }
                    }
                }
            }
        }
    }

    public void renderer(Renderer renderer) {
        renderer.drawImage(cursor, cursor.x, cursor.y);
        if (imageCarry.image != null) {
            renderer.drawImage(imageCarry.image, cursor.x+5, cursor.y+5);
            renderer.drawText(imageCarry.number.toString(), cursor.x + cursor.w, cursor.y + cursor.h, 0xffffffff);
        }
    }
}
