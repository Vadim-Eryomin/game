package StemFight.Buildings;
import static StemFight.Change.*;
public class FurnaceProv {
    public void update(FurnaceFrame ff) {
        try {
            if (ff.numbersThings.get(0) >= 1 && ff.numbers.get(0).equals("brick")) {
                if (ff.numbersThings.get(1) >= 1 && ff.numbers.get(1).equals("board")) {
                    ff.numbersThings.put(0, ff.numbersThings.get(0) - 1);
                    ff.numbersThings.put(1, ff.numbersThings.get(1) - 1);
                    if (getChange(80)) try{ff.numbersThings.put(2, ff.numbersThings.get(2)+1);} catch (NullPointerException f){ff.numbersThings.put(2, 1);}
                }
            }
        }catch (NullPointerException e){}
    }
}
