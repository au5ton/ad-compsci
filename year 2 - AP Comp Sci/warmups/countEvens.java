public class countEvens
{
   
   public static int countEvens(int[] nums) 
   {  int c = 0;
      for(int i = 0; i < nums.length; i++) {
         if(nums[i]%2 == 0) {
            c++;
         }
      }
      return c;
   }


   
   public static void main (String[] args)
   {
     System.out.println(countEvens(new int[]{2, 1, 2, 3, 4}));//3	    
     System.out.println(countEvens(new int[]{2, 2, 0}));//3	
     System.out.println(countEvens(new int[]{1, 3, 5}));//0
     System.out.println(countEvens(new int[]{}));//0	
     System.out.println(countEvens(new int[]{11, 9, 0, 1}));//1
     System.out.println(countEvens(new int[]{2, 11, 9, 0}));//2
     System.out.println(countEvens(new int[]{2, 5, 12}));//2	
     System.out.println(countEvens(new int[]{2}));//1    
   }
 
}

