package StemFight;

import Engine.ImageXY;

public class ImageCarry {
    ImageXY image = null;
    Integer number = 0;
    String imageTag = "";
    public void get(ImageXY im, int number, String imageTag){
        if (image == null) {
            this.image = im;
            this.number = number;
            this.imageTag = imageTag;
        }
    }
    public void set(){
        if (image != null) {
            this.image = null;
            this.number = 0;
            this.imageTag = "";
        }
    }
}
