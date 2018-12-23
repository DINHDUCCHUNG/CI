package game.scene;

import game.FrameCounter;
import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class BackGroundGameOver extends GameObject {
    FrameCounter changeScene;
    public BackGroundGameOver(){
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/BackGroundGameOver.jpg"));
        this.position.set(Settings.SCREEN_WIDTH/2,Settings.SCREEN_HEIGHT/2);
        this.changeScene = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.changeScene.run()) {
            if (GameWindow.isAnyKeyPress) {
                SceneManage.signNewScene(new SceneWelcome());
                this.changeScene.reset();
            }
        }
    }
}
