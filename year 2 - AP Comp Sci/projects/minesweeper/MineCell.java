//complete appropriate methods 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class MineCell extends Cell 
{
	private boolean mine;
   private boolean lose = false;
  		
	public MineCell(int x, int y, int w, int h, boolean mine)
	{
      super(x,y,w,h,mine);          
	}
  

	public void setMined(boolean mine)
	{
      this.mine = mine;
	}

	public boolean getMined()
	{
		return mine;
  	}
   
	public void setLose(boolean lose)
	{
		this.lose = lose;
	}

		
	public void draw(Graphics window)
	{
      if(this.lose) {
         window.setColor(Color.RED);
         window.fillRect(getX(),getY(),getWidth(),getHeight());
         window.setColor(Color.BLACK);
         window.drawRect(getX(),getY(),getWidth(),getHeight());
      }
      else {
         window.setColor(Color.GRAY);
         window.fillRect(getX(),getY(),getWidth(),getHeight());
         window.setColor(Color.BLACK);
         window.drawRect(getX(),getY(),getWidth(),getHeight());
      }
         
    }

      
     


	
	
	public String toString()
	{
		return super.toString();
	}
}