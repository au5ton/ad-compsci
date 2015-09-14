package austinjackson.week2.arrayfun;

import java.util.ArrayList;
import java.util.List;

public class ArrayTools 
{
	
	public static boolean logging = true;
	
	public static int getSumOfIndexes(int[] array) //get's the sum of the entire array
	{
		int result = 0;
		for(int i = 0; i < array.length; i++)
		{
			result += array[i];
			prnt("Adding \'"+array[i]+"\', index "+i+", result so far: "+result);
		}
		
		return result;
	}
	
	public static int getSumOfIndexes(int[] array, int start) //get's the sum of the array, starting from int start
	{
		int result = 0;
		for(int i = start; i < array.length; i++)
		{
			result += array[i];
			prnt("Adding \'"+array[i]+"\', index "+i+", result so far: "+result);
		}
		
		return result;
	}
	
	public static int getSumOfIndexes(int[] array, int start, int end) //get's the sum of the array in between int start and int end
	{
		int result = 0;
		for(int i = start; i <= end; i++)
		{
			result += array[i];
			prnt("Adding \'"+array[i]+"\', index "+i+", result so far: "+result);
		}
		
		return result;
	}
	
	public static int getIterationsOfValue(int[] array, int value) //Checks how many times int value appears in the array
	{
		prnt("Counting the amount of iterations of \'"+value+"\'...");
		int count = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				prnt("Found \'"+value+"\' at index "+i);
				count++;
			}
		}
		return count;
	}
	/*
	public static int[] removeAllValuesFromArray(int[] array, int value)
	{
		//
		// Generates a different array with the allocated
		// size being the length of the old, without the Iterations of the value
		//
		int[] betterArray = new int[array.length-getIterationsOfValue(array, value)];
		int i2 = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != value)
			{
				betterArray[i2] = array[i];
				i2++;
			}
		}
		
		return betterArray;
	}
	*/
	
	public static int[] removeAllValuesFromArray(int[] array, int value)
	{
		/*
		 * Alternative method that uses Lists to properly add(),
		 * making the fixed sizes of Arrays less error prone
		 */
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != value)
			{
				list.add(array[i]);
				prnt("Added value at index "+i+" to the List.");
			}
			else
			{
				prnt("Value at index "+i+" won\'t be added.");
			}
		}
		
		int[] betterArray = new int[list.size()-1];
		
		for(int i = 0; i < betterArray.length; i++)
		{
			betterArray[i] = list.get(i).intValue();
		}
		
		return betterArray;
	}
	
	public static void prnt(String s)
	{
		if(logging == true)
		{
			System.out.println("    "+s);
		}
	}
}
