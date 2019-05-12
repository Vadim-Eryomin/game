package StemFight;

public class Arrow extends AttackParticle{
    Image particle = new Image("Skills/attArrow.png");

    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;

    int secondsLived = 0;

    boolean up = false;
    boolean right = false;
    boolean left = false;
    boolean down = false;

    @Override
    public void update(Game game) {
        super.seconds = secondsLived;
        super.up = up;
        super.left = left;
        super.right = right;
        super.down = down;
        x = super.x;
        y = super.y;
        if (right) super.x++;
        if (left) super.x--;
        super.seconds++;
    }

    @Override
    public void renderer(Renderer renderer) {
        super.particle = this.particle;
        super.x = x;
        super.y = y;
        super.renderer(renderer);
    }

    @Override
    public void create(Game game) {
        super.secondsLives = 10000;
        super.particle = particle;
        super.create(game);
        up = super.up;
        down = super.down;
        right = super.right;
        left = super.left;
    }

    @Override
    public void death(Game game) {
        super.death(game);
    }
}
