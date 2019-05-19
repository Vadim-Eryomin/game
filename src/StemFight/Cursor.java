package StemFight;

public class Cursor {
    public ImageXY cursor = new ImageXY("Using/cursor.png", 0, 0);
    public ImageCarry imageCarry = new ImageCarry();
    boolean doing = false;

    public void create(int x, int y) {
    }

    public void update(Game game) {
        doing = false;
        cursor.x = game.gc.input.mouseX;
        cursor.y = game.gc.input.mouseY;
        if (game.gc.input.isButtonDown(1)) {
            for (int i = 0; i < game.backpack.numbers.size(); i++) {
                if (game.backpack.pictureThings.get(game.backpack.numbers.get(i)).x < cursor.x && game.backpack.pictureThings.get(game.backpack.numbers.get(i)).x + game.backpack.pictureThings.get(game.backpack.numbers.get(i)).w > cursor.x) {
                    if (game.backpack.pictureThings.get(game.backpack.numbers.get(i)).y < cursor.y && game.backpack.pictureThings.get(game.backpack.numbers.get(i)).y + game.backpack.pictureThings.get(game.backpack.numbers.get(i)).h > cursor.y) {
                        if (imageCarry.image == null) {
                            imageCarry.get(game.backpack.pictureThings.get(game.backpack.numbers.get(i)), game.backpack.numbersThings.get(game.backpack.numbers.get(i)), game.backpack.numbers.get(i));
                            if (game.backpack.numbers.get(i).equals("brick")) {
                                game.backpack.brickParcticle = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("board")) {
                                game.backpack.boards = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("shovel")) {
                                game.backpack.shovels = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("crafts")) {
                                game.backpack.craftingTables = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("baseBottom")) {
                                game.backpack.baseBottoms = 0;
                                game.backpack.baseBottoms = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("baseWall")) {
                                game.backpack.baseWalls = 0;
                                game.backpack.baseWalls = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("baseRoof")) {
                                game.backpack.baseRoofs = 0;
                                game.backpack.baseRoofs = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("base")) {
                                game.backpack.bases = 0;
                                game.backpack.bases = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("extract")) {
                                game.backpack.extracts = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("chest")) {
                                game.backpack.chests = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }if (game.backpack.numbers.get(i).equals("iron")) {
                                game.backpack.irons = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }
                            if (game.backpack.numbers.get(i).equals("runeOfRegeneration")) {
                                game.backpack.runeOfRegenerations = 0;
                                game.backpack.numbersThings.put(game.backpack.numbers.get(i), 0);
                            }if (game.backpack.numbers.get(i).equals("piedestal")) {
                                game.backpack.piedestals = 0;
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
                        if (imageCarry.imageTag.equals("shovel")){
                            game.backpack.shovels += imageCarry.number;
                            imageCarry.set();
                        }
                        if (imageCarry.imageTag.equals("crafts")){
                            game.craftingTable.create(cursor.x, cursor.y);
                        }
                        if (imageCarry.imageTag.equals("baseBottom")){
                            game.backpack.baseBottoms += imageCarry.number;
                            imageCarry.set();
                        }
                        if (imageCarry.imageTag.equals("baseWall")){
                            game.backpack.baseWalls += imageCarry.number;
                            imageCarry.set();
                        }
                        if (imageCarry.imageTag.equals("baseRoof")){
                            game.backpack.baseRoofs += imageCarry.number;
                            imageCarry.set();
                        }
                        if (imageCarry.imageTag.equals("base")){
                            game.base.create(0, 500, cursor.x, cursor.y);
                            imageCarry.set();
                        }
                        if (imageCarry.imageTag.equals("extract")){
                            game.backpack.extracts += imageCarry.number;
                            imageCarry.set();
                        }
                        if (imageCarry.imageTag.equals("chest")){
                            game.chest.create(0, 500, cursor.x, cursor.y);
                            imageCarry.set();
                        }if (imageCarry.imageTag.equals("iron")){
                            game.irons.add(new Iron());
                            game.irons.get(game.irons.size()-1).create(game.gc.input.mouseX, game.gc.input.mouseY);
                        }if (imageCarry.imageTag.equals("runeOfRegeneration")){
                            game.rune.create(game.gc.input.mouseX, game.gc.input.mouseY);
                        }if (imageCarry.imageTag.equals("piedestal")){
                            game.pied.create(game.gc.input.mouseX, game.gc.input.mouseY);
                        }

                        // TODO: 03.05.2019 сделать классы для лопаты, основания базы...
                    }
                    imageCarry.set();
                }
                else if (game.gc.input.mouseX > 1100){
                    if (imageCarry.imageTag.equals("brick")){
                        game.backpack.brickParcticle += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("board")){
                        game.backpack.boards += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("shovel")){
                        game.backpack.shovels += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("crafts")){
                        game.backpack.craftingTables += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("baseBottom")){
                        game.backpack.baseBottoms += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("baseWall")){
                        game.backpack.baseWalls += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("baseRoof")){
                        game.backpack.baseRoofs += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("base")){
                        game.backpack.bases += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("base")){
                        game.backpack.extracts += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("chest")){
                        game.backpack.chests += imageCarry.number;
                    }
                    if (imageCarry.imageTag.equals("iron")){
                        game.backpack.irons += imageCarry.number;
                    }if (imageCarry.imageTag.equals("runeOfRegeneration")){
                        game.backpack.runeOfRegenerations += imageCarry.number;
                    }if (imageCarry.imageTag.equals("runeOfRegeneration")){
                        game.backpack.piedestals += imageCarry.number;
                    }
                    imageCarry.set();
                }
            }
        }
        if (imageCarry.number <= 0)imageCarry.set();
    }

    public void renderer(Renderer renderer) {
        renderer.drawImage(cursor, cursor.x, cursor.y);
        if (imageCarry.image != null) {
            renderer.drawImage(imageCarry.image, cursor.x + 5, cursor.y + 5);
            renderer.drawText(imageCarry.number.toString(), cursor.x + cursor.w, cursor.y + cursor.h, 0xffffffff);
        }
    }
}
