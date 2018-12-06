package Game.renderer;

import Game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextRenderer extends Renderer {
    String string;
    public TextRenderer(String string){
        this.string = string;
    }
    @Override
    public void render(Graphics g, GameObject master){
        g.drawString(this.string,(int)master.position.x,(int)master.position.y);
    }

}
