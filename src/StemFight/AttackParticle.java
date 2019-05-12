package StemFight;

public class AttackParticle implements Player {
    Image particle = new Image("Using/magic_05(2).png");
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;

    int seconds = 0;
    int secondsLives = 0;

    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;

    @Override
    public void create(int x, int y) {

    }

    @Override
    public void update(Game game) {
        if (right) x++;
        if (left) x--;
        if (up) y--;
        if (down) y++;
        seconds++;
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(particle, x, y);
    }

    public void create(Game game) {
        this.x = game.hero.x + game.hero.w / 2;
        this.y = game.hero.y + game.hero.h / 2;
        this.w = particle.w;
        this.h = particle.h;

        if (game.hero.y < game.gc.input.mouseY && game.hero.y + game.hero.h > game.gc.input.mouseY) {
            up = false;
            down = false;
        } else if (game.hero.y > game.gc.input.mouseY) {
            up = true;
        } else down = true;

        if (game.hero.x < game.gc.input.mouseX && game.hero.x + game.hero.w > game.gc.input.mouseX) {
            right = false;
            left = false;
        } else if (game.hero.x > game.gc.input.mouseX) {
            left = true;
            game.hero.right = false;
        } else {
            right = true;
            game.hero.right = true;
        }

    }

    @Override
    public void death(Game game) {

    }
}
