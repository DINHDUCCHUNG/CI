package game.scene;

import game.GameObject;

public class SceneWelcome extends Scene {

    @Override
    public void init() {
        BackGroundWelcome backGround = GameObject.recycle(BackGroundWelcome.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
