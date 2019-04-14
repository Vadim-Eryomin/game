package BossFight;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    public int w, h;
    public int[] p;

    public Image(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        w = image.getWidth();
        h = image.getHeight();


        p = image.getRGB(0, 0, w, h, null, 0, w);
        image.flush();

    }
    public boolean isClick(Image image, GameContainer gc, int x, int y){
        if (gc.input.isButtonDown(1)){
         if ((x<(gc.input.mouseX) && gc.input.mouseX < x+image.w) && (y<(gc.input.mouseY) && gc.input.mouseY < y+image.h)){
             return true;
         }

        }return false;
    }
}
