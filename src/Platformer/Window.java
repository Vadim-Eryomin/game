package Platformer;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {
    public JFrame ok;
    public BufferedImage bufferedImage;
    public Canvas canvas;
    public BufferStrategy bufferStrategy;
    public Graphics graphics;

    public Window(GameContainer gc) {
        bufferedImage = new BufferedImage(gc.width, gc.height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension dimension = new Dimension((int) (gc.width * gc.scale), (int) (gc.height * gc.scale));
        canvas.setPreferredSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setMaximumSize(dimension);
        ok = new JFrame(gc.title);
        ok.setSize(dimension);
        ok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ok.setResizable(false);
        ok.setLayout(new BorderLayout());
        ok.setVisible(true);
        ok.add(canvas, BorderLayout.CENTER);
        ok.setLocationRelativeTo(null);
        ok.pack();

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();

    }

    public void update() {
        graphics.drawImage(bufferedImage, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bufferStrategy.show();
    }
}