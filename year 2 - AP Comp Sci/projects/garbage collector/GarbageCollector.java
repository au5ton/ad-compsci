import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class GarbageCollector extends JPanel implements MouseListener
{
	private int mouseX, mouseY;
	private boolean mouseClicked;
	private Grid trashMap;
	private final static int rows = 20;
	private final static int cols = 20;

	public GarbageCollector()
	{
		mouseClicked = false;
		trashMap = new Grid(rows,cols);
		for(int r=0; r<trashMap.getNumRows(); r++)
		{
			for(int c=0; c<trashMap.getNumCols(); c++)
			{
				if(Math.random() > 0.50) {
               trashMap.setSpot(r,c,new ColoredCell(r,c,true));
            }
            else {
               trashMap.setSpot(r,c,new ColoredCell(r,c,false));
            }
     		}
		}

		setBackground(Color.white);
		setVisible(true);

		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e)
	{
		mouseX=e.getX();
		mouseY=e.getY();
      mouseX = mouseX / 25;
      mouseY = mouseY / 25;
      System.out.println("Estimated cell clicked: ("+mouseX+" , "+mouseY+")");
		mouseClicked = true;
		repaint();
	}

	public void paintComponent( Graphics window )
	{
		super.paintComponent(window);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.setColor(Color.blue);
		window.drawString("Lab24c",420,40);
		window.drawString("THE GARBAGE COLLECTOR LAB", 420,55);
		if (mouseClicked)
		{
			int c = mouseY/cols;
			int r = mouseX/rows;
			pickUpTrash(r,c);
			mouseClicked = false;
		}
		drawTrashMap(window);
	}

	public void drawTrashMap( Graphics window  )
	{
		
		//use nested loops to draw the Trash Map
      // you will need to make a Cell object call cell and use cell.draw(window)
		for(int r=0; r<trashMap.getNumRows(); r++)
		{
			for(int c=0; c<trashMap.getNumCols(); c++)
			{
				trashMap.getSpot(r,c).draw(window);
     		}
		}
	}

	public void pickUpTrash( int r, int c )
	{
	//use recursion to pick up Trash
	
   /*
   
   if(r > 0 && r < atMat.length && c > 0 && c < atMat[r].length && atMat[r][c].equals("@")) {
         atMat[r][c] = "-";
         return 1 + countAts(r+1,c) + countAts(r-1,c) + countAts(r,c+1) + countAts(r,c-1);
      }
      return 0; 
   
   */
   
      if(r > 0 && r < trashMap.getNumRows() && c > 0 && c < trashMap.getNumRows() && ((ColoredCell)trashMap.getSpot(r,c)).getFilled()) {
         //atMat[r][c] = "-";
         trashMap.setSpot(r,c,new ColoredCell(r,c,false));
         //Thread.sleep(250);
         pickUpTrash(r+1,c);
         pickUpTrash(r-1,c);
         pickUpTrash(r,c+1);
         pickUpTrash(r,c-1);
      }
	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
