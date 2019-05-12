package StemFight;

public abstract class Player{
    public int x = 0;
    public int y = 0;
    public int w = 0;
    public int h = 0;
    public ImageXY imageXY;
    public abstract void create(int x, int y);
    public abstract void update(Game game);
    public abstract void renderer(Renderer renderer);
    public abstract void death(Game game);
}
