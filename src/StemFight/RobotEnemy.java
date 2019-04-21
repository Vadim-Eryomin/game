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

        if (game.hero.x > x) left = true;
        if (game.hero.x < x) right = true;
        if (game.hero.y > y) down = true;
        if (game.hero.y < y) up = true;

        if (game.collision(game.hero, field)) {
            if (game.hero.x > x) leftAt = true;
            if (game.hero.x < x) rightAt = true;
            if (game.hero.y > y) downAt = true;
            if (game.hero.y < y) upAt = true;
            if (delayTime >= needDelayTime) {
                codes.add(new Code());
                codes.get(codes.size()-1).up = this.upAt;
                codes.get(codes.size()-1).down = this.downAt;
                codes.get(codes.size()-1).left = this.leftAt;
                codes.get(codes.size()-1).right = rightAt;
                codes.get(codes.size()-1).update(game);
            }
        }
        else{

        }
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(images.get(0), images.get(0).x, images.get(0).y);
    }

    public void attack() {

    }

    @Override
    public void death(Game game) {

    }
}
