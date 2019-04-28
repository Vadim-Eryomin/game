package StemFight;

import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;

public class Cursor {
    public ImageXY cursor = new ImageXY("../StemFight/Using/cursor.png", 0, 0);
    public ImageCarry imageCarry = new ImageCarry();
    boolean doing = false;

    public void create(int x, int y) {
    }

    public void update(Game game) {
        doing = false;
        cursor.x = game.gc.input.mouseX - cursor.w / 2;
        cursor.y = game.gc.input.mouseY;
        if (game.gc.input.isButtonDown(1)) {
            for (int i = 0; i < game.backpack.numbers.size(); i++) {
                if (game.backpack.pictureThings.get(game.backpack.numbers.get(i)).x < cursor.x && game.backpack.pictureThings.get(game.backpack.numbers.get(i)).x + game.backpack.pictureThings.get(game.backpack.numbers.get(i)).w > cursor.x) {
                    if (game.backpack.pictureThings.get(game.backpack.numbers.get(i)).y < cursor.y && game.backpack.pictureThings.get(game.backpack.numbers.get(i)).y + game.backpack.pictureThings.get(game.backpack.numbers.get(i)).h > cursor.y) {
                        if (imageCarry.image == null) {
                            imageCarry.get(game.backpack.pictureThings.get(game.backpack.numbers.get(i)), game.backpack.numbersThings.get(game.backpack.numbers.get(i)), game.backpack.numbers.get(i));
                            if (game.backpack.numbers.get(i).equals("brick")) {
                                game.hero.bricks = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("board")) {
                                game.hero.boards = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            doing = true;
                        }
                    }
                }
            }
            if (imageCarry.image != null && imageCarry.number != 0 && !doing){
                if(game.gc.input.mouseX > 200 && game.gc.input.mouseX < 1100){
                    for (int j = 0; j <= imageCarry.number; j++) {
                        imageCarry.number--;
                        if (imageCarry.imageTag.equals("brick")){
                            game.brickParticles.add(new BrickParticle());
                            game.brickParticles.get(game.brickParticles.size()-1).create(game.gc.input.mouseX, game.gc.input.mouseY);
                        }
                        if (imageCarry.imageTag.equals("board")){
                            game.boards.add(new Board());
                            game.boards.get(game.boards.size()-1).create(game.gc.input.mouseX, game.gc.input.mouseY);
                        }


                    }
                    imageCarry.set();
                }
                else if (game.gc.input.mouseX > 1100){
                    if (imageCarry.imageTag.equals("brick")){
                        game.hero.bricks += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("board")){
                        game.hero.boards += imageCarry.number;
                    }
                    imageCarry.set();
                }
            }
        }
    }

    public void renderer(Renderer renderer) {
        renderer.drawImage(cursor, cursor.x, cursor.y);
        if (imageCarry.image != null) {
            renderer.drawImage(imageCarry.image, cursor.x + 5, cursor.y + 5);
            renderer.drawText(imageCarry.number.toString(), cursor.x + cursor.w, cursor.y + cursor.h, 0xffffffff);
        }
    }
}
