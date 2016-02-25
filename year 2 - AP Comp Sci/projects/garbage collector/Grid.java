//Fill in the constructor and modifier methods
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Grid
{
	private Cell[][] grid;
	
	public Grid() //set the default size to 0,0
	{
		grid = new Cell[0][0];
	}

	public Grid(int rows, int cols)
	{
      setSize(rows,cols);
	}

	public void setSize(int rows, int cols)
	{
		grid = new Cell[rows][cols];
	}

	public void setSpot(int row,int col, Cell val)
	{
      grid[row][col] = val;
	}
	
	public Cell getSpot(int row, int col)
	{
		return grid[row][col];
   }
	
	public int getNumRows()
	{
		return grid.length;
	}
	
	public int getNumCols()
	{
		return grid[0].length;
   }

	public boolean drawGrid(Graphics window)
	{
      //make sure you know what's happening here
		boolean full=true;
		
		for(int r=0;r<grid.length;r++)
		{
			for(int c=0;c<grid[r].length;c++)
			{
				Cell spot = grid[r][c];
				
				if(grid[r][c]!=null)
               grid[r][c].draw(window);
            else 
               full=false;

			}
		}
		return full;
	}
	
	public String toString()
	{
		String output="";
		//use nested loops	
	   
      for(int r = 0; r < grid.length; r++)
         for(int c = 0; c < grid[r].length; c++) {
            if(grid[r][c]!=null)
               output += (grid[r][c].toString()+" ");
            else
               output += "null ";
         }
	
		return output;
	}

}