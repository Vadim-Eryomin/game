package com.company;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class GameManager extends AbsractGame {
    Random random = new Random();
    boolean stopCollision = false;
    int lives = 3;
    int bestScore = 0;
    int stones = 0;
    int speed = 1;
    int enemyX = 200, enemyY = 0;
    int x = 0, y = 100;


        Image fon;

    {

            fon = new Image("fon.png");

    }

    Image image;

    {

            image = new Image("Hero.png");

    }

    Image enemy;

    {

            enemy = new Image("enemy.png");

    }


    @Override
    public void update(GameContainer gc, float dt) {
        if (gc.input.isKeyDown(KeyEvent.VK_F)) {
            lives = 3;
            stones = 0;
            speed = 1;
            enemyX = 200;
            enemyY = 0;
            x = 0;
            y = 0;
            stopCollision = false;


        }
        if (gc.input.isKey(KeyEvent.VK_W)) {
            y--;
        }
        if (gc.input.isKey(KeyEvent.VK_S)) {
            y++;

        }
        if (gc.input.isKey(KeyEvent.VK_A)) {
            x--;

        }
        if (gc.input.isKey(KeyEvent.VK_D)) {
            x++;

        }

    }

    @Override
    public void renderer(GameContainer gc, Renderer renderer) {

        renderer.drawImage(fon, 0, 0);
        renderer.drawImage(image, x, y);
        renderer.drawText("LIVES:" + lives, 0, 0, 0xffffff);
        renderer.drawText("SPEED:" + speed, 0, 20, 0xffffff);
        renderer.drawText("SCORE:" + stones, 0, 40, 0xffffff);
        renderer.drawText("BEST SCORE:"+ bestScore, 0, 80, 0xffffff);


        if (enemyY + enemy.h >= gc.renderer.pH) {
            enemyY = 0;
            enemyX = random.nextInt(1080);
            stones++;
            speed++;
        }
        if (gc.colllision.collisionTrue(x, y, enemyX, enemyY, enemy, image, stopCollision)) {
            enemyY = 0;
            enemyX = random.nextInt(1080);
            speed = 1;
            lives--;
        }
        if (x <= 0) {
            x += 5;
        }
        if (x + image.w >= renderer.pW) {
            x -= 5;
        }
        if (y <= 0) {
            y += 5;
        }
        if (y + image.h >= renderer.pH) {
            y -= 5;
        }
        if (lives == 0) {
            renderer.drawText("PRESS F TO RETURN TO GAME",0, 60, 0xffffff);
            stopCollision = true;
            speed = 0;

            if (stones > bestScore) bestScore = stones;
        }
        enemyY += speed;
        renderer.drawImage(enemy, enemyX, enemyY);


    }

    public static void main(String[] args) {
        GameContainer gameContainer = new GameContainer(new GameManager());
        gameContainer.start();
    }
}
