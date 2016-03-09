import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Minesweeper extends JPanel implements MouseListener
{
	private int mouseX, mouseY;
	private boolean mouseClicked;
	private Grid mineMap;
	private  int rows;
	private  int cols;

	public Minesweeper(int numMines, int row, int col)
	{
     	mouseClicked = false;
		rows = row;
      cols = col;
      mineMap = new Grid(rows,cols);
      
      //randomly load numMines amount of mines into the grid (make sure you address a mine that would be placed on top of another mine)
      //then load the rest of the empty cells 
		
      setBackground(Color.white);
		setVisible(true);
      numberOfMines();


		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e)
	{
		mouseX=e.getX();
		mouseY=e.getY();
		mouseClicked = true;
		repaint();
	}

	public void paintComponent( Graphics window )
	{
		super.paintComponent(window);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.setColor(Color.blue);
		window.drawString("Project",420,40);
		window.drawString("MINESWEEPER", 420,55);
		if (mouseClicked)
		{
			int c = mouseY/cols;
			int r = mouseX/rows;        
			play(r,c);
			mouseClicked = false;
		}
		drawMineGrid(window);
	}

	public void drawMineGrid( Graphics window  )
	{
		
		//draw the grid
		
	}

	public void play( int r, int c )
	{
   
   //recursively reveal empty cells
   //if a mine is clicked, all mines should be revealed
   
   }
   
	public void numberOfMines()
   {
      //count and set the number of surrounding mines for each cell     
   }
	
	

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
