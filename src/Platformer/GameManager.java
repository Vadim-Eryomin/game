package Platformer;

import java.util.ArrayList;

import static BossFight.Max.range;

public class GameManager extends AbsractGame {
    GameContainer gc = new GameContainer(this);
    boolean lockDown = false;
    hero hero = new hero("PNG/Player/Poses/player_walk1.png");
    Image image = new Image("fon.png");
    Image Tile = new Image("PNG/Tiles/platformPack_tile009.png");
    ArrayList<Block> block = new ArrayList<>();
    Collision collision = new Collision();
    int coefX = image.w / 1440;
    int coefY = image.h / 900;
    int cX = 0;
    int cY = 0;


    public GameManager() {
        block.add(new Block("PNG/Tiles/platformPack_tile001.png"));
        block.get(0).create(30, 500);
        hero.create(0, 0);
        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        hero.update(this, lockDown);
        block.get(0).update(this, lockDown);
        collision.collision(hero,block.get(0));
    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        renderer.drawImage(image, 0, 0);
        hero.draw(renderer, hero.x, hero.y);
        renderer.drawImage(Tile, gc.input.mouseX - Tile.w / 2 + 5, gc.input.mouseY - Tile.h / 2 + 10);
        block.get(0).draw(renderer);
    }

    public static void main(String[] args) {
        new GameManager();
    }

    public void cameraAndHero(int cX, int cY, int hX, int hY) {
        cX = range((int) (-hero.x * coefX), -(image.w - 1440), 0);
        cY = range((int) (-hero.y * coefY), -(image.h - 900), 0);
        hero.x = range(hero.x, 0, 1440 - hero.w - 20);
        hero.y = range(hero.y, 0, 900 - hero.h - 20);
    }
}
