package StemFight;

public class skillsGraphFrame extends FramesForGame {
    int x = 0;
    int y = 0;
    int skillPoints = 1;
    boolean choice = true;

    Image fon = new Image("Skills/fonSkills.png");

    ImageXY[] bulik = new ImageXY[2];
    boolean buliks = false;

    ImageXY[] arrow = new ImageXY[2];
    boolean arrows = false;

    ImageXY[] snake = new ImageXY[2];
    boolean snakes = false;

    boolean can = false;

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;

        bulik[0] = new ImageXY("Skills/nonA_bulik.png", (x+80), y+40);
        bulik[1] = new ImageXY("Skills/bulik.png", (x+80), y+40);

        arrow[0] = new ImageXY("Skills/nonA_brush.png",x+80, y+80);
        arrow[1] =  new ImageXY("Skills/brush.png", x+80, y+80);

        snake[0] = new ImageXY("Skills/nonA_snake.png",x+80, y+120);
        snake[1] =  new ImageXY("Skills/snake.png", x+80, y+120);

    }

    @Override
    public void update(Game game) {
        if (choice){
            if (skillPoints > 0) can = true;
            else can = false;
        }
        else can = false;

        if (can){
            if (!buliks){
                if (isClick(bulik[0], game)) {
                    skillPoints--;
                    buliks = true;
                }
            }
            else {
                if (!arrows){
                    if (isClick(arrow[0], game)) {
                        skillPoints--;
                        arrows = true;
                    }
                }
                else{
                    if (isClick(snake[0], game)) {
                        skillPoints--;
                        snakes = true;
                    }
                }
            }

        }
    }

    @Override
    public void setVisible(boolean vis) {
        visible = vis;
    }

    @Override
    public void renderer(Renderer renderer) {
        renderer.drawImage(fon,x,y);
        if (can){
            renderer.drawText("Choice the skill!", x+15, y+10, 0xffffffff);
        }

        if (!buliks) renderer.drawImage(bulik[0], x+80, y+40);
        else renderer.drawImage(bulik[1], x+80, y+40);

        if (!arrows) renderer.drawImage(arrow[0], arrow[0].x, arrow[0].y);
        else renderer.drawImage(arrow[1], arrow[0].x, arrow[0].y);

        if (!snakes) renderer.drawImage(snake[0], snake[0].x, snake[0].y);
        else renderer.drawImage(snake[1], snake[0].x, snake[0].y);

    }

    public boolean isClick(ImageXY im, Game game){
        if (game.gc.input.isButtonDown(1) && game.gc.input.mouseX > im.x && game.gc.input.mouseX < im.x + im.w && game.gc.input.mouseY > im.y && game.gc.input.mouseY < im.y + im.h)
            return true;
        return false;
    }
}
