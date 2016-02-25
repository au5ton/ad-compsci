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
      super(5,5,5,5);
      setFilled(fill);
      setColor(Color.BLUE);
	}

	public ColoredCell(int x, int y, boolean fill)
	{
      super(x,y,5,5);
      setFilled(fill);
      setColor(Color.BLUE);
	}

	public ColoredCell(int x, int y, int w, int h, boolean fill)
	{
      super(x,y,w,h);
      setFilled(fill);
      setColor(Color.BLUE);
	}

	public ColoredCell(int x, int y, int w, int h, boolean fill, Color c)
	{
      super(x,y,w,h);
      setFilled(fill);
      setColor(c);
	}

	public void setFilled(boolean fill)
	{
      this.filled = fill;
	}

	public void setColor(Color c)
	{
      this.color = c;
	}
	
	public boolean getFilled()
	{
		return this.filled;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public void draw(Graphics window)
	{
		window.setColor(getColor());
		window.drawRect(getX()*25,getY()*25,getWidth()*2,getHeight()*2);
      if(getFilled()==true)
      {
       //fill in the spot with a green square
       window.setColor(Color.GREEN);
       window.fillRect(getX()*25,getY()*25,getWidth()*2,getHeight()*2);
      }
	}
	
	public String toString()
	{
		return super.toString() + " " + getFilled() + " " + getColor();
	}
}