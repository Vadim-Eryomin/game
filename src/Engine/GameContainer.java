package Engine;



public class GameContainer implements Runnable {
    public Engine.font font;
    public boolean render = false;
    private Thread thread;
    public Input input;
    public Renderer renderer;
    public Window window;
    private boolean running = false;
    public final double UPDATE_CAP = 1.0 / 60.0;
    public AbsractGame game;


    public int width = 1400, height = 900;
    public float scale = 1;
    public String title = "ENGINE V 1.5";

    double frameTime = 0;
    int frame = 0;
    int fps = 0;

    public GameContainer(AbsractGame game) {
        this.game = game;
    }

    public void start() {
        font = new font("trueFont.png");
        thread = new Thread(this);
        window = new Window(this);
        input = new Input(this);
        renderer = new Renderer(this);
        thread.run();

    }

    public void stop() {

    }

    public void run() {
        running = true;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        while (running) {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;

            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            frameTime += passedTime;

            game.update(this, (float) UPDATE_CAP);
            input.update();

            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                input.update();
                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frame;
                    frame = 0;
                    System.out.println("FPS:" + fps);
                }
            }

            if (render) {
                renderer.clear(this);
                game.renderer(this, renderer);
                window.update();
                frame++;

            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void render() {

    }

    public void dispose() {

    }


}
