package com.company;

public abstract class GameObject {

    public float posX, posY;
    public Image image;
    public float ups;
    public int seconds;
    public float width, height;
    public String tag;
    public boolean dead = false;
    public boolean right = true;


    public abstract void update(GameContainer gc, float dt);
    public abstract void render(GameContainer gc, Renderer renderer);
}
