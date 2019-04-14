package BossFight;


public class Colllision {
    public final int RETURN_TO_LEFT = 1;
    public final int RETURN_TO_RIGHT = 2;
    public final int RETURN_TO_UP = 3;
    public final int RETURN_TO_DOWN = 4;

    public int collisionTrue(int side, Enemy enemy, hero hero) {
        switch (side){
            case 1:
                if (rettoright(enemy,hero)) return RETURN_TO_RIGHT;
                break;
            case 2:
                if (rettoleft(enemy,hero)) return RETURN_TO_LEFT;
                break;
            case 3:
                if (rettoup(enemy,hero)) return RETURN_TO_UP;
                break;
            case 4:
                if (rettodonw(enemy,hero)) return RETURN_TO_DOWN;
                break;
        }
        return 0;
    }
    public int collisionTrue(Enemy enemy, hero hero) {
                if (rettoright(enemy,hero)) return RETURN_TO_RIGHT;
                if (rettoleft(enemy,hero)) return RETURN_TO_LEFT;
                if (rettoup(enemy,hero)) return RETURN_TO_UP;
                if (rettodonw(enemy,hero)) return RETURN_TO_DOWN;
        return 0;
    }
    public int collisionTrue(Enemy enemy, Image image, int x, int y) {
        if (enemy.x < x + image.w && enemy.x + enemy.w > x + image.w){
            return RETURN_TO_RIGHT;
        }
        if (enemy.x < x && enemy.x + enemy.w > x){
            return RETURN_TO_LEFT;
        }
        if (enemy.y < y + image.h && enemy.y + enemy.h > y + image.h){
            return RETURN_TO_UP;
        }
        if (enemy.y < y && enemy.y + enemy.h > y){
            return RETURN_TO_DOWN;
        }
        return 0;
    }
    public boolean rettoright(Enemy enemy, hero hero){
        if (enemy.x < hero.x + hero.w && enemy.x + enemy.w > hero.x + hero.w){
            return true;
        }
        return false;
    }
    public boolean rettoleft(Enemy enemy, hero hero){
        if (enemy.x < hero.x && enemy.x + enemy.w > hero.x){
            return true;
        }
        return false;
    }
    public boolean rettodonw(Enemy enemy, hero hero){
        if (enemy.y < hero.y && enemy.y + enemy.h > hero.y){
            return true;
        }
        return false;
    }
    public boolean rettoup(Enemy enemy, hero hero){
        if (enemy.y < hero.y + hero.h && enemy.y + enemy.h > hero.y + hero.h){
            return true;
        }
        return false;
    }
}
