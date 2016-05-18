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
   
   public String toString()
   {
      return super.toString() + " " + getSpeed();
   }
}
