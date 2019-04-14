package II;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JFrame {
    public TextArea textArea;
    public JTextField text;
    public Window(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        Dimension d = new Dimension();
        int w = 720;
        int h = 450;
        d.setSize(w,h);
        setMinimumSize(d);
        setMaximumSize(d);
        textArea = new TextArea();
        add(textArea,BorderLayout.CENTER);
        text = new JTextField();
        add(text,BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                text.setText(" ");
            }
        });
        pack();
    }

}
