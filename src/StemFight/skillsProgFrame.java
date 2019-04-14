package StemFight;

import Engine.FramesForGame;
import Engine.Image;
import Engine.ImageXY;
import Engine.Renderer;

public class skillsProgFrame extends FramesForGame {

    int x = 0;
    int y = 0;
    int skillPoints = 3;
    boolean choice = true;

    Image fon = new Image("../StemFight/Skills/fonSkills.png");

    ImageXY[] code = new ImageXY[2];
    boolean codes = false;

    ImageXY[] heal = new ImageXY[2];
    boolean heals = false;

    ImageXY[] wall = new ImageXY[2];
    boolean walls = false;

    boolean can = false;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;

        code[0] = new ImageXY("../StemFight/Skills/nonA_code.png", (x+80), y+40);
        code[1] = new ImageXY("../StemFight/Skills/code.png", (x+80), y+40);

        heal[0] = new ImageXY("../StemFight/Skills/nonA_heal.png",x+80, y+80);
        heal[1] =  new ImageXY("../StemFight/Skills/heal.png", x+80, y+80);

        wall[0] = new ImageXY("../StemFight/Skills/nonA_wall.png",x+80, y+120);
        wall[1] =  new ImageXY("../StemFight/Skills/wall.png", x+80, y+120);
    }

    @Override
    public void update(Game game) {
        if (choice){
            if (skillPoints > 0) can = true;
            else can = false;
        }
        else can = false;

        if (can){
            if (!codes){
                if (isClick(code[0], game)) {
                    skillPoints--;
                    codes = true;
                }
            }
            else {
                if (!heals){
                    if (isClick(heal[0], game)) {
                        skillPoints--;
                        heals = true;
                    }
                }
                else{
                    if (isClick(wall[0], game)) {
                        skillPoints--;
                        walls = true;
                    }
                }
            }

        }
    }

    @Override
    public void setVisible(boolean vis) {
        visible = vis;
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(fon,x,y);
        if (can){
            renderer.drawText("Choice the skill!", x+15, y+10, 0xffffffff);
        }

        if (!codes) renderer.drawImage(code[0], x+80, y+40);
        else renderer.drawImage(code[1], x+80, y+40);

        if (!heals) renderer.drawImage(heal[0], heal[0].x, heal[0].y);
        else renderer.drawImage(heal[1], heal[0].x, heal[0].y);

        if (!walls) renderer.drawImage(wall[0], wall[0].x, wall[0].y);
        else renderer.drawImage(wall[1], wall[0].x, wall[0].y);
    }
    public boolean isClick(ImageXY im, Game game){
        if (game.gc.input.isButtonDown(1) && game.gc.input.mouseX > im.x && game.gc.input.mouseX < im.x + im.w && game.gc.input.mouseY > im.y && game.gc.input.mouseY < im.y + im.h)
            return true;
        return false;
    }
}
