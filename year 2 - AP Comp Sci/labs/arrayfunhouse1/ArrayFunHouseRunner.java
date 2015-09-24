import java.util.Arrays;

public class ArrayFunHouseRunner
{
	public static void main( String args[] )
	{
		int[] one = {4,10,0,1,7,6,5,3,2,9};

		System.out.println(Arrays.toString(one));//prints the array
		System.out.println("sum of spots 3-6  =  " + ArrayFunHouse.getSum(one,3,6));
		System.out.println("sum of spots 2-9  =  " + ArrayFunHouse.getSum(one,2,9));
		System.out.println("# of 4s  =  " + ArrayFunHouse.getCount(one,4));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(one,7));
		System.out.println("before removing all 7s " + Arrays.toString(one));
		one = ArrayFunHouse.removeVal(one,7);
		System.out.println("after removing all 7s " + Arrays.toString(one));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(one,7));

		System.out.println("********************************************");

      int[] two = {4,2,3,4,6,7,8,9,0,10,0,1,7,6,5,3,2,9,9,8,7};
     
      System.out.println(Arrays.toString(two));//prints the array
		System.out.println("sum of spots 20-21  =  " + ArrayFunHouse.getSum(two,20,21));
		System.out.println("sum of spots 8-11  =  " + ArrayFunHouse.getSum(two,8,11));
		System.out.println("# of 2s  =  " + ArrayFunHouse.getCount(two,2));
		System.out.println("# of 9s  =  " + ArrayFunHouse.getCount(two,9));
		System.out.println("before removing all 9s " + Arrays.toString(two));
		two = ArrayFunHouse.removeVal(two,9);
		System.out.println("after removing all 9s " + Arrays.toString(two));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(two,9)); 


	}
}