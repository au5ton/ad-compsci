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

		int temp = 0;
		System.out.println(numMines+" mines requested to be generated.");

		//randomly load numMines amount of mines into the grid (make sure you address a mine that would be placed on top of another mine)
		for(int i = 0; i < numMines; i++) {
			//System.out.println("Generating MineCell...");
			int temp_r = ((int)Math.floor(Math.random()*(this.rows)));
			int temp_c = ((int)Math.floor(Math.random()*(this.cols)));
			while(mineMap.getSpot(temp_r,temp_c) != null) {
				temp_r = ((int)Math.floor(Math.random()*(this.rows)));
				temp_c = ((int)Math.floor(Math.random()*(this.cols)));
			}
			//Current spot in temp_r,temp_c is confirmed to be null because of the previous loop
			mineMap.setSpot(temp_r,temp_c, new MineCell(temp_r*this.rows, temp_c*this.cols, 20, 20, true));
			//System.out.println("MineCell generated for: ("+temp_r+", "+temp_c+")");
			temp++;
		}
		System.out.println(temp+" mines generated.");

		//then load the rest of the empty cells
		for(int r = 0; r < this.rows; r++)
		for(int c = 0; c < this.cols; c++) {
			if(mineMap.getSpot(r,c) == null) {
				mineMap.setSpot(r,c, new EmptyCell(r*this.rows, c*this.cols, 20, 20, false));
			}
		}

		setBackground(Color.white);
		setVisible(true);
		numberOfMines();
		repaint();
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
			System.out.println("Playing tile ("+r+", "+c+") ...");
			if(mineMap.getSpot(r,c).getMine()) {
				((MineCell)mineMap.getSpot(r,c)).setLose(true);
			}
			else {
				play(r,c);
			}
			System.out.println("    Recursion stack complete.");
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
		//System.out.println("    play("+r+","+c+");");
		//recursively reveal empty cells
		//if a mine is clicked, all mines should be revealed
		if(r >= 0 && r < rows && c >= 0 && c < cols) { //within bounds
			if(!mineMap.getSpot(r,c).getMine() && !((EmptyCell)mineMap.getSpot(r,c)).getVisited()) { //NOT a mine and NOT visited
				((EmptyCell)mineMap.getSpot(r,c)).setVisited(true);
				System.out.println("    play("+r+","+c+");");
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
						if(((EmptyCell)mineMap.getSpot(r,c)).getCount() == 0) {
							play(r+rr,c+cc);
						}
					}
				}
			}
			/*else if(mineMap.getSpot(r,c).getMine()) {
				for(int r = 0; r < rows; r++)
					for(int c = 0; c < cols; c++) {
						mineMap.getSpot(r,c).draw()
					}
			}*/
		}

	}

	public void numberOfMines()
	{
		//count and set the number of surrounding mines for each cell
		for(int r = 0; r < this.rows; r++)
		for(int c = 0; c < this.cols; c++) {
			if(!mineMap.getSpot(r,c).getMine()) {
				int count = 0;
				for(int rr = -1; rr <= 1; rr++) {
					for(int cc = -1; cc <= 1; cc++) {
						if(r+rr >= 0 && r+rr < rows && c+cc >= 0 && c+cc < cols && mineMap.getSpot(r+rr,c+cc).getMine()) {
							count++;
						}
					}
				}
				((EmptyCell)mineMap.getSpot(r,c)).setCount(count);
			}
		}
	}



	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
