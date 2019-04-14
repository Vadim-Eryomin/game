package StemFight;

import Engine.FramesForGame;
import Engine.Image;
import Engine.ImageXY;
import Engine.Renderer;


public class skillRobotFrame extends FramesForGame {
    int x = 0;
    int y = 0;
    int skillPoints = 3;
    boolean choice = true;

    Image fon = new Image("../StemFight/Skills/fonSkills.png");

    ImageXY[] gear = new ImageXY[2];
    boolean gears = false;

    ImageXY[] robot = new ImageXY[2];
    boolean robots = false;

    ImageXY[] earthPick = new ImageXY[2];
    boolean earthPicks = false;

    boolean can = false;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;

        gear[0] = new ImageXY("../StemFight/Skills/nonA_gear.png", (x+80), y+40);
        gear[1] = new ImageXY("../StemFight/Skills/gear.png", (x+80), y+40);

        robot[0] = new ImageXY("../StemFight/Skills/nonA_brush.png",x+80, y+80);
        robot[1] =  new ImageXY("../StemFight/Skills/brush.png", x+80, y+80);

        earthPick[0] = new ImageXY("../StemFight/Skills/nonA_earthPick.png",x+80, y+120);
        earthPick[1] =  new ImageXY("../StemFight/Skills/earthPick.png", x+80, y+120);

    }

    @Override
    public void update(Game game) {
        if (choice){
            if (skillPoints > 0) can = true;
            else can = false;
        }
        else can = false;

        if (can){
            if (!gears){
                if (isClick(gear[0], game)) {
                    skillPoints--;
                    gears = true;
                }
            }
            else {
                if (!robots){
                    if (isClick(robot[0], game)) {
                        skillPoints--;
                        robots = true;
                    }
                }
                else{
                    if (isClick(earthPick[0], game)) {
                        skillPoints--;
                        earthPicks = true;
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

        if (!gears) renderer.drawImage(gear[0], x+80, y+40);
        else renderer.drawImage(gear[1], x+80, y+40);

        if (!robots) renderer.drawImage(robot[0], robot[0].x, robot[0].y);
        else renderer.drawImage(robot[1], robot[0].x, robot[0].y);

        if (!earthPicks)renderer.drawImage(earthPick[0], earthPick[0].x, earthPick[0].y);
        else renderer.drawImage(earthPick[1], earthPick[0].x, earthPick[0].y);

    }

    public boolean isClick(ImageXY im, Game game){
        if (game.gc.input.isButtonDown(1) && game.gc.input.mouseX > im.x && game.gc.input.mouseX < im.x + im.w && game.gc.input.mouseY > im.y && game.gc.input.mouseY < im.y + im.h)
            return true;
        return false;
    }
}
