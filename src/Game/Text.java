package Game;

import Game.renderer.TextRenderer;

public class Text extends GameObject {
    public Text() {
        super();
        String string = "Score: ";
        this.renderer = new TextRenderer(string);
        this.position.set(0,15);
    }
}
