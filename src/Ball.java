import java.awt.*;

public class Ball {

    public int x; // x-coordinate of the football
    public int y; // y-coordinate of the football
    public int diameter = 30; // diameter of the football
   ; // speed of the football


    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive;
    public int dx;


    public int dy;
    public int hits;
    public boolean isReleased;
    public Rectangle rec;
    public Image pic;

    public Ball(int pXpos, int pYpos) {


        xpos = pXpos;
        ypos = pYpos;
        width = 70;
        height = 50;
        dx = 0;
        dy = 0;
        isAlive = false;

        hits = 0;
        rec = new Rectangle(xpos, ypos, width, height);
        isReleased = false;

    }

    public Ball(int pXpos, int pYpos, int randomY) {
    }
    //Moving the Football randomly



    public void move() {
        ypos = ypos + dy;
        xpos=xpos+dx;

        rec = new Rectangle(xpos, ypos, width, height);
    }


        //make a printInfo() method
        public void printinfo () {
            //System.out.println("X position: " + xpos);
            //OR
            System.out.println("(x,y): (" + xpos + ", " + ypos + ")");
            System.out.println("x speed: " + dx);
            System.out.println("y speed: " + dy);
            System.out.println("width: " + width);
            System.out.println("height: " + height);
            System.out.println("isAlive: " + isAlive);
        }


    }





