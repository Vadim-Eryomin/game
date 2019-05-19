package StemFight;

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
        cr.craftResult.put("shovel", new ImageXY("Instruments/shovel.png", 0, 0));

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
        cr.craftResult.put("baseBottom", new ImageXY("Using/baseBottom.png",0,0));

        cr.baseWall.put(0,"brick");
        cr.baseWall.put(1,null);
        cr.baseWall.put(2,"brick");
        cr.baseWall.put(3,"brick");
        cr.baseWall.put(4,null);
        cr.baseWall.put(5,"brick");
        cr.baseWall.put(6,"brick");
        cr.baseWall.put(7,"brick");
        cr.baseWall.put(8,"brick");
        cr.baseWall.put(9,"baseWall");
        cr.craftResult.put("baseWall", new ImageXY("Using/baseWall.png",0,0));

        cr.baseRoof.put(0,null);
        cr.baseRoof.put(1,null);
        cr.baseRoof.put(2,null);
        cr.baseRoof.put(3,null);
        cr.baseRoof.put(4,"board");
        cr.baseRoof.put(5,null);
        cr.baseRoof.put(6,"board");
        cr.baseRoof.put(7,null);
        cr.baseRoof.put(8,"board");
        cr.baseRoof.put(9,"baseRoof");
        cr.craftResult.put("baseRoof", new ImageXY("Using/baseRoof.png",0,0));

        cr.base.put(0,null);
        cr.base.put(1,"baseRoof");
        cr.base.put(2,null);
        cr.base.put(3,null);
        cr.base.put(4,"baseWall");
        cr.base.put(5,null);
        cr.base.put(6,null);
        cr.base.put(7,"baseBottom");
        cr.base.put(8,null);
        cr.base.put(9,"base");
        cr.craftResult.put("base", new ImageXY("Using/base.png",0,0));

        cr.chest.put(0,"board");
        cr.chest.put(1,"board");
        cr.chest.put(2,"board");
        cr.chest.put(3,"board");
        cr.chest.put(4,null);
        cr.chest.put(5,"board");
        cr.chest.put(6,"board");
        cr.chest.put(7,"board");
        cr.chest.put(8,"board");
        cr.chest.put(9,"chest");
        cr.craftResult.put("chest", new ImageXY("Using/chest.png",0,0));

        cr.craftResult.put("runeOfRegeneration", new ImageXY("Using/runeOfRegen.png",0,0));
        cr.craftResult.put("piedestal", new ImageXY("Using/runePiedes.png",0,0));
        cr.craftResult.put("runeEngine", new ImageXY("Using/engine.png",0,0));
    }
}
