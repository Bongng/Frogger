import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Frosch implements KeyListener {
    int x,y,w,h;
    Image img;
    int speed;
    boolean left, right, up, down;
    int screenW, screenH;
    ArrayList<Rip> rips;
    int speed2;

    public Frosch(int x, int y, int w, int h, int speed) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        img = Toolkit.getDefaultToolkit().getImage("frog.png");
        this.speed = speed;
        left = false;
        right = false;
        up = true;
        down = false;
        screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
        rips = new ArrayList<>();
        rips.add(new Rip(-1000,-1000));
        speed2 = 0;
    }

    public void draw(Graphics g, ImageObserver obs) {
        Graphics2D g2 = (Graphics2D) g;

        if(up){
            g.drawImage(img,x,y,w,h,obs);
        }
        if(down){
            g2.rotate(Math.toRadians(180), x + w / 2, y + h / 2);
            g2.drawImage(img, x, y, w, h, obs);
            g2.rotate(Math.toRadians(-180), x + w / 2, y + h / 2);
        }
        if(left){
            g2.rotate(Math.toRadians(-90), x + w / 2, y + h / 2);
            g2.drawImage(img, x, y, w, h, obs);
            g2.rotate(Math.toRadians(90), x + w / 2, y + h / 2);
        }
        if(right){
            g2.rotate(Math.toRadians(90), x + w / 2, y + h / 2);
            g2.drawImage(img, x, y, w, h, obs);
            g2.rotate(Math.toRadians(-90), x + w / 2, y + h / 2);
        }


        for (Rip rip : rips) {
            rip.draw(g, obs);
        }

        holdFrogIn();

        if(nextLevel()){
            x = 500;
            y = 500;
        }

        move();

    }

    public void moveLeft() {
        x -= speed;
        left = true;
        right = false;
        up = false;
        down = false;
    }
    public void moveRight() {
        x += speed;
        right = true;
        up = false;
        down = false;
        left = false;
    }
    public void moveUp() {
        y -= speed;
        up = true;
        down = false;
        right = false;
        left = false;
    }
    public void moveDown() {
        y += speed;
        down = true;
        up = false;
        right = false;
        left = false;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            moveDown();
        }


        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    public int getW() {
        return w;
    }
    public int getH() {
        return h;
    }
    public int getX() {
        return x+w/2;
    }
    public int getY() {
        return y+h/2;
    }


    public void holdFrogIn(){
        if(x > Toolkit.getDefaultToolkit().getScreenSize().width-w){
            x = Toolkit.getDefaultToolkit().getScreenSize().width-w;
        }
        if(x < 0){
            x = 0;
        }
        if(y > Toolkit.getDefaultToolkit().getScreenSize().height-3.5*h){
            y = (int) (Toolkit.getDefaultToolkit().getScreenSize().height-3.5*h);
        }

    }

    public boolean nextLevel(){
        if(y < 0){
            return true;
        }
        return false;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void move(){
        x += speed2;
    }

    public void setSpeed(int speed){
        this.speed2 = speed;
    }

}
