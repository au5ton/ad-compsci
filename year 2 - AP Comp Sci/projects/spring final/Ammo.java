import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;

public class Ammo extends MovingThing
{
	private int speed;
   private Image image;

	public Ammo()
	{
		this(10,10,-1,-1,0);
	}

	public Ammo(int x, int y)
	{
		//add code
      this(x,y,-1,-1,10);
	}

	public Ammo(int x, int y, int s)
	{
		//add code
      this(x,y,-1,-1,s);
	}
   
   public Ammo(int x, int y, int w, int h, int s)
	{
      //add code here
      super(x,y,16,16);
      this.speed = s;
      try
		{
			URL url = getClass().getResource("ammo.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
   }

	public void setSpeed(int s)
	{
	   //add code
      this.speed = s;
	}

	public int getSpeed()
	{
	   //add gode
      return this.speed;
   }

	public void draw( Graphics window )
	{
		//add code to draw the ammo
      //ammo should only move up
      move("DOWN"); //doesn't take parameter into account
      window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	
	public void move( String direction )
	{
		//add code to move the ammo
      //ammo will be a yellow square
      setY(getY()-getSpeed());
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
