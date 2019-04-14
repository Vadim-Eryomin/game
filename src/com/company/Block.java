package com.company;

import java.io.IOException;

public class Block extends GameObject {
    Image rect;

    {

            rect = new Image("block.png");

    }

    public Block(float possX, float possY, float ups) {
        this.image = rect;
        this.tag = "block";
        this.ups = ups;
        this.posX = possX;
        this.posY = possY;
    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(image, (int) posX, (int) posY);

    }
}
