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

		window.setColor(Color.GRAY);
		window.fillRect(getX(),getY(),getWidth(),getHeight());
		window.setColor(Color.BLACK);
		window.drawRect(getX(),getY(),getWidth(),getHeight());

		if(this.visited) {
			window.setColor(Color.LIGHT_GRAY);
			window.fillRect(getX(),getY(),getWidth(),getHeight());
         
         window.setColor(Color.DARK_GRAY);
		   window.drawRect(getX(),getY(),getWidth(),getHeight());

			//window.setFont(Font.MONOSPACED);
			switch(this.count) {
				case 1: {
					window.setColor(new Color(0,0,255));
					break;
				}
				case 2: {
					window.setColor(new Color(0,128,0));
					break;
				}
				case 3: {
					window.setColor(new Color(255,0,0));
					break;
				}
				case 4: {
					window.setColor(new Color(0,0,128));
					break;
				}
				case 5: {
					window.setColor(new Color(128,0,0));
					break;
				}
				case 6: {
					window.setColor(new Color(0,128,128));
					break;
				}
				case 7: {
					window.setColor(new Color(0,0,0));
					break;
				}
				case 8: {
					window.setColor(new Color(128,128,128));
					break;
				}
				default: {
					//
				}
			}
			if(this.count > 0)
            window.drawString(Integer.toString(this.count), getX()+6, getY()+14);
		}
	}

	public String toString()
	{
		return super.toString();
	}
}
