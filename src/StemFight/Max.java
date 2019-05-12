package StemFight;

public class Max {
    public static int range(int Integers,int minValue, int maxValue){
        if (Integers <= minValue) Integers = minValue;
        if (Integers >= maxValue) Integers = maxValue;
        return Integers;
    }
}
