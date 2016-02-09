//complete the methods below
//the default constructor is done for you  
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Piece extends Drawable implements Nameable
{
  
    private String name;
    private Color color;
    
    public Piece()
    {
        super(5,5,5,5);//calls the constructor from the abstract class that we're extending
        setName("empty");//default name
        setColor(Color.BLUE);//default color          
    }

    public Piece(String n)
    {
        super(5,5,5,5);//default position and size
		setName(n);//default name
		setColor(Color.BLUE);//default color		
    }

    public Piece(int x, int y, String n)
    {
        super(x,y,5,5);//default position and size
		setName(n);//default name
		setColor(Color.BLUE);//default color		
    }

    public Piece(int x, int y, int w, int h, String n)
    {
        super(x,y,w,h);//default position and size
		setName(n);//default name
		setColor(Color.BLUE);//default color		
    }

    public Piece(int x, int y, int w, int h, String n, Color c)
    {
        super(x,y,w,h);//default position and size
		setName(n);//default name
		setColor(c);//default color	
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setColor(Color c)
    {
        this.color = c;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Color getColor()
    {
        return color;
    }
    
   //this method is done
   //it is being implemented from the Drawable abstract class
    public void draw(Graphics window)
    {
        window.setFont(new Font("TAHOMA",Font.BOLD,28));
        window.setColor(getColor());
        window.drawRect(getX(),getY(),getWidth(),getHeight());
        window.drawString(getName(),getX()+10,getY()+30);

    }
    
    public String toString()
    {
        return super.toString() + " " + this.name + " " + this.color;
    }
}