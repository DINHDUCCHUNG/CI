package Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.renderer.Animation;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player extends GameObject {

    public Player() {
        super();
        this.position.set(200, 300);
        this.createRenderer();
        //this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");
        //this.position = new Game.Vector2D(200, 300);

    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new Animation(images);

    }

    //logic

    int count = 0;//TODO : se fix

    @Override
    public void run() {
        this.move();
        count++;
        if (count > 10) {
            this.fire();
        }
        this.limitPlayerPosition();
    }


    private void fire() {

        if (GameWindow.isFirePress) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            GameCanvas.playerBullets.add(bullet);
            count = 0;
        }
    }

    private void move() {
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
    }

    public void limitPlayerPosition() {
        //limit x(o0, background.image.width
        float x = (float) Mathx.clamp(this.position.x, 0, Setting.BACKGROUND_WIDTH - Setting.PLAYER_WIDTH);
        // limit y(0, background.image.height
        float y = (float) Mathx.clamp(this.position.y, 0, Setting.SCREEN_HEIGHT - Setting.PLAYER_HEIGHT);
        this.position.set(x, y);
    }

}
