package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

import Game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {

    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, 600 - image.getHeight());
        //this.position = new Game.Vector2D(0, Game.Setting.SCREEN_HEIGHT - this.image.getHeight());
    }

    @Override
    public void run() {
        if (this.position.y < 0) {
            //this.y+=10;
            this.position.addThis(0, 1);
        } //this.y=0;
        else this.position.set(this.position.x, 0);
    }

}
