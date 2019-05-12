package StemFight;

public abstract class FramesForGame {

    public boolean visible = false;
    public int x = 0;
    public int y = 0;
    public int w = 0;
    public int h = 0;

    public abstract void create(int x, int y);
    public abstract void update(Game game);
    public abstract void setVisible(boolean vis);
    public abstract void renderer(Renderer renderer);
}
