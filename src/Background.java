import java.awt.image.BufferedImage;

import tklibs.SpriteUtils;

public class Background {
    static BufferedImage image;
    Vector2D position;

    public Background() {
        this.image = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.position = new Vector2D(0, Setting.SCREEN_HEIGHT - this.image.getHeight());
    }

    public void run() {
        if (this.position.y < 0) {
            //this.y+=10;
            this.position.addThis(0, 10);
        } //this.y=0;
        else this.position.set(this.position.x, 0);
    }
}
