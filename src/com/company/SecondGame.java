package com.company;

import javax.crypto.spec.GCMParameterSpec;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SecondGame extends AbsractGame {
    static GameContainer gc = new GameContainer(new SecondGame());
    Image exit = new Image("Exit.png");
    Image image;
    boolean win = false;

    {
        image = new Image("secondFon.png");
    }

    public ArrayList<GameObject> objects = new ArrayList<>();
    public ArrayList<GameObject> blocks = new ArrayList<>();
    public ArrayList<GameObject> spikes = new ArrayList<>();
    float ups = 0;
    boolean jump = true;
    int a = 0;

    public SecondGame() {
        objects.add(new Player(0, 0, 0));
        //*********************************************//
        blocks.add(new Block(300, 500, 0));
        blocks.add(new Block(275, 500, 0));
        blocks.add(new Block(250, 500, 0));
        blocks.add(new Block(225, 500, 0));
        blocks.add(new Block(200, 500, 0));
        blocks.add(new Block(175, 500, 0));
        blocks.add(new Block(150, 500, 0));
        blocks.add(new Block(125, 500, 0));
        blocks.add(new Block(100, 500, 0));
        blocks.add(new Block(75, 500, 0));
        blocks.add(new Block(50, 500, 0));
        blocks.add(new Block(25, 500, 0));
        blocks.add(new Block(0, 500, 0));


        blocks.add(new Block(1000, 500, 0));
        blocks.add(new Block(975, 500, 0));
        blocks.add(new Block(950, 500, 0));
        blocks.add(new Block(925, 500, 0));
        blocks.add(new Block(900, 500, 0));
        blocks.add(new Block(875, 500, 0));
        blocks.add(new Block(850, 500, 0));
        blocks.add(new Block(825, 500, 0));
        blocks.add(new Block(800, 500, 0));
        blocks.add(new Block(775, 500, 0));
        blocks.add(new Block(750, 500, 0));
        blocks.add(new Block(725, 500, 0));
        blocks.add(new Block(700, 500, 0));
        blocks.add(new Block(675, 500, 0));
        blocks.add(new Block(650, 500, 0));
        blocks.add(new Block(625, 500, 0));
        blocks.add(new Block(600, 500, 0));
        blocks.add(new Block(575, 500, 0));
        blocks.add(new Block(550, 500, 0));
        blocks.add(new Block(525, 500, 0));
        blocks.add(new Block(500, 500, 0));
        blocks.add(new Block(475, 500, 0));
        blocks.add(new Block(450, 500, 0));
        blocks.add(new Block(425, 500, 0));

        //*************************************************//

        blocks.add(new BlockDown(300, 525, 0));
        blocks.add(new BlockDown(275, 525, 0));
        blocks.add(new BlockDown(250, 525, 0));
        blocks.add(new BlockDown(225, 525, 0));
        blocks.add(new BlockDown(200, 525, 0));
        blocks.add(new BlockDown(175, 525, 0));
        blocks.add(new BlockDown(150, 525, 0));
        blocks.add(new BlockDown(125, 525, 0));
        blocks.add(new BlockDown(100, 525, 0));
        blocks.add(new BlockDown(75, 525, 0));
        blocks.add(new BlockDown(50, 525, 0));
        blocks.add(new BlockDown(25, 525, 0));
        blocks.add(new BlockDown(0, 525, 0));

        blocks.add(new BlockDown(300, 550, 0));
        blocks.add(new BlockDown(275, 550, 0));
        blocks.add(new BlockDown(250, 550, 0));
        blocks.add(new BlockDown(225, 550, 0));
        blocks.add(new BlockDown(200, 550, 0));
        blocks.add(new BlockDown(175, 550, 0));
        blocks.add(new BlockDown(150, 550, 0));
        blocks.add(new BlockDown(125, 550, 0));
        blocks.add(new BlockDown(100, 550, 0));
        blocks.add(new BlockDown(75, 550, 0));
        blocks.add(new BlockDown(50, 550, 0));
        blocks.add(new BlockDown(25, 550, 0));
        blocks.add(new BlockDown(0, 550, 0));


        blocks.add(new BlockDown(1000, 525, 0));
        blocks.add(new BlockDown(975, 525, 0));
        blocks.add(new BlockDown(950, 525, 0));
        blocks.add(new BlockDown(925, 525, 0));
        blocks.add(new BlockDown(900, 525, 0));
        blocks.add(new BlockDown(875, 525, 0));
        blocks.add(new BlockDown(850, 525, 0));
        blocks.add(new BlockDown(825, 525, 0));
        blocks.add(new BlockDown(800, 525, 0));
        blocks.add(new BlockDown(775, 525, 0));
        blocks.add(new BlockDown(750, 525, 0));
        blocks.add(new BlockDown(725, 525, 0));
        blocks.add(new BlockDown(700, 525, 0));
        blocks.add(new BlockDown(675, 525, 0));
        blocks.add(new BlockDown(650, 525, 0));
        blocks.add(new BlockDown(625, 525, 0));
        blocks.add(new BlockDown(600, 525, 0));
        blocks.add(new BlockDown(575, 525, 0));
        blocks.add(new BlockDown(550, 525, 0));
        blocks.add(new BlockDown(525, 525, 0));
        blocks.add(new BlockDown(500, 525, 0));
        blocks.add(new BlockDown(475, 525, 0));
        blocks.add(new BlockDown(450, 525, 0));
        blocks.add(new BlockDown(425, 525, 0));

        blocks.add(new BlockDown(1000, 550, 0));
        blocks.add(new BlockDown(975, 550, 0));
        blocks.add(new BlockDown(950, 550, 0));
        blocks.add(new BlockDown(925, 550, 0));
        blocks.add(new BlockDown(900, 550, 0));
        blocks.add(new BlockDown(875, 550, 0));
        blocks.add(new BlockDown(850, 550, 0));
        blocks.add(new BlockDown(825, 550, 0));
        blocks.add(new BlockDown(800, 550, 0));
        blocks.add(new BlockDown(775, 550, 0));
        blocks.add(new BlockDown(750, 550, 0));
        blocks.add(new BlockDown(725, 550, 0));
        blocks.add(new BlockDown(700, 550, 0));
        blocks.add(new BlockDown(675, 550, 0));
        blocks.add(new BlockDown(650, 550, 0));
        blocks.add(new BlockDown(625, 550, 0));
        blocks.add(new BlockDown(600, 550, 0));
        blocks.add(new BlockDown(575, 550, 0));
        blocks.add(new BlockDown(550, 550, 0));
        blocks.add(new BlockDown(525, 550, 0));
        blocks.add(new BlockDown(500, 550, 0));
        blocks.add(new BlockDown(475, 550, 0));
        blocks.add(new BlockDown(450, 550, 0));
        blocks.add(new BlockDown(425, 550, 0));

        //***********************************************//

        spikes.add(new Spikes(325, 550, 0));
        spikes.add(new Spikes(350, 550, 0));
        spikes.add(new Spikes(375, 550, 0));
        spikes.add(new Spikes(400, 550, 0));

        //***********************************************//

        blocks.add(new BlockDown(300, 0  , 0));
        blocks.add(new BlockDown(300, 25 , 0));
        blocks.add(new BlockDown(300, 50 , 0));
        blocks.add(new BlockDown(300, 75 , 0));
        blocks.add(new BlockDown(300, 100, 0));
        blocks.add(new BlockDown(300, 125, 0));
        blocks.add(new BlockDown(300, 150, 0));
        blocks.add(new BlockDown(300, 175, 0));
        blocks.add(new BlockDown(300, 200, 0));
        blocks.add(new BlockDown(300, 225, 0));
        blocks.add(new BlockDown(300, 250, 0));
        blocks.add(new BlockDown(325, 250  , 0));
        blocks.add(new BlockDown(350, 250 , 0));
        blocks.add(new BlockDown(375, 250 , 0));
        blocks.add(new BlockDown(400, 250 , 0));
        blocks.add(new BlockDown(425, 250, 0));
        blocks.add(new BlockDown(450, 250, 0));
        blocks.add(new BlockDown(475, 250, 0));
        blocks.add(new BlockDown(500, 250, 0));
        blocks.add(new BlockDown(525, 250, 0));
        blocks.add(new BlockDown(550, 250, 0));
        blocks.add(new BlockDown(575, 250, 0));
        blocks.add(new BlockDown(600, 250, 0));
        blocks.add(new BlockDown(625, 250,0));


    }

    @Override
    public void update(GameContainer gc, float dt) {
        jump = false;

        for (int i = 0; i <= 0; i++) {
            if (objects.size() == 0) break;
            objects.get(i).posY += 1;
            for (int j = 0; j <= blocks.size() - 1; j++) {
                if (gc.input.isKey(KeyEvent.VK_A)) {
                    if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                        objects.get(i).posY += 1;
                        ups = 0;
                        a = 0;
                        objects.get(i).right = false;
                        objects.get(i).seconds++;
                    } else objects.get(i).posX -= 0.005;
                }
                if (gc.input.isKeyUp(KeyEvent.VK_A)) objects.get(i).seconds = 0;
                if (gc.input.isKey(KeyEvent.VK_D)) {
                    if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                        objects.get(i).posY -= 1;
                        ups = 0;
                        a = 0;
                        objects.get(i).right = true;
                        objects.get(i).seconds++;
                    } else objects.get(i).posX += 0.005;
                }
                if (gc.input.isKeyUp(KeyEvent.VK_D)) objects.get(i).seconds = 0;
                if (gc.input.isKeyDown(KeyEvent.VK_SPACE) || gc.input.isKeyDown(KeyEvent.VK_W)) {
                    if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                        objects.get(i).posY += 1;
                        ups = 0;
                        a = 0;
                    } else if (ups <= 10000) {
                        for (int k = 0; k < 1500; k++) {
                            objects.get(0).posY -= 0.001;
                        }
                        ups++;
                    }
                }

                if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                    objects.get(i).posY += 0.1;
                }
                if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                    objects.get(i).posY -= 0.1;
                }
                if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                    objects.get(i).posY += 0.1;
                }
                if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) blocks.get(j).posX, (int) blocks.get(j).posY, blocks.get(j).image, objects.get(i).image, false)) {
                    objects.get(i).posY -= 2;
                }


            }
            for (int j = 0; j < spikes.size(); j++) {
                if (gc.colllision.collisionTrue((int) objects.get(i).posX, (int) objects.get(i).posY, (int) spikes.get(j).posX, (int) spikes.get(j).posY, spikes.get(j).image, objects.get(i).image, false)) {
                    objects.get(i).dead = true;
                }

            }
            if (objects.get(i).posX < 0) objects.get(i).posX = 0;
            if (objects.get(i).posY < 0) objects.get(i).posY = 0;
            if (objects.get(i).posX > 1055) objects.get(i).posX = 1055;
            if (objects.get(i).posY > 695) {
                objects.get(i).dead = true;
            }


            objects.get(i).update(gc, dt);

            if (objects.get(i).dead) {
                objects.get(i).posY = 0;
                objects.get(i).posX = 0;
                objects.get(i).dead = false;
            }

        }
    }


    @Override
    public void renderer(GameContainer gc, Renderer renderer) {
        renderer.drawImage(image, 0, 0);
        renderer.drawImage(exit, 800, 402);
        if (objects.size() != 0) {
            for (GameObject obj : objects) {
                obj.render(gc, renderer);
            }

        }
        for (GameObject obj : blocks) {
            obj.render(gc, renderer);
        }
        for (GameObject obj : spikes) {
            obj.render(gc, renderer);
        }
        if (gc.colllision.collisionTrue((int) objects.get(0).posX, (int) objects.get(0).posY, 800, 402, exit, objects.get(0).image, false)){
            win = true;
        }
        if (objects.get(0).dead)win = false;
        if (win)renderer.drawText("YOU ARE WIN!!!", 480,100,0xFFFFFF);



    }

    public static void main(String[] args) {

        gc.start();
    }


}
