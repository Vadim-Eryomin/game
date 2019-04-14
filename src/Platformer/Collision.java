package Platformer;

public class Collision {
    public void collision(hero e, hero he) {
        if (he.x < e.ex && he.x + he.w > e.ex) e.ex++;
        if (he.x < e.ex + e.w && e.ex + e.w < he.x + he.w) e.ex--;
        if (he.y < e.ey && he.y + he.h > e.ey) e.ey++;
        if (he.y < e.ey + e.h && e.ey + he.h < he.y + he.h) e.ey--;
    }
}

