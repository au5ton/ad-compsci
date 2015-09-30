import java.util.Arrays;

public class GoofyNumbers
{
    /** 	@param num is a positive non-decimal value
     *  		Precondition : num >= 0
     *  	@return true if the sum of digits of num is odd 
			@return false if the sum of the digits of num is even
     */
  public static boolean isGoofy(int num) //9154 
  {  
      
      while(Integer.toString(num).length() > 1) {
         int temp = 0;
         String str = Integer.toString(num);
         for(int i = 0; i < str.length(); i++) {
            temp += Character.getNumericValue(str.charAt(i));
         }
         num = temp;
      }
      if(num % 2 == 1) {
         return true;
      }
      return false;
   
  }
          
     	
    /* @param count is a positive non-decimal value
     *  		Precondition : count > 0
     *   @return an array containing count Goofy numbers
     */   
  public static int[] getSomeGoofyNumbers(int count)
  {
      int[] result = new int[count];
      int i = 0; 
      int j = 0;
      while(j < count) {
         if(isGoofy(i)) {
            result[j] = i;
            j++;
         }
         i++;
      }
      
      return result;
  }


	public static void main(String args[])
	{
		System.out.println(isGoofy(13));//false
		System.out.println(isGoofy(5));//true
		System.out.println(isGoofy(6));//false
		System.out.println(isGoofy(7654389));//false 
		System.out.println(Arrays.toString(getSomeGoofyNumbers(3)));//[1, 3, 5]
	   System.out.println(Arrays.toString(getSomeGoofyNumbers(15)));//[1, 3, 5, 7, 9, 10, 12, 14, 16, 18, 21, 23, 25, 27, 29]

   }
}

