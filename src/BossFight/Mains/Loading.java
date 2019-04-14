package BossFight.Mains;

import BossFight.GameManager;
import BossFight.Image;
import BossFight.Renderer;

public class Loading {
    Image im = new Image("PNG/Particles/magic_05.png");
    public Loading(Renderer renderer){
        for (int i = 0; i < renderer.p.length; i++) {
            renderer.p[i] = 0;
        }
        renderer.drawImage(im,0,0);
        new GameManager();
    }
}
