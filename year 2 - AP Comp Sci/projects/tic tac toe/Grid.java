    //complete the methods below
//the default constructor is done for you
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Grid
{
    private Drawable[][] grid;
    
    public Grid()
    {
        setSize(0,0);
    }

    public Grid(int rows, int cols)
    {
        setSize(rows,cols);
    }

    public void setSize(int rows, int cols)
    {
        grid = new Drawable[rows][cols];
    }

    public void setSpot(int row,int col, Drawable val)
    {
        grid[row][col] = val;
    }
    
    public Drawable getSpot(int row, int col)
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

  //lets you draw in the grid
  //returns true if you are able to draw
  public boolean drawGrid(Graphics window)
    {
        boolean full=true;
        
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] != null) {
                    grid[r][c].draw(window);
                }
                else {
                    full = false;
                }
            }
        }
        
        //for loop for row


            //for loop for col

                //get current Drawable
                    //if it is not null (null pointer exception)
                  // call the draw(window) method
                    
                    
                    //else
                //set full to false



        return full;
    }
    
   //print out the matrix
    public String toString()
    {
        String output="";
        
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c]+" ");
            }
            System.out.println();
        }





        return output;
    }
}