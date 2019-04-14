package BossFight.Mains;

import BossFight.*;


public class Menu extends AbsractGame {
    Image fon = new Image("MenuFon.png");
    ImageButton start = new ImageButton("PNG/buttonPlay.png");
    Image stem = new Image("PNG/стем.png");
    public Menu() {
        GameContainer gc = new GameContainer(this);
        start.create("PNG/ButtonPlay.png");
        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if (start.isClick(gc)) new Loading(gc.renderer);

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        renderer.drawImage(fon,0,0);
        renderer.drawImage(stem, 570,400);
        start.draw(renderer,500,700);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
