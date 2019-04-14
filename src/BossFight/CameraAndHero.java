package BossFight;

import static BossFight.Max.range;

public class CameraAndHero {
    public void setCameraAndHero(GameManager gm) {
        gm.cameraX = range((int) (-gm.heroX * gm.coef), -(gm.map.w - gm.d.width), 0);
        gm.cameraY = range((int) (-gm.heroY * gm.coef), -(gm.map.h - gm.d.height), 0);
        gm.heroX = range((int) gm.heroX, 0, 1400 - gm.hero.w);
        gm.heroY = range((int) gm.heroY, 0, 900 - gm.hero.h);
    }
}
