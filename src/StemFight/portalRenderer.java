package StemFight;

public class portalRenderer {
    public void update(Game game){
        if (game.talkWalk){
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        game.gc.renderer.drawText("Go to the portal!", 650,0,0xffffffff);
                        try {
                            Thread.sleep(1);
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
                    for (int i = 0; i < 1000; i++) {
                        game.gc.renderer.drawText("Pick more bricks!", 650,0,0xffffffff);
                        try {
                            Thread.sleep(1);
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
        if (game.pickBoards){
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        game.gc.renderer.drawText("Pick more boards!", 650,0,0xffffffff);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
            game.pickBoards = false;
        }
        if (game.pickBlocks) {
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        game.gc.renderer.drawText("Pick more bricks!", 650,0,0xffffffff);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
            game.pickBlocks = false;
        }

    }
    public void startTimer(){

    }

}
