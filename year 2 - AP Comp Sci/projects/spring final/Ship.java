import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
   private int speed;
   private Image image;

   public Ship()
   {
      this(0,0,-1,-1,0);
   }

   public Ship(int x, int y)
   {
      //add code here
      this(x,y,-1,-1,0);
   }

   public Ship(int x, int y, int s)
   {
      //add code here
      this(x,y,-1,-1,s);
   }

   public Ship(int x, int y, int w, int h, int s)
   {
      super(x, y, 60, 60);
      this.speed=s;
      try
      {
         URL url = getClass().getResource("pug.png");
         image = ImageIO.read(url);
      }
      catch(Exception e)
      {
      	//feel free to do something here
         throw new IllegalArgumentException("Cannot find ship.jpg");
      }
   }

   public void setSpeed(int s)
   {
      //add more code
      this.speed = s;
   }

   public int getSpeed()
   {
      //continue coding
      return this.speed;
   }

   public void move(String direction)
   {
   	//add code here
      
      if(direction.equals("LEFT")) {
         setX(getX()-this.speed);
      }
      else if(direction.equals("RIGHT")) {
         setX(getX()+this.speed);
      }
      else if(direction.equals("UP")) {
         setY(getY()-this.speed);
      }
      else if(direction.equals("DOWN")) {
         setY(getY()+this.speed);
      }
      
   }

   public void draw( Graphics window )
   {
      window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
   }

   public String toString()
   {
      return super.toString() + " " + getSpeed();
   }
}
