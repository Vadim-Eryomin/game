package II;

import java.awt.event.KeyEvent;

public class IIContainer{
    public Window window = new Window();
    public Input input = new Input();
    public IIContainer() {
        while (true){
            input.update();
        }


    }

    public static void main(String[] args) {
        new IIContainer();
    }
}
