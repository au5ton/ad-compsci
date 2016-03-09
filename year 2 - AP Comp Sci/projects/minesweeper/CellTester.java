//THis is complete; use it to test your code for Cell.java, EmptyCell.java, and MineCell.java
import static java.lang.System.*;
import java.awt.Color;

public class CellTester
{
	public static void main(String[] args)
	{
		Cell CellOne = new EmptyCell(5,5,10,10,false);
		out.println(CellOne);
		
		Cell CellTwo = new MineCell(10,10,5,5,true);
		out.println(CellTwo);
		
							
	}
}

