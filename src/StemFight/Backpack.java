package StemFight;

import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;

import java.util.ArrayList;
import java.util.HashMap;

public class Backpack {
    int things = 1;

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

    Integer baseBottoms = 0;
    ImageXY baseBottom;

    Integer baseWalls = 0;
    ImageXY baseWall;

    Integer baseRoofs = 0;
    ImageXY baseRoof;

    Integer bases = 0;
    ImageXY base;

    Integer chests = 0;
    ImageXY chest;

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
        baseBottom  = new ImageXY("../StemFight/Using/baseBottom.png",0,0);
        baseWall  = new ImageXY("../StemFight/Using/baseWall.png",0,0);
        baseRoof = new ImageXY("../StemFight/Using/baseRoof.png",0,0);
        base = new ImageXY("../StemFight/Using/base.png",0,0);
        chest = new ImageXY("../StemFight/Using/minichest.png",0,0);
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
            board.x = x + (things%4) * 55;
            board.y = y + (things/4) * 55;
            numbersThings.put("board", boards);
            things++;
        }
        if (tag.equals("shovel")){
            images.add(shovel);
            numbers.put(images.size()-1,"shovel");
            pictureThings.put("shovel", shovel);
            shovel.x = x + (things%4) * 55;
            shovel.y = y + (things/4) * 55;
            numbersThings.put("shovel", shovels);
            things++;

        }
        if (tag.equals("crafts")){
            images.add(craftingTable);
            numbers.put(images.size()-1,"crafts");
            pictureThings.put("crafts", craftingTable);
            craftingTable.x = x + (things%4) * 55;
            craftingTable.y = y + (things/4) * 55;
            numbersThings.put("crafts", craftingTables);
            things++;

        }
        if (tag.equals("baseBottom")){
            images.add(baseBottom);
            numbers.put(images.size()-1,"baseBottom");
            pictureThings.put("baseBottom", baseBottom);
            baseBottom.x = x + (things%4) * 55;
            baseBottom.y = y + (things/4) * 55;
            numbersThings.put("baseBottom", baseBottoms);
            things++;
        }
        if (tag.equals("baseWall")){
            images.add(baseWall);
            numbers.put(images.size()-1,"baseWall");
            pictureThings.put("baseWall", baseWall);
            baseWall.x = x + (things%4) * 55;
            baseWall.y = y + (things/4) * 55;
            numbersThings.put("baseWall", baseWalls);
            things++;
        }
        if (tag.equals("baseRoof")){
            images.add(baseRoof);
            numbers.put(images.size()-1,"baseRoof");
            pictureThings.put("baseRoof", baseRoof);
            baseRoof.x = x + (things%4) * 55;
            baseRoof.y = y + (things/4) * 55;
            numbersThings.put("baseRoof", baseRoofs);
            things++;
        }
        if (tag.equals("base")){
            images.add(base);
            numbers.put(images.size()-1,"base");
            pictureThings.put("base", base);
            base.x = x + (things%4) * 55;
            base.y = y + (things/4) * 55;
            numbersThings.put("base", bases);
            things++;
        }
        if (tag.equals("extract")){
            images.add(extract);
            numbers.put(images.size()-1,"extract");
            pictureThings.put("extract", extract);
            extract.x = x + (things%4) * 55;
            extract.y = y + (things/4) * 55;
            numbersThings.put("extract", extracts);
            things++;
        }
        if (tag.equals("chest")){
            images.add(chest);
            numbers.put(images.size()-1,"chest");
            pictureThings.put("chest", chest);
            chest.x = x + (things%4) * 55;
            chest.y = y + (things/4) * 55;
            numbersThings.put("chest", chests);
            things++;
        }
    }


    public void update(Game game) {
        brickParcticle = game.hero.bricks;
        boards = game.hero.boards;
        shovels = game.hero.shovels;
        craftingTables = game.hero.craftingTables;
        baseBottoms = game.hero.baseBottoms;
        baseWalls = game.hero.baseWalls;
        baseRoofs = game.hero.baseRoofs;
        bases = game.hero.bases;
        extracts = game.hero.extracts;
        chests = game.hero.chests;
        for (int i = 0; i < images.size(); i++) {
            if (numbers.get(i).equals("brick")) numbersThings.put(numbers.get(i),brickParcticle);
            if (numbers.get(i).equals("board")) numbersThings.put(numbers.get(i),boards);
            if (numbers.get(i).equals("shovel")) numbersThings.put(numbers.get(i),shovels);
            if (numbers.get(i).equals("crafts")) numbersThings.put(numbers.get(i),craftingTables);
            if (numbers.get(i).equals("baseBottom")) numbersThings.put(numbers.get(i),baseBottoms);
            if (numbers.get(i).equals("baseWall")) numbersThings.put(numbers.get(i), baseWalls);
            if (numbers.get(i).equals("baseRoof")) numbersThings.put(numbers.get(i), baseRoofs);
            if (numbers.get(i).equals("base")) numbersThings.put(numbers.get(i), bases);
            if (numbers.get(i).equals("extract")) numbersThings.put(numbers.get(i), extracts);
            if (numbers.get(i).equals("chest")) numbersThings.put(numbers.get(i), chests);

        }
    }

    public void renderer(Renderer renderer) {
        for (int i = 0; i < images.size(); i++) {
            renderer.drawImage(pictureThings.get(numbers.get(i)),pictureThings.get(numbers.get(i)).x, pictureThings.get(numbers.get(i)).y);
            renderer.drawText(numbersThings.get(numbers.get(i)).toString(),pictureThings.get(numbers.get(i)).x + 40, pictureThings.get(numbers.get(i)).y + 40, 0xffffffff);
        }
    }

}
