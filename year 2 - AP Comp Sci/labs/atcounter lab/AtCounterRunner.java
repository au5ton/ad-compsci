import static java.lang.System.*;

public class AtCounterRunner
{
	public static void main(String args[])
	{
		AtCounter test = new AtCounter(10, 10);
		System.out.println(test);
		out.println("0 0 has "+test.countAts(0,0) + "\n\n");

		test = new AtCounter(10, 10);
		System.out.println(test);
		out.println("5 5 has "+test.countAts(5,5) + "\n\n");
      
      test = new AtCounter(10, 10);
		System.out.println(test);
		out.println("12 12 has "+test.countAts(12,12) + "\n\n");
      
      test = new AtCounter(10, 10);
		System.out.println(test);
		out.println("-1 -3 has "+test.countAts(-1,-3) + "\n\n");
      
    }
      
}