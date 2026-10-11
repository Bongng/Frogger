import java.awt.*;
import java.awt.image.ImageObserver;

public class Rip {
    int x;
    int y;
    int w;
    int h;
    Image img;

    public Rip(int x, int y){
        this.x = x;
        this.y = y;
        w = 50;
        h = 50;
        img = Toolkit.getDefaultToolkit().getImage("rip.png");

    }

    public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img,x,y,w,h,obs);
    }

}
