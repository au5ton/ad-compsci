import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	

	/* uncomment and comment as necessary */
   private AlienHorde horde;
	private Bullets shots;
   private Ship ship;
   private Alien alienOne;
   private Alien alienTwo;
   private boolean gameOver = false;
   private int wave = 0;
   
   private int shipSpeed;
   private int hordeCount;
   private int alienSpeed;
	

	private boolean[] keys;
	private BufferedImage back;
   private Image background;

	public OuterSpace()
	{
		this(5,20,1);
	}
   
   public OuterSpace(int shipSpeed, int hordeCount, int alienSpeed)
	{
   
      this.shipSpeed = shipSpeed;
      this.hordeCount = hordeCount;
      this.alienSpeed = alienSpeed;   
      
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate what you need as you need it (from global objects above)
      ship = new Ship(310,450,shipSpeed);
      
      //alienOne = new Alien(100,50);
      //alienTwo = new Alien(150,50);
      horde = new AlienHorde(hordeCount, alienSpeed);
      shots = new Bullets();
      
      try
      {
         URL url = getClass().getResource("space.png");
         background = ImageIO.read(url);
      }
      catch(Exception e)
      {
      	//feel free to do something here
         throw new IllegalArgumentException("Cannot find space.png");
      }

      
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }
   
  //the top part of the paint method is done for you
	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shot of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,getWidth(),getHeight());

		
		//add code to move Ship, Alien, etc.-- Part 1
      if(keys[0] == true)
		{
			ship.move("LEFT");
		}
      if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
      if(keys[2] == true)
		{
			ship.move("UP");
		}
      if(keys[3] == true)
		{
			ship.move("DOWN");
		}

      
      //add code to fire a bullet
      
      if(keys[4] == true)
      {
         shots.add(new Ammo(ship.getX(),ship.getY(),1)); //TODO
         keys[4] = false;
      }
      
      
      
		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship -- Part 3




      
		graphToBack.drawImage(background,0,0,null);
      ship.draw(graphToBack);
      //alienOne.draw(graphToBack);
      //alienTwo.draw(graphToBack);
      horde.moveEmAll();
      horde.drawEmAll(graphToBack);
      horde.removeDeadOnes(shots.getList());
      shots.drawEmAll(graphToBack);
      
      ship.aliensAttackShips(horde.getList());
      
      graphToBack.setColor(Color.PINK);
      graphToBack.drawString("Lives left: "+ship.getLives(),20,20);
      System.out.println("Lives left: "+ship.getLives());
      
      twoDGraph.drawImage(back, null, 0, 0);
      back = null;
      
      if(horde.aliensVanquished()) {
      
         if(shipSpeed > 1) {
            shipSpeed--;
         }
         hordeCount += 2;
         alienSpeed++;
      
         ship = new Ship(310,450,shipSpeed);
         horde = new AlienHorde(hordeCount, alienSpeed);
         
         wave++;
         
         if(wave > 6) {
            gameOver = true;
         }
      }
      
      //gameOver = horde.aliensVanquished();
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true; //left
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true; //right
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true; //up
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true; //down
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true; //space
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
      //method needs to be implemented 
      //because class implements KeyListner
	}

   public void run()
   {
   	try
   	{
         int game = 0;
   		while(!gameOver)
   		{
   		   Thread.currentThread().sleep(5); // should be 5
            repaint();
            if(horde.checkForLoss()) {
               game = -1;
               break;
            }
         }
         if(game == -1) {
            JOptionPane.showMessageDialog(null, "get gud kid (you lost)", "fuckin #rekt son 420 blazzze", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
         }
         else {
            JOptionPane.showMessageDialog(null, "You saved PUGSLY! The galaxy is safe ... for now.", "Notice", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
         }
      }catch(Exception e)
      {
         //feel free to add something here, or not
      }
  	}
}

