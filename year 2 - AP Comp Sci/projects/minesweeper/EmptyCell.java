//Fill in appropriate methods
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class EmptyCell extends Cell 
{
	private boolean mine;
   private boolean visited = false;
   private int count;
  		
	public EmptyCell(int x, int y, int w, int h, boolean mine)
	{
      super(x,y,w,h,mine);
      setCount(0);
	}

	public void setVisited(boolean visit)
	{
      this.visited = visit;
	}
   
   public boolean getVisited()
	{
      return this.visited;
	}

	public boolean getMined()
	{
      return this.mine;
	}
   
   public void setCount(int count)
	{
		this.count = count;
	}
   
   public int getCount()
	{
		return this.count;
	}


	
		
	public void draw(Graphics window)
	{
   
      //make gray square with black outline
      //if the cell is marked as visited
        //replace the gray square with a lighter shade of gray and
        //print out the count number on top (make sure you use different colors for each number -- max 8; zeros don't get a number)
      
       
	}

      
     


	
	
	public String toString()
	{
		return super.toString();
	}
}