import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        setTitle("Frogger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);

    }

}