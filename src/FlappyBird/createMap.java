package FlappyBird;

import Engine.ImageXY;
import Engine.Renderer;

import java.util.ArrayList;
import java.util.Random;

public class createMap {
    ArrayList<ImageXY> blocks = new ArrayList<>();
    int x = 0;
    int a = 0;

    public createMap(int x) {
        this.x = x;
        a = creates();
    }

    ImageXY im = new ImageXY("../FlappyBird/platformPack_tile001.png", 0, 0);
    Random random = new Random();

    public int creates() {
        int a = random.nextInt(20);
        return a;
    }

    public void create() {
        for (int i = 0; i < 30; i++) {
            if (!(i - 2 != a || i - 1 != a || i != a || i + 1 != a || i + 2 != a))
                blocks.add(new ImageXY("../FlappyBird/platformPack_tile001.png", x, i * im.h));
        }
    }
}
