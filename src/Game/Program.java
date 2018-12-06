package Game;

import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GameCanvas gameCanvas = new GameCanvas();
        gameCanvas.setPreferredSize(new Dimension(Setting.SCREEN_WIDTH,Setting.SCREEN_HEIGHT));
        gameWindow.add(gameCanvas);
        gameWindow.pack();
        gameWindow.setVisible(true);
        gameCanvas.gameLoop();
    }
}
