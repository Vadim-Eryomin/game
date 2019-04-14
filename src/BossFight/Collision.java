package BossFight;

public class Collision {
    public boolean collision(hero enemy, hero hero) {
        int relay = 0;

        int objAMinX = enemy.x ;
        int objAMaxX = enemy.x + enemy.w ;
        int objAMinY = enemy.y ;
        int objAMaxY = enemy.y + enemy.h ;

        int objBMinX = (hero.x );
        int objBMaxX = (hero.x - hero.w );
        int objBMinY = (hero.y );
        int objBMaxY = (hero.y - hero.h );

        if (hero.x < enemy.x && enemy.x + hero.w > enemy.x) relay++;
        else if (hero.x < enemy.x + enemy.w && enemy.x + enemy.w < hero.x + hero.w) relay++;

        if (hero.y < enemy.y && hero.y + hero.h > enemy.y) relay++;
        else if (hero.y < enemy.y + enemy.h && enemy.y + enemy.h < hero.y + hero.h) relay++;
        if (relay == 2) return true;
        return false;
    }
}

