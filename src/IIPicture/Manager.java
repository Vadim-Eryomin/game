package IIPicture;

import Engine.AbsractGame;
import Engine.GameContainer;
import Engine.Image;
import Engine.Renderer;

import java.awt.*;

public class Manager extends AbsractGame {
    GameContainer gc = new GameContainer(this);
    Image image = new Image("../IIPicture/IMG_20190423_172806.jpg");
    public Manager() {
        gc.start();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if (gc.input.isKeyDown(0)){
            Color color = new Color(gc.renderer.p[gc.input.mouseY*gc.renderer.pW+gc.input.mouseX]);
            System.out.println(color.getRed() +" "+ color.getGreen()+" "+ color.getBlue());
        }
    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        int[] p = renderer.p;
        Color color;

        renderer.drawImage(image,0,0);
        for (int y = 0; y < renderer.pH; y++) {
            for (int x = 0; x < renderer.pW; x++) {
                color = new Color(p[y*renderer.pW+x]);
                int r = color.getRed()/64;
                int g = color.getGreen()/64;
                int b = color.getBlue()/64;

                if (r <= 2 && g <= 2 && b >= 2) renderer.setPixel(x,y,0x0000ff);
                else if (r >= 2 && g <= 2 && b <= 2) renderer.setPixel(x,y,0xff0000);
                else if (r <= 2 && g >= 2 && b <= 2) renderer.setPixel(x,y,0x00ff00);
                else if (r >= 2 && g >= 2 && b <= 2) renderer.setPixel(x,y,0xffff00);
                else if (r >= 2 && g <= 2 && b >= 2) renderer.setPixel(x,y,0xff00ff);
                else if (r <= 2 && g >= 2 && b >= 2) renderer.setPixel(x,y,0x00ffff);
                else if (r >= 3 && g >= 3 && b >= 2) renderer.setPixel(x,y,0xf5f5cd);
                else if ((r >= 0 && g >= 0)&&(r <= 3 && g <= 3)) renderer.setPixel(x,y,0xffa500);
                else if (r >= 4 && g >= 4 && b >= 4) renderer.setPixel(x,y,0xffffff);
                else renderer.setPixel(x,y,0x000000);
//                if (color.getRed() <= 128 && color.getGreen() <= 128 && color.getBlue() >= 128) renderer.setPixel(x,y,0x0000ff); //blue
//                else if (color.getRed() <= 128 && color.getGreen() >= 128 && color.getBlue() <= 128) renderer.setPixel(x,y,0x00ff00); //green
//                else if (color.getRed() >= 128 && color.getGreen() <= 128 && color.getBlue() <= 128) renderer.setPixel(x,y,0x00ff00); //red
//                else if (color.getRed() >= 128 && color.getGreen() >= 128 && color.getBlue() <= 128) renderer.setPixel(x,y,0xffff00); //yellow
//                else if (color.getRed() <= 128 && color.getGreen() >= 128 && color.getBlue() >= 128) renderer.setPixel(x,y,0x00ffff); //light-blue
//                else if (color.getRed() >= 128 && color.getGreen() <= 128 && color.getBlue() >= 128) renderer.setPixel(x,y,0x00ffff); //purple
//                else if (color.getRed() >= 128 && color.getGreen() >= 128 && color.getBlue() >= 128) renderer.setPixel(x,y,0x00ffff); //white
//                else renderer.setPixel(x,y,0x000000);
            }
        }
        renderer.drawImage(image, image.w, 0);
    }

    public static void main(String[] args) {
        new Manager();
    }
}
