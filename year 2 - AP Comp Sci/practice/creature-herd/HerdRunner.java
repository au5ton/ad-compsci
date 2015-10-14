import java.util.ArrayList;

public class HerdRunner
{
	public static void main ( String[] args )
	{
		Herd bunch = new Herd();
		bunch.add(33);
		bunch.add(115);
		bunch.add(16);
		bunch.add(83);
		bunch.add(45);
		bunch.add(96);
		System.out.println(bunch);
		System.out.println("Big One count = " + bunch.countBigOnes() );
  }
}