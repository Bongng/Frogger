import java.awt.*;

public class Map {
    int w;
    int h;

    public Map(){
        w = Toolkit.getDefaultToolkit().getScreenSize().width;
        h = Toolkit.getDefaultToolkit().getScreenSize().height;

    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0,0,w,h/10);

        g.setColor(Color.gray);
        g.fillRect(0,h/10,w,2*h/10);

        g.setColor(Color.green);
        g.fillRect(0,3*h/10,w,3*h/10);

        g.setColor(Color.blue);
        g.fillRect(0,4*h/10,w,3*h/10);

        g.setColor(Color.green);
        g.fillRect(0,7*h/10,w,3*h/10);



    }


}
