package BossFight.nulling;

import BossFight.Image;

public class ImageXY extends Image {
    public int x = 0;
    public int y = 0;
    public int w = 0;
    public int h = 0;
    public ImageXY(String path, int x, int y) {
        super(path);
        this.x = x * super.w;
        this.y = y;
        this.w = super.w;
        this.h = super.h;
    }

}
