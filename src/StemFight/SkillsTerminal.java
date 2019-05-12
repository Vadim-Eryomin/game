package StemFight;

public class SkillsTerminal extends FramesForGame {
    int terminal = 0;

    int x = 0;
    int y = 0;

    ImageXY fon = new ImageXY("Skills/sk.png", x, y);

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void setVisible(boolean vis) {
        visible = vis;
    }


    public void renderer(Game game, Renderer renderer) {
        renderer.drawImage(fon,x,y);
    }

    @Override
    public void renderer(Renderer renderer) {

    }
}
