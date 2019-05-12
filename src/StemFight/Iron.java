package StemFight;

public class Iron implements Player {
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    ImageXY iron = new ImageXY("Using/iron.png",0,0);
    boolean lived = true;
    @Override
    public void create(int x, int y) {
        iron.x = x;
        iron.y = y;
    }

    @Override
    public void update(Game game) {
        if (game.collision(game.hero, iron)){
            System.out.println("la");
            death(game);
        }
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(iron, iron.x, iron.y);
    }

    @Override
    public void death(Game game) {
        System.out.println("la");
        game.hero.irons++;
        lived = false;
    }
}
