package Game;

import Game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, 0);
        this.anchor.set(0, 0);
    }
    int a = 0;
    @Override
    public void run() {
        if (a==0){
            this.position.addThis(5,1);
        }
        if (this.position.x == 360){
            a=1;
        }
        if (a==1){
            this.position.addThis(-5,1);
        }
        if (this.position.x == 0){
            a = 0;
        }
    }
}
