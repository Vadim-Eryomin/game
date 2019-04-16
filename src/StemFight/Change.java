package StemFight;

import java.util.Random;

public class Change {
    static Random name = new Random();
    public static boolean getChange(int change){
        int a = name.nextInt(99);
        return a <= change;
    }
}
