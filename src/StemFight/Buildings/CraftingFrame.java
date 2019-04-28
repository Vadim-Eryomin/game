package StemFight.Buildings;

import Engine.ImageXY;
import Engine.Player;
import Engine.Renderer;
import StemFight.BrickParticle;
import StemFight.Game;

import java.util.ArrayList;
import java.util.HashMap;

public class CraftingFrame {
    ImageXY fon = new ImageXY("../StemFight/Using/fonBase.png",0,0);
    ImageXY table = new ImageXY("../StemFight/Using/table.png",0,0);

    String name = "Base";
    boolean visible = true;
    int stringX = 0;
    int stringY = 0;

    HashMap<Integer, ImageXY> pictureThings = new HashMap<>();
    HashMap<Integer, Integer> numbersThings = new HashMap<>();
    HashMap<Integer, String> numbers = new HashMap<>();

    int oneTablePiece = 30;

    public void create(int x, int y){
        fon.x = x;
        fon.y = y;
        table.x = fon.x + 10;
        table.y = fon.y + 20;
        stringX = table.x + 90;
        stringY = table.y;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public void update(Game game){
        if (game.gc.input.isButtonDown(1)){
            if (game.collision(table, game.cursor.cursor)){
                int x = game.cursor.cursor.x;
                int y = game.cursor.cursor.y;
                if (table.x < x && table.x + oneTablePiece > x && table.y < y && table.y + oneTablePiece > y){
                    numbers.put(0, game.cursor.imageCarry.imageTag);
                    pictureThings.put(0, game.cursor.imageCarry.image);
                    try{numbersThings.put(0, numbersThings.get(0)+1);} catch (NullPointerException e){numbersThings.put(0, 1);}
                    game.cursor.imageCarry.number--;
                }
                // TODO: 28.04.2019
            }
        }
    }
    public void renderer(Renderer renderer){
        if (visible){
            renderer.drawImage(fon, fon.x, fon.y);
            renderer.drawImage(table, table.x, table.y);
            renderer.drawText(name, stringX, stringY, 0xffffffff);
            for (int i = 0; i < 9; i++) {
                if (pictureThings.get(i) != null) renderer.drawImage(pictureThings.get(i),table.x,table.y);
            }
        }
    }
}
