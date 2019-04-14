package II;

import com.company.GameContainer;

import java.awt.event.*;

public class Input implements KeyListener {
    public final int NUM_KEYS = 256;
    public boolean[] keys = new boolean[NUM_KEYS];
    public boolean[] keyLast = new boolean[NUM_KEYS];


    public Input() {

    }

    public void update() {
        for (int i = 0; i < NUM_KEYS; i++) {
            keyLast[i] = keys[i];
        }
    }


    public boolean isKey(int keyCode) {
        return keys[keyCode];
    }

    public boolean isKeyUp(int keyCode) {
        return !keys[keyCode] && keyLast[keyCode];
    }

    public boolean isKeyDown(int keyCode) {
        return keys[keyCode] && !keyLast[keyCode];
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

}

