package StemFight;

public class portalRenderer {
    public void update(Game game){
        if (game.talkWalk){
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        game.gc.renderer.drawText("Go to the portal!", 650,0,0xffffffff);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
            game.talkWalk = false;
        }
        if (game.talkPick){
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        game.gc.renderer.drawText("Pick more bricks!", 650,0,0xffffffff);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
            game.talkPick = false;
        }
        if (game.win){
            game.gc.renderer.drawText("WIN!", 650,0,0xffffffff);
        }
    }

}
