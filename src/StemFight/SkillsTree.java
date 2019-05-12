package StemFight;

public class SkillsTree {
    int x = 0;
    int y = 0;
    int skillPoints = 1;
    boolean choiceGraph = true;
    boolean choiceProgr = true;
    boolean renderProgr = false;
    boolean renderGraph = true;
    boolean visible = true;

    Image fon = new Image("Skills/fonSkills.png");

    ImageXY[] bulik = new ImageXY[2];
    boolean buliks = false;

    ImageXY[] arrow = new ImageXY[2];
    boolean arrows = false;

    ImageXY[] snake = new ImageXY[2];
    boolean snakes = false;

    ImageXY[] code = new ImageXY[2];
    boolean codes = false;

    ImageXY[] heal = new ImageXY[2];
    boolean heals = false;

    ImageXY[] wall = new ImageXY[2];
    boolean walls = false;

    ImageXY tabGraph = new ImageXY("Using/tabGraph.png",0,0);
    ImageXY tabProg = new ImageXY("Using/tabProg.png",0,0);

    boolean can = false;

    public void create(int x, int y) {
        this.x = x;
        this.y = y;

        bulik[0] = new ImageXY("Skills/nonA_bulik.png", (x+80), y+40);
        bulik[1] = new ImageXY("Skills/bulik.png", (x+80), y+40);

        arrow[0] = new ImageXY("Skills/nonA_brush.png",x+80, y+80);
        arrow[1] =  new ImageXY("Skills/brush.png", x+80, y+80);

        snake[0] = new ImageXY("Skills/nonA_snake.png",x+80, y+120);
        snake[1] =  new ImageXY("Skills/snake.png", x+80, y+120);

        code[0] = new ImageXY("Skills/nonA_code.png", (x+80), y+40);
        code[1] = new ImageXY("Skills/code.png", (x+80), y+40);

        heal[0] = new ImageXY("Skills/nonA_heal.png",x+80, y+80);
        heal[1] =  new ImageXY("Skills/heal.png", x+80, y+80);

        wall[0] = new ImageXY("Skills/nonA_wall.png",x+80, y+120);
        wall[1] =  new ImageXY("Skills/wall.png", x+80, y+120);

        tabGraph.x = this.x + fon.w;
        tabGraph.y = this.y;
        tabProg.x = this.x + fon.w;
        tabProg.y = this.y + 40;

    }

    public void update(Game game) {
        if (isClick(tabGraph, game)){
            renderGraph = true;
            renderProgr = false;
        }
        if (isClick(tabProg, game)){
            renderProgr = true;
            renderGraph = false;
        }
        if (renderGraph){
            if (choiceGraph){
                if (choiceGraph){
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
        }
        if (renderProgr){
            if (choiceProgr){
                if (choiceProgr){
                    if (skillPoints > 0) can = true;
                    else can = false;
                }
                else can = false;

                if (can){
                    if (!codes){
                        if (isClick(code[0], game)) {
                            skillPoints--;
                            codes = true;
                        }
                    }
                    else {
                        if (!heals){
                            if (isClick(heal[0], game)) {
                                skillPoints--;
                                heals = true;
                            }
                        }
                        else{
                            if (isClick(wall[0], game)) {
                                skillPoints--;
                                walls = true;
                            }
                        }
                    }

                }
            }
        }
    }

    public void setVisible(boolean vis) {
        if (!visible && vis) renderGraph = true;
        visible = vis;

    }

    public void renderer(Renderer renderer) {
        renderer.drawImage(fon,x,y);
        renderer.drawImage(tabGraph, tabGraph.x, tabGraph.y);
        renderer.drawImage(tabProg, tabProg.x, tabProg.y);
        if (renderGraph){
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
        if (renderProgr){
            if (can){
                renderer.drawText("Choice the skill!", x+15, y+10, 0xffffffff);
            }

            if (!codes) renderer.drawImage(code[0], x+80, y+40);
            else renderer.drawImage(code[1], x+80, y+40);

            if (!heals) renderer.drawImage(heal[0], heal[0].x, heal[0].y);
            else renderer.drawImage(heal[1], heal[0].x, heal[0].y);

            if (!walls) renderer.drawImage(wall[0], wall[0].x, wall[0].y);
            else renderer.drawImage(wall[1], wall[0].x, wall[0].y);
        }


    }

    public boolean isClick(ImageXY im, Game game){
        if (game.gc.input.isButtonDown(1) && game.gc.input.mouseX > im.x && game.gc.input.mouseX < im.x + im.w && game.gc.input.mouseY > im.y && game.gc.input.mouseY < im.y + im.h)
            return true;
        return false;
    }
}
