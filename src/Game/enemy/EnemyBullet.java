package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.Player;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    public EnemyBullet(){
        super();
        this.createRenderer();
        this.velocity.set(0,10);
        this.boxCollider = new BoxCollider(this.position,this.anchor,20,20);
    }

    private void createRenderer() {
    ArrayList<BufferedImage> images = new ArrayList<>();
    images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
    this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.checkIntersect();
    }
    private void checkIntersect(){
        Player player = GameObject.findIntersected(Player.class,this.boxCollider);
        if (player!=null){
            this.destroy();
            player.destroy();
        }
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
