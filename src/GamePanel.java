import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class GamePanel extends JPanel {
    Frosch f;
    Map m;
    Baum[] b;

    int mouseX, mouseY;
    int screenW, screenH;

    boolean onBaum;
    int counter;

    public GamePanel() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenH = Toolkit.getDefaultToolkit().getScreenSize().height;

        f = new Frosch(500, 500, 50, 50, 30);
        m = new Map();
        b = new Baum[3];
        b[0] = new Baum(100,4*screenH/10,100);
        b[1] = new Baum(500,2,200);
        b[2] = new Baum(800,3,300);

        addKeyListener(f);
        setFocusable(true);
        requestFocus();

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        onBaum = false;




        Timer timer = new Timer(16, e -> repaint());
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        m.draw(g);

        for(int i = 0; i < b.length; i++){
            b[i].draw(g,this);
        }

        f.draw(g,this);




        if ((f.getY() + f.getH() / 2 > 4 * screenH / 10 && f.getY() + f.getH() / 2 < 7 * screenH / 10)){

            if (onBaum) {
                f.rips.add(new Rip(f.getX(), f.getY()));
                f.setX(500);
                f.setY(500);
            }


        }






    }

}
