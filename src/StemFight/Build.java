package StemFight;

import Engine.Renderer;
import StemFight.Buildings.Base;

import java.util.ArrayList;

public class Build {
    ArrayList<Building> buildings = new ArrayList<>();
    Base base = new Base();
    public void update(Game game){
        for (Building b:buildings) {
            b.update(game);
        }
    }
    public void renderer(Renderer renderer){
        for (Building b:buildings) {
            b.renderer(renderer);
        }
    }
}
