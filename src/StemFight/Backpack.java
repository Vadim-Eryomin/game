package StemFight;

import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;

import java.util.ArrayList;
import java.util.HashMap;

public class Backpack {
    Integer brickParcticle = 0;
    ImageXY bricks;

    int flashes = 0;
    ImageXY flash;

    Integer boards = 0;
    ImageXY board;

    public Integer shovels = 0;
    public ImageXY shovel;

    int nails = 0;
    ImageXY nail;

    Integer extracts = 0;
    ImageXY extract;

    Integer craftingTables = 0;
    ImageXY craftingTable;

    ArrayList<ImageXY> images = new ArrayList<>();
    HashMap<Integer, String> numbers = new HashMap<>();
    HashMap<String, ImageXY> pictureThings = new HashMap<>();
    HashMap<String, Integer> numbersThings = new HashMap<>();

    int x, y;
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        bricks = new ImageXY("../StemFight/Using/platformPack_tile004.png",0,0);
        shovel = new ImageXY("../StemFight/Instruments/shovel.png",0,0);
        board = new ImageXY("../StemFight/Using/board.png",0,0);
        extract = new ImageXY("../StemFight/Using/extract.png",0,0);
        craftingTable = new ImageXY("../StemFight/Using/craftingTableMini.png",0,0);
        images.add(bricks);
        numbers.put(images.size()-1,"brick");
        pictureThings.put("brick", bricks);
        bricks.x = x;
        bricks.y = y;
        numbersThings.put("brick", brickParcticle);
    }
    public void addThings(String tag){
        if (tag.equals("board")){
            images.add(board);
            numbers.put(images.size()-1,"board");
            pictureThings.put("board", board);
            board.x = x + (pictureThings.size()-1) * 50;
            board.y = y;
            numbersThings.put("board", boards);
        }
        if (tag.equals("shovel")){
            images.add(shovel);
            numbers.put(images.size()-1,"shovel");
            pictureThings.put("shovel", shovel);
            shovel.x = x + (pictureThings.size()-1) * 50;
            shovel.y = y;
            numbersThings.put("shovel", shovels);
        }
        if (tag.equals("crafts")){
            images.add(craftingTable);
            numbers.put(images.size()-1,"crafts");
            pictureThings.put("crafts", craftingTable);
            craftingTable.x = x + (pictureThings.size()-1) * 50;
            craftingTable.y = y;
            numbersThings.put("crafts", craftingTables);
        }
    }


    public void update(Game game) {
        brickParcticle = game.hero.bricks;
        boards = game.hero.boards;
        shovels = game.hero.shovels;
        craftingTables = game.hero.craftingTables;
        for (int i = 0; i < images.size(); i++) {
            if (numbers.get(i).equals("brick")) numbersThings.put(numbers.get(i),brickParcticle);
            if (numbers.get(i).equals("board")) numbersThings.put(numbers.get(i),boards);
            if (numbers.get(i).equals("shovel")) numbersThings.put(numbers.get(i),shovels);
            if (numbers.get(i).equals("crafts")) numbersThings.put(numbers.get(i),craftingTables);

        }
    }

    public void renderer(Renderer renderer) {
        for (int i = 0; i < images.size(); i++) {
            renderer.drawImage(pictureThings.get(numbers.get(i)),x + i * 50, y);
            renderer.drawText(numbersThings.get(numbers.get(i)).toString(),x + i * 50 + pictureThings.get(numbers.get(i)).w, y+30, 0xffffffff);
        }
    }

}
