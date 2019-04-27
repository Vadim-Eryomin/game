package StemFight;

import Engine.ImageXY;

public class ImageCarry {
    ImageXY image = null;
    Integer number = 0;
    public void get(ImageXY im, int number){
        if (image == null) {
            this.image = im;
            this.number = number;
        }
    }
    public void set(){
        if (image != null) {
            this.image = null;
            this.number = 0;
        }
    }
}
