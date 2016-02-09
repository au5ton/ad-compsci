//this class is complete
//use it to test your Piece class
import static java.lang.System.*;
import java.awt.Color;

public class PieceTester
{
	public static void main(String[] args)
	{
		Piece pieceOne = new Piece();
		out.println(pieceOne);
		
		Piece redChecker = new Piece("red checker");
		out.println(redChecker);	
		
		Piece theShoe = new Piece(100,100,"top hat");
		out.println(theShoe);	
		
		Piece bishop = new Piece(200 ,200, 20, 20, "bishop", Color.WHITE);
		out.println(bishop);					
	}
}

