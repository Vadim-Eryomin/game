package com.company;


public class Colllision {
    public Colllision() {
    }

    public boolean collisionTrue(int x, int y, int enemyX, int enemyY, Image enemy, Image image, boolean stopCollision) {
        if (!stopCollision) {
//            if ((x > enemyX - 3 && x < enemyX + enemy.w) && (y + image.h > enemyY && y + image.h < enemyY + enemy.h))return true;
//            if ((x > enemyX - 3 && x < enemyX + enemy.w) && (y > enemyY - 3 && y < enemyY + enemy.h))return true;
//
            if (enemyX < x + image.w && x + image.w < enemyX + enemy.w && enemyY < y + image.h && y + image.h < enemyY + enemy.h)
                return true;
            if (enemyX < x && x < enemyX + enemy.w && enemyY < y + image.h && y + image.h < enemyY + enemy.h)
                return true;
            if (enemyX < x + image.w && x + image.w < enemyX + enemy.w && enemyY < y && y < enemyY + enemy.h)
                return true;
            if (enemyX < x && x < enemyX + enemy.w && enemyY < y && y < enemyY + enemy.h)
                return true;
        }
        return false;
    }
}
