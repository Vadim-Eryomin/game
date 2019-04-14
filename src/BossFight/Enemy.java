package BossFight;

import java.util.ArrayList;

public class Enemy extends hero{

    public Enemy(String path, int x, int y) {
        super(path, x, y);
    }
    boolean dead = false;
    ArrayList<Image> d = new ArrayList<>();
    public void create(int createdX, int createdY){
        hp = 70;
        d.add(new Image("PNG/Zombie/Poses/zombie_stand.png"));
        d.add(new Image("PNG/Zombie/Poses/zombie_walk1.png"));
        d.add(new Image("PNG/Zombie/Poses/zombie_walk2.png"));

        d.add(new Image("PNG/Zombie/Poses/zombie_stand.png"));
        d.add(new Image("PNG/Zombie/Poses/zombie_walk1L.png"));
        d.add(new Image("PNG/Zombie/Poses/zombie_walk2L.png"));

        x = createdX;
        y = createdY;
    }
    public void update(GameManager gm, int x, int y, hero hero){
        if (hero.x > this.x){
            left = false;
            right = true;
            seconds++;
            this.x++;
        }
        else if (hero.x == this.x){

        }
        else{
            right = false;
            left = true;
            seconds++;
            this.x--;
        }
        if (hero.y > this.y){
            seconds++;
            this.y++;
        }
        else {
            seconds++;
            this.y--;
        }
        if (hp == 0){dead = true;}
        if (dead) {
            gm.enemys.remove(this);
            gm.hero.xp+=20;
            gm.hero.hp+=10;
        }
    }
    public void draw(Renderer renderer){
        if (right){
            if (seconds == 0){
                renderer.drawImage(d.get(0),x,y);
            }
            else if (0 < seconds % 60 && seconds % 60 < 30){
                renderer.drawImage(d.get(1),x,y);
            }
            else {
                renderer.drawImage(d.get(2),x,y);
            }
        }
        if (left){
            if (seconds == 0){
                renderer.drawImage(d.get(3),x,y);
            }
            else if (0 < seconds % 60 && seconds % 60 < 30){
                renderer.drawImage(d.get(4),x,y);
            }
            else {
                renderer.drawImage(d.get(5),x,y);
            }
        }
    }
    public void spawn(GameManager gm){
        if (gm.secondsRespawn >= 600 - gm.hero.xp / 2) {
            gm.enemys.add(new Enemy("Hero.png",0,0));
            gm.enemys.get(gm.enemys.size() - 1).create(gm.random.nextInt(4000), gm.random.nextInt(4000));
            gm.secondsRespawn = 0;
        }
    }
}
