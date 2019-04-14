package BossFight;

import java.util.ArrayList;

public class Attack {
    ArrayList<hero> partAtt = new ArrayList<>();
    public ArrayList<Integer> fx = new ArrayList<>();
    public ArrayList<Integer> fy = new ArrayList<>();
    Image image = new Image("PNG/Particles/magic_05(2).png");

    public Attack(GameManager gm) {

    }

    public void create(GameManager gm) {
        partAtt.add(new hero("PNG/Particles/magic_05.png",0,0));
        partAtt.get(partAtt.size() - 1).x = (int) (gm.heroX + gm.hero.w);
        partAtt.get(partAtt.size() - 1).y = (int) (gm.heroY + gm.hero.h / 2);


        if (gm.gc.input.mouseX > gm.heroX) partAtt.get(partAtt.size()-1).right = true;
        else partAtt.get(partAtt.size()-1).right = false;

        if (gm.gc.input.mouseY  >= gm.heroY) partAtt.get(partAtt.size()-1).down = true;
        if (gm.gc.input.mouseY > gm.hero.d.get(0).h/2) // TODO: доделать проработку по центру
        if (gm.gc.input.mouseY + gm.hero.d.get(0).h + 50 <= gm.heroY) partAtt.get(partAtt.size()-1).up = true;


        fx.add(partAtt.get(partAtt.size() - 1).x);
        fy.add(partAtt.get(partAtt.size() - 1).y);
    }

    public void update(GameManager gm) {
        for (int i = 0; i < partAtt.size(); i++) {
            if (partAtt.get(i).right){
                partAtt.get(i).x += 3;
                partAtt.get(i).seconds++;
            }
            else {
                partAtt.get(i).x -= 3;
                partAtt.get(i).seconds--;
            }
            if (partAtt.get(i).up){
                partAtt.get(i).y -= 3;
            }
            if (partAtt.get(i).down){
                partAtt.get(i).y += 3;
            }

            if (partAtt.get(i).seconds >= 100) {
                partAtt.remove(i);
            }
        }
    }

    public void draw(Renderer renderer) {
        for (int i = 0; i < partAtt.size(); i++) {
            renderer.drawImage(image, partAtt.get(i).x, partAtt.get(i).y);
        }
    }
}
