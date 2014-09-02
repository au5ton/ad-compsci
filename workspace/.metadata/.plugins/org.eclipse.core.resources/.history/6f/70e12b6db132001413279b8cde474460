package austinjackson;

public class DayTwoB 
{
	/*
	 *method getFirstChunk() should return
	 *all letters up to the first @ sign
	 */
	public static String getFirstChunk( String line )
	{
		if(line.charAt(0) == '@')
		{
			return "";
		}
		else
		{
			return line.substring(0, line.indexOf('@'));
		}
	}

   public static void main( String args[] )
   {
		System.out.println( getFirstChunk("elephants@are@big") );    //outs elephants
		System.out.println( getFirstChunk("computer@science") );    //outs computer
		System.out.println( getFirstChunk("dogs@are@smarte@than@cats") );   //outs dogs
		System.out.println( getFirstChunk("chickens@are@kewl") );   //outs chickens
   }
}