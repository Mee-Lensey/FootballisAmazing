import java.awt.*;
import java.util.Random;

public class Hero {
    //variable declaration section
    public String name;                             // holds the name of the hero
    public int xpos;                                // the x position
    public int ypos;                                // the y position
    public int dx;                                  // the speed of the hero in the x direction
    public int dy;                                  // the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;
    //movmement booleans
    public boolean rightPressed;
    public boolean leftPressed;
    public boolean upPressed;
    public boolean downPressed;

    // a boolean to denote if the hero is alive or dead
    //DO NOW; ADD SPEED as parameters in this constructor
    public Hero(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy=pDy;
        width = 60;
        height = 80;
        isAlive = true;

        rec= new Rectangle(xpos,ypos,width,height);



    }
    public Hero(){
        xpos =100;
        ypos=200;
        dx=2;
        dy=3;
        width=60;
        xpos=xpos+dx;
        ypos=ypos+dy;



    }
    public void Keymove(){//this is the user control move method
    //horizontal
      if(rightPressed==true){
          dx=2;

      } else if (leftPressed==true){
          dx=-2;
      } else{
          dx=0;
      }
    //vertical
        if(downPressed==true){
            dy=2;
        }else if (upPressed==true){
            dy=-2;
        } else {
            dy=0;
        }

        xpos = xpos+dx;
        ypos=ypos+dy;
        rec= new Rectangle(xpos,ypos,width,height);

    }
    public void growingMove(int amount){
        width += amount;
        height += amount;
        boolean gruGrows = false;
        if (!gruGrows){
            width += amount;
            height += amount;
            gruGrows = true;
        }
        else{
            gruGrows = false;
        }


        xpos = xpos+dx;
        ypos=ypos+dy;
        rec= new Rectangle(xpos,ypos,width,height);



    }
    //change
    public void bouncingMove(){
        if(xpos>1000-width ||xpos<0) {
            dx*=-1;
        }
        if(ypos>1000-width){
            dy*=-1;

        }

        if(ypos<0){
            dy*=-1;
        }

        xpos = xpos+dx;
        ypos=ypos+dy;
        rec= new Rectangle(xpos,ypos,width,height);



    }
    public void teleport(){
        Random rand = new Random();
        xpos = rand.nextInt(1000);
        ypos = rand.nextInt(700);
    }
    public void wrappingMove(){
        // 4 seperate if statements, one for each wall
        if(xpos>1000){
            xpos=0;
        }
        if(xpos<0) {
            xpos = 1000;
        }
        if(ypos>700){
            ypos=1000;

        }
        if(ypos>700){
            ypos=0;
        }
        if (ypos<1000){
            ypos=0;
        }
        xpos = xpos+dx;
        ypos=ypos+dy;
        rec= new Rectangle(xpos,ypos,width,height);

    }
    //the two lines of code below actually update the position
    //





    public void printInfo() {
        System.out.println("(x,y): (" + xpos + ", " + ypos + ")");
        System.out.println("x speed: " + dx);
        System.out.println("y speed " + dy);
        System.out.println("width: " + width);
        System.out.println("height:" + height);
        System.out.println("isAlive:" + isAlive);
    }
    //MAKE A PRINTINFO() Method


    //make a move() method


}
