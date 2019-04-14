package com.company;



import java.awt.image.DataBufferInt;

public class Renderer {
    public int pW, pH;
    public int[] p;

    public Renderer(GameContainer gc) {
        pW = gc.width;

        pH = gc.height;
        p = ((DataBufferInt) gc.window.bufferedImage.getRaster().getDataBuffer()).getData();
    }

    public void clear(GameContainer gc) {
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
    }
    public void setPixel(int x, int y, int value){
        if (x < 0 || y < 0 || x > pW || y > pH || value == 0xffff00ff){
            return;
        }
        p[x + y * pW] = value;

    }

    public void drawImage(Image image, int offX, int offY){
        int newX = 0;
        int newY = 0;
        int newWidth = image.w;
        int newHeight = image.h;

        if (offX < -newWidth)return;
        if (offY < -newHeight)return;
        if (offX >= pW) return;
        if (offY >= pH) return;

        if (offX < 0) newX -= offX;
        if (offY < 0) newY -= offY;
        if (newWidth + offX > pW) {newWidth -= newWidth+offX-pW;}
        if (newHeight + offY > pH) {newHeight -= newHeight+offY-pH;}

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
             setPixel(x + offX,y+offY ,image.p[x+y*image.w]);


            }
        }
    }
    public font font = com.company.font.STANDART;
    public void drawText(String text, int offx, int offy, int color){
        Image fontImage = font.fontImage;
        text = text.toUpperCase();
        int offSet = 0;
        for (int i = 0; i < text.length(); i++) {
            int unicode = text.codePointAt(i) - 32;
            for (int y = 0; y < fontImage.h; y++) {
                for (int x = 0; x < font.widths[unicode]; x++) {
                    if (font.fontImage.p[(x+font.offsets[unicode])+y * font.fontImage.w] == 0xffffffff){
                        setPixel(x+offx+offSet,y+offy,color);
                    }
                }
            }
            offSet += font.widths[unicode];
        }
    }
}
