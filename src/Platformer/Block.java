package Platformer;

import java.util.ArrayList;

public class Block extends hero{
    ArrayList <Integer> drew = new ArrayList<>();
    public Block(String path) {
        super(path);
    }
    int x = 0;
    int y = 0;
    public void create(int x, int y){
        d.add(new Image("PNG/Tiles/platformPack_tile001.png"));
        this.x = x;
        this.y = y;
    }
    public void update(GameManager gm){

    }
    public void draw(Renderer ren){
        ren.drawImageUp(this.d.get(0), this.x, this.y, drew);
    }
}
