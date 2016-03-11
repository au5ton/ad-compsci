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
		for(int i = 0; i < numMines; i++) {
			int temp_r = ((int)Math.random()*(this.rows+1));
			int temp_c = ((int)Math.random()*(this.cols+1));
			while(mineMap.getSpot(temp_r,temp_c) != null) {
				temp_r = ((int)Math.random()*(this.rows+1));
				temp_c = ((int)Math.random()*(this.cols+1));
			}
			//Current spot in temp_r,temp_c is confirmed to be null because of the previous loop
			mineMap.setSpot(temp_r,temp_c, new MineCell(temp_r*this.rows+10, temp_c*this.cols+10, 10, 10, true));
		}

		//then load the rest of the empty cells
		for(int r = 0; r < this.rows; r++)
			for(int c = 0; c < this.cols; c++) {
				if(mineMap.getSpot(r,c) == null) {
					mineMap.setSpot(r,c, new EmptyCell(r*this.rows+10, c*this.cols+10, 10, 10, false));
				}
			}

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
		mineMap.drawGrid(window); //almost rewrote this whole method lol
		
	}

	public void play( int r, int c )
	{

		//recursively reveal empty cells
		//if a mine is clicked, all mines should be revealed
		if(r >= 0 && r < rows && c >= 0 && c < cols) { //within bounds
			if(!mineMap.getSpot(r,c).getMine() && !((EmptyCell)mineMap.getSpot(r,c)).getVisited()) { //NOT a mine and NOT visited
				((EmptyCell)mineMap.getSpot(r,c)).setVisited(true);
				/*play(r-1,c-1);
				play(r-1,c+1);
				play(r+1,c-1);
				play(r+1,c+1);
				play(r,c-1);
				play(r,c+1);
				play(r-1,c);
				play(r+1,c);*/
				
				for(int rr = -1; rr <= 1; rr++) {
					for(int cc = -1; cc <= 1; cc++) {
						play(r+rr,c+cc);
					}
				}
			}
		}

	}

	public void numberOfMines()
	{
		//count and set the number of surrounding mines for each cell
		for(int r = 0; r < this.rows; r++)
			for(int c = 0; c < this.cols; c++) {
				int count = 0;
				for(int rr = -1; rr <= 1; rr++) {
					for(int cc = -1; cc <= 1; cc++) {
						if(mineMap.getSpot(r+rr,c+cc).getMine()) {
							count++;
						}
					}
				}
				((EmptyCell)mineMap.getSpot(r,c)).setCount(count);
			}
	}



	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
