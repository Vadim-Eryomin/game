package com.company;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
    public final int NUM_KEYS = 256;
    public boolean[] keys = new boolean[NUM_KEYS];
    public boolean[] keyLast = new boolean[NUM_KEYS];

    public final int NUM_BUTTONS = 5;
    public boolean[] buttons = new boolean[NUM_BUTTONS];
    public boolean[] buttonLast = new boolean[NUM_BUTTONS];

    public int mouseX, mouseY;
    public int scroll;

    public GameContainer gc;

    public Input(GameContainer gc) {
        this.gc = gc;
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        gc.window.canvas.addKeyListener(this);
        gc.window.canvas.addMouseListener(this);
        gc.window.canvas.addMouseMotionListener(this);
        gc.window.canvas.addMouseWheelListener(this);

    }

    public void update() {
        for (int i = 0; i < NUM_KEYS; i++) {
            keyLast[i] = keys[i];
        }
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttonLast[i] = buttons[i];
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


    public boolean isButton(int buttonCode) {
        return buttons[buttonCode];
    }

    public boolean isButtonUp(int buttonCode) {
        return !buttons[buttonCode] && buttonLast[buttonCode];
    }

    public boolean isButoonDown(int buttonCode) {
        return buttons[buttonCode] && !buttonLast[buttonCode];
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int) (e.getX() / gc.scale);
        mouseY = (int) (e.getY() / gc.scale);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int) (e.getX() / gc.scale);
        mouseY = (int) (e.getY() / gc.scale);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }
}

