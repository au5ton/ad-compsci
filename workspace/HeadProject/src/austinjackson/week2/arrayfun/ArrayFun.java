package austinjackson.week2.arrayfun;

import java.util.Arrays;

public class ArrayFun
{
	public static void main( String args[] )
	{
		
		//CHANGE ME
		ArrayTools.logging = false;
		
		int[] one = {7, 4, 10, 0, 1, 7, 6, 5, 3, 2, 9, 7};

		System.out.println(Arrays.toString(one));
		System.out.println("sum of spots 3-6  =  " + ArrayTools.getSumOfIndexes(one,3,6));
		System.out.println("sum of spots 2-9  =  " + ArrayTools.getSumOfIndexes(one,2,9));
		System.out.println("# of 4s  =  " + ArrayTools.getIterationsOfValue(one,4));
		System.out.println("# of 7s  =  " + ArrayTools.getIterationsOfValue(one,7));
		System.out.println("before removing all 7s " + Arrays.toString(one));
		one = ArrayTools.removeAllValuesFromArray(one,7);
		System.out.println("after removing all 7s " + Arrays.toString(one));
		System.out.println("# of 7s  =  " + ArrayTools.getIterationsOfValue(one,7));

		int[] two = {4,2,3,4,6,7,8,9,0,10,0,1,7,6,5,3,2,9,9,8,7};

		System.out.println("\n\n"+Arrays.toString(two));
		System.out.println("sum of spots 3-16  =  " + ArrayTools.getSumOfIndexes(two,3,16));
		System.out.println("sum of spots 2-9  =  " + ArrayTools.getSumOfIndexes(two,2,9));
		System.out.println("# of 0s  =  " + ArrayTools.getIterationsOfValue(two,0));
		System.out.println("# of 4s  =  " + ArrayTools.getIterationsOfValue(two,4));
	}
}