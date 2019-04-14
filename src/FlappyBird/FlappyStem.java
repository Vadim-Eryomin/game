package FlappyBird;


import Engine.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import static Engine.Max.range;

public class FlappyStem extends AbsractGame {
    int score = 0;
    int scored = 0;
    boolean ren = false;

    Random random = new Random();

    ImageXY bird = new ImageXY("../FlappyBird/hero.png", 2, 405);
    boolean up = false;

    ArrayList<ImageXY> blocks = new ArrayList<>();
    ImageXY ex = new ImageXY("../FlappyBird/platformPack_tile001.png", 0, 0);
    int spawnSeconds = 0;

    Image fon = new Image("../FlappyBird/fon.jpg");
    GameContainer gc = new GameContainer(this);

    public FlappyStem() {
        blocks.add(new ImageXY("../FlappyBird/platformPack_tile001.png", -1, 500));
        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    scored++;
                    score = scored / 1000;
                }


            }
        }.start();
        for (ImageXY im : blocks) im.x--;
        if (!up) bird.y++;
        if (gc.input.isButtonDown(1) || gc.input.isKeyDown(KeyEvent.VK_SPACE))
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 60; i++) {
                        up = true;
                        bird.y -= 2;
                        try {
                            Thread.sleep(2);
                        } catch (InterruptedException e) {
                        }
                    }
                    up = false;
                }
            }.start();
        if (collision(bird, blocks.get(0))) bird.y--;

        if (spawnSeconds >= 1000) {
            createColumn();
            spawnSeconds = 0;
        }
        spawnSeconds++;

        bird.x = range(bird.x, 0, 1355);
        bird.y = range(bird.y, 0, 855);

        for (ImageXY bl : blocks) {
            if (collision(bird, bl)) {
                for (int i = blocks.size() - 1; i < -1; i--) {
                    blocks.remove(i);
                }
                ren = true;
            }
        }

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        renderer.drawImage(fon, 0, 0);
        if (!ren) {
            renderer.drawImage(bird, bird.x, bird.y);
            for (int i = 0; i < blocks.size(); i++) {
                renderer.drawImage(blocks.get(i), blocks.get(i).x, blocks.get(i).y);
            }
            renderer.drawText("SCORE: " + score, 0, 0, 0xffffffff);
        } else {
            renderer.drawText("YOU LOSE!", 660, 200, 0xffffffff);
        }
    }

    public boolean collision(ImageXY A, ImageXY B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.h;


        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;
        return true;
    }

    public boolean collisionY(ImageXY A, ImageXY B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.w;

        int objBMinX = B.x;
        int objBMaxX = B.x + B.w;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        return true;
    }

    public void createColumn() {
        int a = random.nextInt(20) + 10;
        for (int i = 0; i < 31; i++)
            if (!(i - 2 == a || i - 1 == a || i == a || i + 1 == a || i + 2 == a))
                blocks.add(new ImageXY("../FlappyBird/platformPack_tile001.png", 32, i * ex.h));
    }

    public static void main(String[] args) {
        new FlappyStem();
    }
}
