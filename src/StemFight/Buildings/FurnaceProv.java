package StemFight.Buildings;

public class FurnaceProv {
    public void update(FurnaceFrame ff){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    if (ff.numbersThings.get(0) >= 1 && ff.numbers.get(0).equals("brick")){
                        if (ff.numbersThings.get(1) >= 1 && ff.numbers.get(1).equals("board")){
                            ff.numbersThings.put(0, ff.numbersThings.get(0)-1);
                            ff.numbersThings.put(1, ff.numbersThings.get(1)-1);

                        }
                    }
                }
            }
        }.start();
    }
}
