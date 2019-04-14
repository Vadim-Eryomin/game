package BossFight;

import java.util.ArrayList;
import java.util.Random;

public class Map extends Image {
    ArrayList<Integer> drawed = new ArrayList<>();
    public Map(String path) {
        super(path);
    }

    ArrayList<Image> images = new ArrayList<>();
    ArrayList<String> paths = new ArrayList<>();
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();
    Image fon = new Image("fon.png");
    Random r = new Random();

    public void create() {
        for (int i = 1; i < 100; i++) {
            Integer c = r.nextInt(16);
            String path = "PNG/Nature/foliagePack_" + c  + ".png";
            paths.add(c.toString());
            images.add(new Image(path));
            int a = r.nextInt(4000);
            int b = r.nextInt(4000);
            if (x.isEmpty()){
                boolean falser = true;
                for (int j = 0; j < images.size() - 2; j++) {
                    if (a == x.get(j)-1) falser = false;
                    if (b == y.get(j)-1) falser = false;
                }
                if (falser){
                    x.add(a);
                    y.add(b);
                }
                else {
                    i--;
                }
            }
            else {
                x.add(a);
                y.add(b);
            }


        }
    }

    public void draw(GameManager gm, Renderer renderer) {
        renderer.drawImage(fon, (int)gm.cameraX, (int)gm.cameraY);
        gm.hero.draw(renderer,(int)gm.heroX,(int)gm.heroY);
        for (int i = 0; i < images.size(); i++) {
            if (paths.get(i).equals("12") || paths.get(i).equals("13") || paths.get(i).equals("14") || paths.get(i).equals("15") || paths.get(i).equals("16") || paths.get(i).equals("17")){
                renderer.drawImage(images.get(i), x.get(i) + (int)gm.cameraX, y.get(i) + (int)gm.cameraY);
            }
        }
        for (int i = 1; i < images.size(); i++) {
            if (!paths.get(i).equals("12") && !paths.get(i).equals("13") && !paths.get(i).equals("14") && !paths.get(i).equals("15") && !paths.get(i).equals("16") && !paths.get(i).equals("17")) {
                if (paths.get(i).equals("8") || paths.get(i).equals("9") || paths.get(i).equals("10") || paths.get(i).equals("11")){
                    renderer.drawImage(images.get(i), x.get(i) + (int) gm.cameraX, y.get(i) + (int) gm.cameraY);
                }
            }
        }
        for (int i = 1; i < images.size(); i++) {
            if (!paths.get(i).equals("12") && !paths.get(i).equals("13") && !paths.get(i).equals("14") && !paths.get(i).equals("15") && !paths.get(i).equals("16") && !paths.get(i).equals("17")) {
                if (!paths.get(i).equals("8") && !paths.get(i).equals("9") && !paths.get(i).equals("10") && !paths.get(i).equals("11")){
                    renderer.drawImage(images.get(i), x.get(i) + (int) gm.cameraX, y.get(i) + (int) gm.cameraY);
                }
            }
        }



    }
}
