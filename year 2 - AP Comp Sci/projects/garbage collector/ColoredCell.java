//Fill in the constructor and modifier methods
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class ColoredCell extends Cell
{
	private boolean filled;
	private Color color;
	
	public ColoredCell()//this default constructor method is done for you
	{
		super(5,5,5,5);
		setFilled(false);
		setColor(Color.BLUE);		
	}

	public ColoredCell(boolean fill)
	{


	}

	public ColoredCell(int x, int y, boolean fill)
	{


	}

	public ColoredCell(int x, int y, int w, int h, boolean fill)
	{


	}

	public ColoredCell(int x, int y, int w, int h, boolean fill, Color c)
	{


	}

	public void setFilled(boolean fill)
	{

	}

	public void setColor(Color c)
	{

	}
	
	public boolean getFilled()
	{
		return false;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void draw(Graphics window)
	{
		window.setColor(getColor());
		window.drawRect(getX(),getY(),getWidth(),getHeight());
      if(getFilled()==true)
      {
       //fill in the spot with a green square
      }




	}
	
	public String toString()
	{
		return super.toString() + " " + getFilled() + " " + getColor();
	}
}