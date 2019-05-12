package StemFight;

import java.util.ArrayList;

public class ImageButton extends Image {
    ArrayList<Integer> drawed = new ArrayList<>();
    public ImageButton(String path) {
        super(path);
    }
    public Image image;
    public void create(String path){
        image = new Image(path);
    }
    int x = 0;
    int y = 0;
    public void draw(Renderer renderer, int x, int y){
        this.x = x;
        this.y = y;
        renderer.drawImage(image,this.x,this.y);
    }
    public boolean isClick(GameContainer gc){
        return this.isClick(image,gc,x,y);
    }
}
