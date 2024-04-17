//Game Example
//Lockwood Version 2023-24
// Learning goals:
// make an object class to go with this main class
// the object class should have a printInfo()
//input picture for background
//input picture for object and paint the object on the screen at a given point
//create move method for the object, and use it
// create a wrapping move method and a bouncing move method
//create a second object class
//give objects rectangles
//start interactions/collisions

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import javafx.scene.input.KeyCode;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Sections

public class GameLand implements Runnable, KeyListener {

    //Variable Declaration Section
    //Declare the variables used in the program


    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    //Declare the objects used in the program below
    /**
     * STEP 1 Declare your object and give it a name
     **/


    public Hero OrangeReceiver;

    public Hero GreyDefender;

    public Hero[] Football;

    //declare screen/level booleans
    public boolean startScreen = true;
    public boolean isPlaying;
    public boolean gameOver;


    /**
     * STEP 2 Declare an image for your object
     **/

    public Image backgroundpic;

    public Image Orangereceiver;
    public Image Greydefender;
    private int KeyCode;
    public Image FootballPic;


    // Main method definition: PSVM
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        GameLand ex = new GameLand();   //creates a new instance of the game and tells GameLand() method to run
        new Thread(ex).start();       //creates a thread & starts up the code in the run( ) method
    }

    // Constructor Method
    // This has no return type and has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public GameLand() {
        setUpGraphics(); //this calls the setUpGraphics() method

        //create (construct) the objects needed for the game below
        //for each object that has a picture, load in images as well
        /**Construct a specific Hero**/
        GreyDefender=new Hero(60,90, 9, 9);
        OrangeReceiver= new Hero(60,90, 9, 9);


        /**STEP 4 load in the image for your object **/
        Greydefender = Toolkit.getDefaultToolkit().getImage("GreyDefender.png");
        backgroundpic = Toolkit.getDefaultToolkit().getImage("Field.jpg");
        Orangereceiver = Toolkit.getDefaultToolkit().getImage("OrangeReceiver.png");
        FootballPic = Toolkit.getDefaultToolkit().getImage("Football.png");


    }// GameLand()

//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever using a while loop
        while (true) {
            moveThings();  //move all the game objects
            collisions(); //checks for rec intersections
            render();  // paint the graphics
            pause(20); // sleep for 20 ms
        }
    }

    //paints things on the screen using bufferStrategy
    public void collisions() {


    }


    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of your objects below:

        /**Step 5 draw the image of your object to the screen**/
        if(startScreen==true) {
            g.drawString("press space bar to start", 400, 300);
        }

        if(gameOver==true){
            //paint game over image to the screen
            g.drawString("game over", 400, 300);

        }
        if (isPlaying==true) {

            g.drawImage(backgroundpic, 0, 0, 1000, 700, null);
            g.drawImage(Greydefender, GreyDefender.xpos, GreyDefender.ypos, GreyDefender.width, GreyDefender.height, null);
            g.drawImage(Orangereceiver, 200, 500, 90, 50, null);
        }
//        for (int i = 0; i < Football.length; i++) {
//
//        }


        //dispose the images each time(this allows for the illusion of movement).
        g.dispose();

        bufferStrategy.show();

    }


    public void moveThings() {
        //call the move() method code from your object class

        GreyDefender.Keymove();
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Game Land");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addKeyListener(this);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //probably will stay empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();
        System.out.println("key;" + key + ", KeyCode:" + keyCode);
        if (KeyCode == 68) { // d is 68 // right movement
            GreyDefender.rightPressed = true;
        }
        if (KeyCode == 65) {
            GreyDefender.leftPressed = true;
        }
        if (KeyCode == 68) {
            GreyDefender.leftPressed = true;

        }
        if (KeyCode == 87) {
            GreyDefender.upPressed = true;
        }
        if (KeyCode == 83) {
            GreyDefender.downPressed = true;

        }
        if (KeyCode == 39) {//R arrow = 39
            OrangeReceiver.rightPressed = true;

        }
        if (KeyCode == 37) {//L arrow = 65
            OrangeReceiver.leftPressed = true;
        }
        if (KeyCode == 38) {//R arrow = 39
            OrangeReceiver.upPressed = true;
        }
        if (KeyCode == 40) {//R arrow = 40
            OrangeReceiver.downPressed = true;


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
            char key =e.getKeyChar();
            int KeyCode = e.getKeyCode();
            if (KeyCode==32) {//32 is spacebar
                startScreen = false;
                isPlaying = true;
            }
            if (KeyCode == 68) { // d is 68 // right movement
                GreyDefender.rightPressed = false;

            }
            if (KeyCode == 65) { //a=65
                GreyDefender.leftPressed = false;
            }
            if (KeyCode == 87) { //w=68
                GreyDefender.upPressed = false;
            }
            if (KeyCode == 83) {//s=65
                GreyDefender.downPressed = false;

                if (KeyCode == 39) {//R arrow = 39
                    OrangeReceiver.rightPressed = false;

                }
                if (KeyCode == 37) {// left arrow = 37
                    OrangeReceiver.leftPressed = false;
                }
                if (KeyCode == 38) { //up arrow = 38
                    OrangeReceiver.upPressed = false;

                }
                if (KeyCode == 40) {//R arrow = 39
                    OrangeReceiver.downPressed = false;


                }
            }
        }

    }