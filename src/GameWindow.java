import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress, isLeftPress, isRightPress;

    public GameWindow() {
        this.setTitle("Touhou");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("key press");
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    //System.out.println("Nut W");
                    isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress=true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress=true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress=true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("key release");
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
            }
        });
    }
}
