public class ArrayFunHouse
{
	//instance variables and constructors could be used, but are not really needed

	//getSum() will return the sum of the numbers from start to stop, not including stop
	//Use a for loop to traverse the array
	public static int getSum(int[] numArray, int start, int stop)
	{
		int result = 0;
		for(int i = start; i < stop; i++)
		{
			result += numArray[i];
		}

		return result;
	}

	//getCount() will return number of times val is present
	public static int getCount(int[] numArray, int val)
	{
		int occurences = 0;
		for(int i = 0; i < numArray.length; i++)
		{
			if(numArray[i] == val) {
				occurences++;
			}
		}
		return occurences;
	}

	//removes all instances of val?
	public static int[] removeVal(int[] numArray, int val)
	{

		int occurences = getCount(numArray, val);
		int[] result = new int[numArray.length-occurences];
		int resultPlace = 0;

		for(int i = 0; i < numArray.length; i++)
		{
			if(numArray[i] != val) {
				result[resultPlace] = numArray[i];
				resultPlace++;
			}
		}

		return result;
	}
}
