package StemFight;

public class CharFrame extends FramesForGame {
    Image fon = new Image("Skills/fonChars.png");
    Image XP = new Image("Skills/experience.png");
    Image head = new Image("Skills/head_focus.png");
    Image HP = new Image("Skills/heart.png");
    int hp = 0;
    int xp = 0;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(Game game) {
        this.hp = game.hero.hp;
        this.xp = game.hero.xp;
    }

    @Override
    public void setVisible(boolean vis) {
        visible = vis;
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(fon,x,y);
        renderer.drawImage(head,x+5,y+5);
        renderer.drawText("Player",x+60, y+5, 0xffffffff);
        renderer.drawImage(XP, x+60, y+20);
        renderer.drawText(""+xp, x+90,y+20, 0xffffffff);
        renderer.drawImage(HP, x+60, y+50);
        renderer.drawText(""+hp, x+90,y+50, 0xffffffff);
    }
}
