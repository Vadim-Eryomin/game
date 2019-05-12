package StemFight;

public class Key extends Player {
    Image brick = new Image("Using/key.png");
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    boolean lived = true;
    boolean collisional = true;
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = brick.w;
        this.h = brick.h;
    }

    public void update(Game game) {
        if (game.collision(game.hero, this) && collisional){
            death(game);
        }
    }

    public void renderer(Renderer renderer) {
        if (lived) renderer.drawImage(brick, x, y);
    }

    public void death(Game game) {
        game.hero.keyFirst = true;
        collisional = false;
        lived = false;
    }
}
