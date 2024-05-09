import java.awt.*;

public class OrangeReceiver {

    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive;
    public int dy;
    public int dx;
    public Rectangle rec;
    public boolean right;
    public boolean left;
    public Image pic;

    public OrangeReceiver(int pXpos, Image picParameter, int pYops, int dxParameter, int dyParameter){
    xpos=pXpos;
    ypos= pYops;
    width=20;
    height=35;
    rec= new Rectangle();
    dx=dxParameter;
    dy=dyParameter;
    isAlive=true;
    right=false;
    left=false;




    }
    //method to update  the position of the orange receiver
    public void move(){
        xpos += dx;
        ypos +=dy;
        rec.setLocation(200,100);
    }




}
