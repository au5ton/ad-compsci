//This is complete; use it to test your Grid.java code
import static java.lang.System.*;
import java.awt.Color;

public class GridTester
{
	public static void main(String[] args)
	{
		Grid gridTest = new Grid(2,2);
		
		out.println(gridTest.getNumRows());
		out.println(gridTest.getNumCols());
		
		gridTest.setSpot(0,0,new ColoredCell(3,3, false));
		out.println(gridTest);	
		
		gridTest.setSpot(1,1,new ColoredCell(100,100,4,4,true));
		out.println(gridTest);	

		gridTest.setSpot(1,1,new ColoredCell(200 ,200, 20, 20, false, Color.RED));
		out.println(gridTest);	
		
		out.println(gridTest.getSpot(1,0));		
		out.println(gridTest.getSpot(0,1));							
	}
}

