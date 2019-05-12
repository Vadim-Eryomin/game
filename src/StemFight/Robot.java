package StemFight;

import java.util.ArrayList;

public class Robot implements Player {
    ImageXY robot = new ImageXY("Using/robotWalk.png",0,0);
    ArrayList<ImageXY> images = new ArrayList<>();

    boolean helper = false;
    int hp = 200;
    int xp = 0;

    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = robot.w;
        this.h = robot.h;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void renderer(Renderer renderer) {

    }

    @Override
    public void death(Game game) {

    }
}
