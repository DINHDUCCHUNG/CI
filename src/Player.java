import java.awt.image.BufferedImage;

import tklibs.SpriteUtils;

public class Player {
    BufferedImage image;
    int x, y;

    public Player() {
        this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");
        this.x = 0;
        this.y = 0;
    }

    //logic
    public void run() {
        if (GameWindow.isUpPress) {
            if (this.y > 0) {
                this.y--;
            }
        }
        if (GameWindow.isDownPress) {
            int y = 560 - this.image.getHeight();
            if (this.y < y) {
                this.y++;
            }
        }
        if (GameWindow.isRightPress) {
            int x = Background.image.getWidth() - this.image.getWidth();
            if (this.x < x) {
                this.x++;
            }
        }
        if (GameWindow.isLeftPress) {
            if (this.x > 0) {
                this.x--;
            }
        }
    }
}
