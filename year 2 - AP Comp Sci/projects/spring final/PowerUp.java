import java.awt.Color;
import java.awt.Graphics;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO;

public class PowerUp extends MovingThing
{
   private int type;
   
   private int speed;
   private Image image;
   private int lives = 3;
   private boolean canBeTouched;
   
   public final int SPEED_BOOST = 1;
   public final int FIRE_HOSE = 2;
   public final int SLOW_ALIENS = 3;

   public PowerUp()
   {
      this(0,0,0);
   }

   public PowerUp(int x, int y)
   {
      //add code here
      this(x,y,0);
   }

   public PowerUp(int x, int y, int type)
   {
      super(x,y,10,10);
      this.type = type;
   }

   public void draw( Graphics window )
   {  
      if(type == SPEED_BOOST) {
         setColor(Color.BLUE);
         window.fillOval(getX(),getY(),getWidth(),getHeight());
      }
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
   
   public String toString()
   {
      return super.toString() + " " + getSpeed();
   }
}
