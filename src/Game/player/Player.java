package Game.player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.*;
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
//        this.renderer = new Animation(images);
        this.renderer = new PlayerRenderer("Pilot",images);
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
            GameObject.addGameObject(bullet);
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
        int halfWidth = (int)(Setting.PLAYER_WIDTH*this.anchor.x);
        int halfHeight = (int)(Setting.PLAYER_HEIGHT*this.anchor.y);
        float x = (float) Mathx.clamp(this.position.x, halfWidth, Setting.BACKGROUND_WIDTH-halfWidth );
        // limit y(0, background.image.height
        float y = (float) Mathx.clamp(this.position.y, halfHeight, Setting.SCREEN_HEIGHT-halfHeight );
        this.position.set(x, y);
    }

}
