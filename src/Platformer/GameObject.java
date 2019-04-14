package Platformer;
public abstract class GameObject {

    public int posX, posY;
    public int lastPosX, lastPosY;
    public Image image;
    public float ups;
    public int seconds;
    public float width, height;
    public String tag;
    public boolean dead = false;
    public boolean right = true;
}
