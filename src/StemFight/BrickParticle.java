package StemFight;

public class BrickParticle implements Player {
    Image brick = new Image("Using/platformPack_tile004.png");
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    boolean lived = true;
    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = brick.w;
        this.h = brick.h;
    }

    @Override
    public void update(Game game) {
        if (game.collision(game.hero, this)){
            death(game);
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(brick, x, y);
    }

    @Override
    public void death(Game game) {
        game.backpack.brickParcticle++;
        lived = false;
    }
}
