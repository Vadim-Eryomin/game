package StemFight;

import static StemFight.Max.range;
import static StemFight.Change.*;

import java.util.ArrayList;

public class Enemy extends Player {
    ArrayList<Image> d = new ArrayList<>();
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    int hp = 70;
    int seconds = 0;
    int updateSeconds = 0;
    boolean right = true;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        d.add(new Image("Using/zombie_stand.png"));
        d.add(new Image("Using/zombie_walk1.png"));
        d.add(new Image("Using/zombie_walk2.png"));
        d.add(new Image("Using/zombie_standL.png"));
        d.add(new Image("Using/zombie_walk1L.png"));
        d.add(new Image("Using/zombie_walk2L.png"));
        this.w = d.get(0).w;
        this.h = d.get(0).h;
    }


    @Override
    public void update(Game game) {
        if (updateSeconds%3 == 0){
            if (!(game.hero.x == x)) {
                if (game.hero.x < x) {
                    right = false;
                    seconds++;
                    x--;
                } else {
                    right = true;
                    seconds++;
                    x++;
                }
            }
            if (!(game.hero.y == y)){
                if (game.hero.y < y) {
                    seconds++;
                    y--;
                } else {
                    seconds++;
                    y++;
                }
            }
            if ((game.hero.x == x) && (game.hero.y == y)) seconds = 0;
        }
        x = range(x, 200, 4000);
        updateSeconds++;

    }

    @Override
    public void renderer(Renderer renderer) {
        try {
            if (right) {
                if (0 <= seconds % 180 && seconds % 180 <= 60) renderer.drawImage(d.get(0), x, y);
                if (60 < seconds % 180 && seconds % 180 <= 120) renderer.drawImage(d.get(1), x, y);
                if (120 < seconds % 180 && seconds % 180 <= 180) renderer.drawImage(d.get(2), x, y);
            } else {
                if (0 <= seconds % 180 && seconds % 180 <= 60) renderer.drawImage(d.get(3), x, y);
                if (60 < seconds % 180 && seconds % 180 <= 120) renderer.drawImage(d.get(4), x, y);
                if (120 < seconds % 180 && seconds % 180 <= 180) renderer.drawImage(d.get(5), x, y);
            }
        }catch (IndexOutOfBoundsException e){}

    }

    @Override
    public void death(Game game) {
        game.hero.xp+=10;
        if (getChange(80)){
            game.brickParticles.add(new BrickParticle());
            game.brickParticles.get(game.brickParticles.size()-1).create(this.x, this.y);
        }
        if (getChange(40)){
            game.boards.add(new Board());
            game.boards.get(game.boards.size()-1).create(this.x, this.y);
        }
    }
}
