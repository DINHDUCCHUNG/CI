package game.scene;

import game.GameObject;

public class SceneGameOver extends Scene {
    @Override
    public void init() {
        BackGroundGameOver backGround = GameObject.recycle(BackGroundGameOver.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
