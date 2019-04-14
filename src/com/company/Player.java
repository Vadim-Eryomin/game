package com.company;

import java.io.IOException;

public class Player extends GameObject {
    Image rect = new Image("heroRight.png");
    Image rect1 = new Image("heroRight1.png");
    Image rectL = new Image("heroLeft.png");
    Image rectL1 = new Image("heroLeft1.png");

    public Player(float posX, float posY, float ups) {
        this.image = rect;
        this.tag = "player";
        this.ups = ups;
        this.seconds = seconds;
        this.posX = posX * 16;
        this.posY = posY * 16;


    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        if (right) {
            if (seconds % 160 >= 80) {
                image = rect1;
            } else {
                image = rect;
            }
        } else {
            if (seconds % 160 >= 80) {
                image = rectL1;
            } else {
                image = rectL;
            }
        }
        renderer.drawImage(image, (int) posX, (int) (this.posY - ups));


    }
}
