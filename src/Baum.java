import java.awt.*;
import java.awt.image.ImageObserver;

public class Baum {
    int x,y,w,h;
    int speed;

    Image img;

    int ScreenW, ScreenH;


    public Baum(int x, int w, int speed) {
        ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.x = x;

        if(number == 1){
            y = 4*ScreenH/10;
        }

        if(number == 2){
            y = 5*ScreenH/10;
        }

        if(number == 3){
            y = 6*ScreenH/10;
        }


        this.w = w;
        h = ScreenH/10;

        img = Toolkit.getDefaultToolkit().getImage("baum.png");

        this.speed = speed;

    }

    public void draw(Graphics g, ImageObserver obs) {
        g.drawImage(img, x, y, w, h, obs);

        move();

        if(x > ScreenW){
            x = -w;
        }
        if(x < -w){
            x = ScreenW;
        }



    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }

    public void move(){
        x += speed;
    }


    public boolean onBaum(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h;
    }

    public int getSpeed(){
        return speed;
    }

}
