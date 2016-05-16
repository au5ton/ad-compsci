import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,-1,-1,0);
	}

	public Alien(int x, int y)
	{
		//add code here
      this(x,y,-1,-1,0); //width heigh have no effect
	}

	public Alien(int x, int y, int s)
	{
		//add code here
      this(x,y,-1,-1,s); //width heigh have no effect
	}

	public Alien(int x, int y, int w, int h, int s)
	{
      super(x,y,42,42);
      this.speed = s;
		//add code here
      try
		{
         int n = (int)(Math.random()*3);
			URL url = getClass().getResource("cat"+n+".png");
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
	   //add code
      return this.speed;
	}

   public void move(String direction)
	{

	   //add code here
      //check bounds of the alien
      if(getX() >= StarFighter.WIDTH-getWidth() || getX() <= 0) {
         setSpeed(getSpeed()*-1);
         setY(getY()+25);
      }
      setX(getX()+getSpeed());
      //if alien is out of bounds change speed direction
      //and move the alien downa  row (25 pixels)
      //constantly change the x position of the alien by the speed
    }

	public void draw( Graphics window )
	{
   	move("DOWN"); //doesn't take parameter into account
      window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
      
	}

	public String toString()
	{
		return super.toString() + getSpeed();
   }
}
