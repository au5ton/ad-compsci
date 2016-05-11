import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
      //initalize ammo
	}

	public void add(Ammo al)
	{
      //add al to list
	}

	public void drawEmAll( Graphics window )
	{
      //draw each ammo in the list
	}

	public void moveEmAll()
	{
      //move each ammon in the list
	}

	public void cleanEmUp()
	{
      //for every ammo in the list
      //if the ammo is out of bounds
      //remove it
	}

	public List<Ammo> getList()
	{
		//add code
      return null;
   }

	public String toString()
	{
		return "" + ammo;
	}
}
