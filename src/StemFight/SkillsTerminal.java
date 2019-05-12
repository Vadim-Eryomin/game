package StemFight;

public class SkillsTerminal extends FramesForGame {
    int terminal = 0;

    int x = 0;
    int y = 0;

    ImageXY fon = new ImageXY("Skills/sk.png", x, y);

    @Override
    public void create(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void setVisible(boolean vis) {
        visible = vis;
    }


    public void renderer(Game game, Renderer renderer) {
        renderer.drawImage(fon,x,y);
//        if (game.spf.choice) {
//            if (terminal != 1) renderer.drawImage(game.spf.code[0], game.sk.x+19, game.sk.y+35);
//            else renderer.drawImage(game.spf.code[1], game.sk.x+19, game.sk.y+35);
//            if (terminal != 2) renderer.drawImage(game.spf.heal[0], game.sk.x+87, game.sk.y+35);
//            else renderer.drawImage(game.spf.heal[1], game.sk.x+87, game.sk.y+35);
//            if (terminal != 3) renderer.drawImage(game.spf.wall[0], game.sk.x+155, game.sk.y+35);
//            else renderer.drawImage(game.spf.wall[1], game.sk.x+155, game.sk.y+35);
//        }
//        if (game.sgf.choice) {
//            if (!game.sgf.buliks) renderer.drawImage(game.sgf.bulik[0], game.sk.x+19, game.sk.y+35);
//            if (game.sgf.buliks) renderer.drawImage(game.sgf.bulik[1], game.sk.x+19, game.sk.y+35);
//            if (!game.sgf.arrows) renderer.drawImage(game.sgf.arrow[0], game.sk.x+87, game.sk.y+35);
//            if (game.sgf.arrows) renderer.drawImage(game.sgf.arrow[1], game.sk.x+87, game.sk.y+35);
//            if (!game.sgf.snakes) renderer.drawImage(game.sgf.snake[0], game.sk.x+155, game.sk.y+35);
//            if (game.sgf.snakes) renderer.drawImage(game.sgf.snake[1], game.sk.x+155, game.sk.y+35);
//        }
    }

    @Override
    public void renderer(Renderer renderer) {

    }
}
