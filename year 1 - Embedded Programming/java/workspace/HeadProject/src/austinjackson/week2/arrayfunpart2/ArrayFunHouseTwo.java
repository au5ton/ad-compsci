package austinjackson.week2.arrayfunpart2;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class ArrayFunHouseTwo
{
	//goingUp() will return true if all numbers
	//in numArray are in increasing order
	//[1,2,6,9,23] returns true
	//[9, 11, 13, 8]  returns false
	public static boolean goingUp(int[] numArray)
	{
		for(int i = 0; i < numArray.length; i++)
		{
			if(i > 0)
			{
				if(numArray[i] > numArray[i-1])
				{
					prnt(numArray[i]+" (index "+i+") is less than "+numArray[i-1]+" (index "+(i-1)+")");
					continue;
				}
				else
				{
					prnt(numArray[i]+" (index "+i+") is NOT less than "+numArray[i-1]+" (index "+(i-1)+")");
					return false;
				}
			}
		}
		
		return true;
	}

	//goingDown() will return true if all numbers
	//in numArray are in decreasing order
	//[31,12,6,2,1] returns true
	//[31, 20, 10, 15, 9] returns false
	public static boolean goingDown(int[] numArray)
	{
		for(int i = 0; i < numArray.length; i++)
		{
			if(i > 0)
			{
				if(numArray[i] < numArray[i-1])
				{
					prnt(numArray[i]+" (index "+i+") is greater than "+numArray[i-1]+" (index "+(i-1)+")");
					continue;
				}
				else
				{
					prnt(numArray[i]+" (index "+i+") is NOT greater than "+numArray[i-1]+" (index "+(i-1)+")");
					prnt("STOPPING!");
					return false;
				}
			}
		}
		
		return true;
	}

	//getValuesBiggerThanX will return an array that contains
	//count number of values that are larter than parameter x
	//[1,2,3,4,5,6,7,8,9,10,11,6],3,5  would return [6,7,8]
	public static int[] getCountValuesBiggerThanX(int[] numArray, int count, int x)
	{
		List<Integer> l = new ArrayList<Integer>();
		
		int c = 0;
		for(int i = 0; c < count && i < numArray.length; i++)
		{
			if(numArray[i] > x)
			{
				l.add(numArray[i]);
				c++;
			}
		}
		
		int[] result = new int[l.size()];
		
		for(int i = 0; i < result.length; i++)
		{
			result[i] = l.get(i).intValue();
		}
		
		return result;
	}
	
	public static void prnt(String s)
	{
		System.out.println("    "+s);
	}
}