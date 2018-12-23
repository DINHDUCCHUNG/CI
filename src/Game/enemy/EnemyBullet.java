package game.enemy;

import game.GameObject;
import game.GameObjectPhysics;
import game.Settings;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.Player;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObjectPhysics {
    int damage;

    public EnemyBullet() {
        super();
        this.createRenderer();
        this.velocity.set(0, 5);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 6, 6);
        this.damage = 1;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y > Settings.SCREEN_HEIGHT) {
            this.destroy();
        }
        this.checkIntersect();
    }

    private void checkIntersect() {
        Player player = GameObject.findIntersected(Player.class, this.boxCollider);
        if (player != null) {
            this.destroy();
            player.takeDamage(this.damage);
        }
    }
}
