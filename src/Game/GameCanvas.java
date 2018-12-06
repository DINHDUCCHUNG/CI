package Game;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    Text text;
    static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        this.text= new Text();
        this.playerBullets = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT);
        this.background.render(g);
        this.text.render(g);
        this.player.render(g);
        for (int i = 0; i < this.playerBullets.size(); i++) {
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.render(g);
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        this.text.run();
        for (int i = 0; i < this.playerBullets.size(); i++) {
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.run();
        }
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
