package StemFight;

import StemFight.Buildings.CraftingFrame;

public class CheckCrafts {
    public void check(CraftingFrame cr, Game game){
        if (cr.craftCheck(cr.shovel)) {
            cr.canCraft.put(cr.shovel.get(9), true);
            if (game.gc.input.isButtonDown(1)) {
                if (game.collision(cr.pieces.get(9), game.cursor.cursor)) {
                    if (game.cursor.imageCarry.image == null) {
                        game.hero.shovels++;
                        cr.canCraft.put(cr.shovel.get(9), false);
                        for (int i = 0; i < 9; i++) {
                            if (cr.shovel.get(i) != null) try {
                                cr.numbersThings.put(i, cr.numbersThings.get(i) - 1);
                            } catch (NullPointerException e) {
                            }
                        }
                    }
                }
            }
        }
        else if (cr.craftCheck(cr.baseBottom)) {
            cr.canCraft.put(cr.baseBottom.get(9), true);
            if (game.gc.input.isButtonDown(1)) {
                if (game.collision(cr.pieces.get(9), game.cursor.cursor)) {
                    if (game.cursor.imageCarry.image == null) {
                        game.hero.baseBottoms++;
                        cr.canCraft.put(cr.baseBottom.get(9), false);
                        for (int i = 0; i < 9; i++) {
                            if (cr.baseBottom.get(i) != null) try {
                                cr.numbersThings.put(i, cr.numbersThings.get(i) - 1);
                            } catch (NullPointerException e) {
                            }
                        }
                    }
                }
            }
        }
        else {
            cr.canCraft.put(cr.shovel.get(9), false);
            cr.canCraft.put(cr.baseBottom.get(9), false);
        }

    }
}
