package StemFight;

import Engine.ImageXY;
import StemFight.Buildings.CraftingFrame;

public class Crafts {
    public void create(CraftingFrame cr){
        cr.shovel.put(0, "brick");
        cr.shovel.put(1, null);
        cr.shovel.put(2, null);
        cr.shovel.put(3, null);
        cr.shovel.put(4, "brick");
        cr.shovel.put(5, "board");
        cr.shovel.put(6, null);
        cr.shovel.put(7, "board");
        cr.shovel.put(8, "board");
        cr.shovel.put(9, "shovel");
        cr.craftResult.put("shovel", new ImageXY("../StemFight/Instruments/shovel.png", 0, 0));

        cr.baseBottom.put(0,null);
        cr.baseBottom.put(1,null);
        cr.baseBottom.put(2,null);
        cr.baseBottom.put(3,"brick");
        cr.baseBottom.put(4,"brick");
        cr.baseBottom.put(5,"brick");
        cr.baseBottom.put(6,"brick");
        cr.baseBottom.put(7,"brick");
        cr.baseBottom.put(8,"brick");
        cr.baseBottom.put(9,"baseBottom");
        cr.craftResult.put("baseBottom", new ImageXY("../StemFight/Using/baseBottom.png",0,0));

    }
}
