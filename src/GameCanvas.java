import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel {
    Background background;
    Player player;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,Setting.SCREEN_WIDTH,Setting.SCREEN_HEIGHT);
        g.drawImage(this.background.image, (int)this.background.position.x, (int)this.background.position.y, null);
        g.drawImage(this.player.image, (int)this.player.position.x, (int)this.player.position.y, null);
    }

    public void runAll() {
        this.player.run();
        this.background.run();
    }

    public void renderAll() {
        this.repaint();// ~paint()
    }

    public void gameLoop() {
        long lastTimeRun = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeRun > Setting.TIMEPERPRAME) {
                System.out.println(currentTime-lastTimeRun);
                runAll();//logic game
                renderAll();//hien thi game
                lastTimeRun = currentTime;
            }
        }
    }
}
