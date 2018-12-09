package Game;

import Game.player.Player;
import Game.player.PlayerBullet;
import Game.renderer.TextRenderer;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameCanvas extends JPanel {
    public GameCanvas() {
//        this.background = new Background();
//        this.player = new Player();
//        this.playerBullets = new ArrayList<>();
        GameObject.addGameObject(new Background());
        GameObject.addGameObject(new Player());
        GameObject.addGameObject(new Enemy());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT);
        GameObject.renderAll(g);
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        this.repaint();// ~paint()
    }

    public void gameLoop() {
        long lastTimeRun = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeRun > Setting.TIMEPERPRAME) {
                System.out.println(currentTime - lastTimeRun);
                runAll();//logic game
                renderAll();//hien thi game
                lastTimeRun = currentTime;
            }
        }
    }
}
