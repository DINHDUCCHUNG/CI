package game.scene;

import game.Background;
import game.GameObject;
import game.enemy.EnemySummoner;
import game.player.Player;

public class SceneStage1 extends Scene {

    @Override
    public void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(EnemySummoner.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
