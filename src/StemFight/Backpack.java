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

    int nails = 0;
    ImageXY nail;

    Integer extracts = 0;
    ImageXY extract;

//    int x = 0;
//    int y = 0;
//    public void create(Game game){
//        x = game.chars.x + 10;
//        y = game.chars.y + 200;
//

//        bricks.x = x;
//        bricks.y = y;
//

//        board.x = x;
//        board.y = y + 50;
//

//        extract.x = x;
//        extract.y = y + 100;
//
//    }
//    public void update(Game game){
//        brickParcticle = game.hero.bricks;
//        boards = game.hero.boards;
//        extracts = game.hero.extracts;
//    }
//    public void renderer(Renderer renderer){
//        renderer.drawImage(bricks, bricks.x, bricks.y);
//        renderer.drawText(brickParcticle.toString(), bricks.x + 60, bricks.y, 0xffffffff);
//
//        renderer.drawImage(board, board.x, board.y);
//        renderer.drawText(boards.toString(), board.x + 60, board.y + 20, 0xffffffff);
//
//        renderer.drawImage(extract, extract.x, extract.y);
//        renderer.drawText(extracts.toString(), extract.x + 60, extract.y + 20, 0xffffffff);
//    }
    ArrayList<ImageXY> images = new ArrayList<>();
    HashMap<Integer, String> numbers = new HashMap<>();
    HashMap<String, ImageXY> pictureThings = new HashMap<>();
    HashMap<String, Integer> numbersThings = new HashMap<>();

    int x, y;
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        bricks = new ImageXY("../StemFight/Using/platformPack_tile004.png",0,0);
        board = new ImageXY("../StemFight/Using/board.png",0,0);
        extract = new ImageXY("../StemFight/Using/extract.png",0,0);
        images.add(bricks);
        numbers.put(images.size()-1,"brick");
        pictureThings.put("brick", bricks);
        numbersThings.put("brick", brickParcticle);
    }
    public void addThings(String tag){
        if (tag.equals("board")){
            images.add(board);
            numbers.put(images.size()-1,"board");
            pictureThings.put("board", board);
            numbersThings.put("board", boards);
        }
    }

    public void update(Game game) {
        brickParcticle = game.hero.bricks;
        boards = game.hero.boards;
        for (int i = 0; i < images.size(); i++) {
            if (numbers.get(i).equals("brick")) numbersThings.put(numbers.get(i),brickParcticle);
            if (numbers.get(i).equals("board")) numbersThings.put(numbers.get(i),boards);
        }
    }

    public void renderer(Renderer renderer) {
        for (int i = 0; i < images.size(); i++) {
            renderer.drawImage(pictureThings.get(numbers.get(i)),x + i * 50, y);
            renderer.drawText(numbersThings.get(numbers.get(i)).toString(),x + i * 50 + pictureThings.get(numbers.get(i)).w, y+30, 0xffffffff);
        }
    }

}
