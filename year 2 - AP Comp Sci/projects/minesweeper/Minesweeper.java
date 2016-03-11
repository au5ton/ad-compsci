// import java.awt.Graphics;
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.event.MouseListener;
// import java.awt.event.MouseEvent;
// import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Minesweeper extends JPanel implements MouseListener
{
	private int mouseX, mouseY;
	private boolean mouseClicked;
	private Grid mineMap;
	private int rows;
	private int cols;
	private int numOriginalMines;
	private int clusterProgress;
	private int countPerCluster;
	private int temp;
	private final boolean cellLockEnabled = true;
	private boolean lost;
	private final boolean generatorDebugging = false;
	private final boolean useClusterGenerator = true;

	public Minesweeper(int numMines, int row, int col)
	{
		mouseClicked = false;
		rows = row;
		cols = col;
		numOriginalMines = numMines;
		this.lost = false;
		mineMap = new Grid(rows,cols);

		//randomly load numMines amount of mines into the grid (make sure you address a mine that would be placed on top of another mine)
		if(this.useClusterGenerator) {
			loadGridClustered(this.numOriginalMines);
		}
		else {
			loadGrid(this.numOriginalMines);
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

		//Draw game control buttons (EXTRA CREDIT)

		if (mouseClicked)
		{
			int c = mouseY/20;
			int r = mouseX/20;
			if(r >= 0 && r < rows && c >= 0 && c < cols && this.lost == false) {
				System.out.println("Playing tile ("+r+", "+c+") ...");
				if(mineMap.getSpot(r,c).getMine()) {
					((MineCell)mineMap.getSpot(r,c)).setLose(true);

					if(this.cellLockEnabled) {

						this.lost = true;

						System.out.println("You lost! Revealing all MineCells");
						int temp = 0;
						for(int rr = 0; rr < this.rows; rr++)
						for(int cc = 0; cc < this.cols; cc++) {
							if(mineMap.getSpot(rr,cc).getMine()) {
								temp++;
								((MineCell)mineMap.getSpot(rr,cc)).setLose(true);
							}
						}
						System.out.println("    Attempted to reveal "+temp+" MineCells");
					}

				}
				else {
					play(r,c);
				}
				System.out.println("    Recursion stack complete.");
			}
			else {
				System.out.println("Clicked outside of grid!");

				if(mouseX >= 10 && mouseX <= 10+100 && mouseY >= (20*this.rows)+10 && mouseY <= (20*this.rows)+10+30) {
					System.out.println("    Reset button clicked");
					JOptionPane.showMessageDialog(null, "Minefield will now reset", "Notice", JOptionPane.WARNING_MESSAGE);

					//Remove the loss
					this.lost = false;

					//Make the grid null again
					for(int rr = 0; rr < this.rows; rr++)
					for(int cc = 0; cc < this.cols; cc++) {
						mineMap.setSpot(rr,cc, null);
					}

					if(this.useClusterGenerator) {
						loadGridClustered(this.numOriginalMines);
					}
					else {
						loadGrid(this.numOriginalMines);
					}
					numberOfMines();
					repaint();
				}

			}
			mouseClicked = false;
		}
		drawMineGrid(window);
	}

	public void drawMineGrid( Graphics window  )
	{
		//draw the grid
		mineMap.drawGrid(window); //almost rewrote this whole method lol

		//draw reset button
		window.setColor(new Color(0, 170, 170));
		window.fillRect(10, (20*this.rows)+10, 100, 30);

		window.setColor(Color.BLACK);
		window.drawString("Reset minefield", 10, (20*this.rows)+10+16);

		if(this.lost) {

			window.setColor(Color.WHITE);
			window.fillRect(45,45,140,25);

			window.setColor(Color.BLACK);
			window.drawString("Sorry, but you lost. :(", 50+1, 65+1);

			window.setColor(Color.RED);
			window.drawString("Sorry, but you lost. :(", 50, 65);
		}
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

	//Old grid generation method
	public void loadGrid(int numMines) {
		int temp = 0;
		System.out.println(numMines+" mines requested to be generated. ");

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
			mineMap.setSpot(temp_r,temp_c, new MineCell(temp_r*20, temp_c*20, 20, 20, true));
			if(this.generatorDebugging) {
				((MineCell)mineMap.getSpot(temp_r,temp_c)).setLose(true);
			}
			//System.out.println("MineCell generated for: ("+temp_r+", "+temp_c+")");
			temp++;
		}
		System.out.println(temp+" mines generated.");

		//then load the rest of the empty cells
		for(int r = 0; r < this.rows; r++)
		for(int c = 0; c < this.cols; c++) {
			if(mineMap.getSpot(r,c) == null) {
				mineMap.setSpot(r,c, new EmptyCell(r*20, c*20, 20, 20, false));
			}
		}
	}

	//New and improved cluster generation
	public void loadGridClustered(int numMines) {
		this.clusterProgress = 0;
		this.temp = 0;
		System.out.println(this.clusterProgress+" mines requested to be generated. ");

		//Clusters method won't work
		if(isPrime(numMines)) {
			loadGrid(numMines);
		}
		else {

			int clusterCount = numMines / (numMines / ((int)smallestFactor(numMines)));
			countPerCluster = numMines / ((int)smallestFactor(numMines));

			this.countPerCluster = countPerCluster;

			MineCell[] seeds = new MineCell[clusterCount];

			//Generates initial clusterCount of random tiles
			for(int i = 0; i < clusterCount; i++) {
				int temp_r = ((int)Math.floor(Math.random()*(this.rows)));
				int temp_c = ((int)Math.floor(Math.random()*(this.cols)));
				while(mineMap.getSpot(temp_r,temp_c) != null) {
					temp_r = ((int)Math.floor(Math.random()*(this.rows)));
					temp_c = ((int)Math.floor(Math.random()*(this.cols)));
				}
				//Current spot in temp_r,temp_c is confirmed to be null because of the previous loop
				mineMap.setSpot(temp_r,temp_c, new MineCell(temp_r*20, temp_c*20, 20, 20, true));
				if(this.generatorDebugging) {
					((MineCell)mineMap.getSpot(temp_r,temp_c)).setLose(true);
				}
				seeds[i] = (MineCell)mineMap.getSpot(temp_r, temp_c);
			}

			//TODO: loops through seeds and cluster ✅

			for(MineCell item : seeds) {
				clusterAroundMine(item.getX()/20,item.getY()/20);
				this.clusterProgress = 0;
			}

			int count = 0;
			for(int r = 0; r < this.rows; r++)
			for(int c = 0; c < this.cols; c++) {
				if(mineMap.getSpot(r,c) != null) {
					count++;
				}
			}

			System.out.println("Counted "+count+" total MineCells generated.\nExpected "+numMines);

			if(numMines-count > 0)
				System.out.println("Filled "+(numMines-count)+" missing expected mines with random ones.");

			//If we're missing some extra spaces from the cluster method, use the original method
			for(int i = 0; i < numMines-count; i++) {
				//System.out.println("Generating MineCell...");
				int temp_r = ((int)Math.floor(Math.random()*(this.rows)));
				int temp_c = ((int)Math.floor(Math.random()*(this.cols)));
				while(mineMap.getSpot(temp_r,temp_c) != null) {
					temp_r = ((int)Math.floor(Math.random()*(this.rows)));
					temp_c = ((int)Math.floor(Math.random()*(this.cols)));
				}
				//Current spot in temp_r,temp_c is confirmed to be null because of the previous loop
				mineMap.setSpot(temp_r,temp_c, new MineCell(temp_r*20, temp_c*20, 20, 20, true));
			}

			count = 0;
			for(int r = 0; r < this.rows; r++)
			for(int c = 0; c < this.cols; c++) {
				if(mineMap.getSpot(r,c) != null) {
					count++;
				}
			}

			System.out.println("Second count: counted "+count+" total MineCells generated.\nExpected "+numMines);

			//then load the rest of the empty cells
			for(int r = 0; r < this.rows; r++)
			for(int c = 0; c < this.cols; c++) {
				if(mineMap.getSpot(r,c) == null) {
					mineMap.setSpot(r,c, new EmptyCell(r*20, c*20, 20, 20, false));
				}
			}

		}
	}

	public void clusterAroundMine(int r, int c) {
		System.out.println("clusterAroundMine("+r+", "+c+")");
		if(mineMap.withinBounds(r,c) && this.clusterProgress < this.countPerCluster) {
			mineMap.setSpot(r,c, new MineCell(r*20, c*20, 20, 20, true));
			if(this.generatorDebugging) {
				((MineCell)mineMap.getSpot(r,c)).setLose(true);
			}
			this.clusterProgress++;

			//1-3 inclusive, how far the cluster should be from the parent piece
			int randomOffset = (int)Math.floor(Math.random()*3)+1;

			//1-3 inclusive, how many times this piece should branch off
			int randomSprouts = (int)Math.floor(Math.random()*2)+1;

			//TODO: loop through randomSprouts and recurse in randomOffset offset

			for(int i = 0; i < randomSprouts; i++) {
				double rand1 = Math.random();
				double rand2 = Math.random();

				//1-3 inclusive, how far the cluster should be from the parent piece
				randomOffset = (int)Math.floor(Math.random()*3)+1;

				if(rand1 > 0.666) {
					//Positive r offset
					if(rand2 > 0.666) {
						//Positive c offset
						if(!mineMap.withinBounds(r+randomOffset,c+randomOffset) || mineMap.getSpot(r+randomOffset,c+randomOffset) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r+randomOffset,c+randomOffset);
						}
					}
					else if(rand2 < 0.333) {
						//Negative c offset
						if(!mineMap.withinBounds(r+randomOffset,c-randomOffset) || mineMap.getSpot(r+randomOffset,c-randomOffset) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r+randomOffset,c-randomOffset);
						}
					}
					else {
						//C offset uneffected
						if(!mineMap.withinBounds(r+randomOffset,c) || mineMap.getSpot(r+randomOffset,c) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r+randomOffset,c);
						}
					}
				}
				else if(rand1 < 0.333) {
					//Negative r offset
					if(rand2 > 0.666) {
						//Positive c offset
						if(!mineMap.withinBounds(r-randomOffset,c+randomOffset) || mineMap.getSpot(r-randomOffset,c+randomOffset)!= null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r-randomOffset,c+randomOffset);
						}
					}
					else if(rand2 < 0.333) {
						//Negative c offset
						if(!mineMap.withinBounds(r-randomOffset,c-randomOffset) || mineMap.getSpot(r-randomOffset,c-randomOffset) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r-randomOffset,c-randomOffset);
						}
					}
					else {
						//C offset uneffected
						if(!mineMap.withinBounds(r-randomOffset,c) || mineMap.getSpot(r-randomOffset,c) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r-randomOffset,c);
						}
					}
				}
				else {
					//R offset uneffected
					if(rand2 > 0.666) {
						//Positive c offset
						if(!mineMap.withinBounds(r,c+randomOffset) || mineMap.getSpot(r,c+randomOffset) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r,c+randomOffset);
						}
					}
					else if(rand2 < 0.333) {
						//Negative c offset
						if(!mineMap.withinBounds(r,c-randomOffset) || mineMap.getSpot(r,c-randomOffset) != null) {
							randomSprouts++; //loop another time
						}
						else {
							clusterAroundMine(r,c-randomOffset);
						}
					}
					else {
						//C offset uneffected; REDUNDANT IT'S THE SAME TILE
					}
				}

			}


		}
	}


	private static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
		if (num % i == 0) return false;
		return true;
	}

	public static long smallestFactor(int C)
	{
		for (int i = 2; i*i<= C; i++)
		{
			if (C % i == 0)
			{
				return i;
			}
		}

		return C;
	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
