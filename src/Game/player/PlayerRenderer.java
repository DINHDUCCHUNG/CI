package Game.player;

import Game.GameObject;
import Game.renderer.Animation;
import Game.renderer.Renderer;
import Game.renderer.TextRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.PublicKey;
import java.util.ArrayList;

public class PlayerRenderer extends Renderer {
    Renderer textRenderer;
    Renderer animation;
    public PlayerRenderer(String text, ArrayList<BufferedImage> images){
        this.textRenderer = new TextRenderer(text);
        this.animation = new Animation(images);
    }
    @Override
    public void render(Graphics g, GameObject master) {
//        this.textRenderer.render(g,master);
        this.animation.render(g,master);
    }
}
