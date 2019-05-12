package StemFight;

public class Heal extends AttackParticle implements Player {
    Image particle = new Image("Skills/attHeal.png");

    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    boolean first = true;

    int secondsLived = 0;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = particle.w;
        this.h = particle.h;
    }

    @Override
    public void update(Game game) {
        this.x = game.hero.x;
        this.y = game.hero.y + 10;
        super.seconds++;
        if (first){
            game.hero.hp += 20;
            first = false;
        }
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
        super.secondsLives = 50;
        super.particle = particle;
        super.create(game);
        super.create(game);
    }

    @Override
    public void death(Game game) {
        super.death(game);
    }
}
