import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
   private int speed;
   private Image image;
   private int lives = 3;
   private boolean canBeTouched;

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
   
   public int getLives()
   {
      return this.lives;
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
   
   public void aliensAttackShips(ArrayList<Alien> aliens)
	{
      //Part 3
      //for every shot in the list
      //check if you've hit any alien in the list
      //(do the coordinates of the shot fall between the boundarises of the alien)
      //if they do then remove the alien and the shot
      //make sure you break out of the loop if this happens
	   
      for(int i = 0; i < aliens.size(); i++) {
         if(getX() >= aliens.get(i).getX() && getX() <= aliens.get(i).getX()+aliens.get(i).getWidth()) {
            if(getY() >= aliens.get(i).getY() && getY() <= aliens.get(i).getY()+aliens.get(i).getHeight() && canBeTouched == true) {
               this.lives--;
               canBeTouched = false;
            }
            else {
               canBeTouched = true;
            }
         }
         else {
            canBeTouched = true;
         }
      }
      
   }


   public String toString()
   {
      return super.toString() + " " + getSpeed();
   }
}
