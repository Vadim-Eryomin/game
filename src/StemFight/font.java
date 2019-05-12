package StemFight;

public class font {
    public static final font STANDART = new font("trueFont.png");
    public Image fontImage;
    public int[] offsets;
    public int[] widths;

    public font(String path) {

            fontImage = new Image(path);



        offsets = new int[59];
        widths = new int[59];

        int unicode = 0;

        for (int i = 0; i < fontImage.w; i++) {
            if (fontImage.p[i] == 0xff0000ff) {
                offsets[unicode] = i;

            }
            if (fontImage.p[i] == 0xffffff00) {
                widths[unicode] = i - offsets[unicode];
                unicode++;
            }
        }
    }
}
