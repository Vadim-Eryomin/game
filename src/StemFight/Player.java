package StemFight;

public interface Player{
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    public void create(int x, int y);
    public void update(Game game);
    public void renderer(Renderer renderer);
    public void death(Game game);
}
