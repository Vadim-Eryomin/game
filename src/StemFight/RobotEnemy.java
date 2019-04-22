package StemFight;

import Engine.ImageXY;
import Engine.Renderer;

import java.util.ArrayList;

public class RobotEnemy extends Robot {
    ImageXY field = new ImageXY("../StemFight/Using/field500.png", 0, 0);
    boolean rightAt = false;
    boolean leftAt = false;
    boolean upAt = false;
    boolean downAt = false;

    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    int secondsRenderer = 0;

    int delayTime = 0;
    int needDelayTime = 300;
    ArrayList<Code> codes = new ArrayList<>();

    @Override
    public void create(int x, int y) {
        super.create(x, y);
        images.add(new ImageXY("../StemFight/Using/robotWalk.png",0,0));
        images.add(new ImageXY("../StemFight/Using/robotWalkL.png",0,0));
    }

    @Override
    public void update(Game game) {
        field.x = x - ((field.w - w) / 2);
        field.y = y - ((field.h - h) / 2);
        for (Code c:codes)c.update(game);
        if (game.collision(game.hero, field)) {
            if (game.hero.x > x) leftAt = true;
            if (game.hero.x < x) rightAt = true;
            if (game.hero.y > y) downAt = true;
            if (game.hero.y < y) upAt = true;
            if (delayTime >= needDelayTime) {
                codes.add(new Code());
                codes.get(codes.size()-1).down = this.upAt;
                codes.get(codes.size()-1).up = this.downAt;
                codes.get(codes.size()-1).right = this.leftAt;
                codes.get(codes.size()-1).left = rightAt;
                codes.get(codes.size()-1).create(x,y,codes.get(codes.size()-1).up, codes.get(codes.size()-1).right, codes.get(codes.size()-1).left, codes.get(codes.size()-1).down);
                codes.get(codes.size()-1).update(game);
                delayTime = 0;
            }
        }
        else{
            if (game.hero.x > x) x++;
            if (game.hero.x < x) x--;
            if (game.hero.y > y) y++;
            if (game.hero.y < y) y--;
        }
        delayTime++;
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(images.get(0), x, y);
        for (Code c:codes)c.renderer(renderer);
    }

    public void attack() {

    }

    @Override
    public void death(Game game) {

    }
}
