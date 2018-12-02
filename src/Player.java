import java.awt.image.BufferedImage;

import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player {
    BufferedImage image;
    Vector2D position;

    public Player() {
        this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");
        this.position = new Vector2D(200, 300);
    }

    //logic
    public void run() {
        if (GameWindow.isUpPress) {
            this.position.addThis(0, -3);
        }
        if (GameWindow.isDownPress) {
            this.position.addThis(0, 3);
        }
        if (GameWindow.isRightPress) {
            this.position.addThis(3, 0);

        }
        if (GameWindow.isLeftPress) {
            this.position.addThis(-3, 0);
        }
        this.limitPlayerPosition();
    }

    public void limitPlayerPosition() {
        //limit x(o0, background.image.width
        float x = (float) Mathx.clamp(this.position.x, 0, Setting.BACKGROUND_WIDTH - Setting.PLAYER_WIDTH);
        // limit y(0, background.image.height
        float y = (float) Mathx.clamp(this.position.y, 0, Setting.SCREEN_HEIGHT - Setting.PLAYER_HEIGHT);
        this.position.set(x, y);
    }
}
