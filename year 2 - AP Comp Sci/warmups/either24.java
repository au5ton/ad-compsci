import java.util.Arrays;
public class either24
{
   
   public static boolean either24(int[] nums) 
   {
      boolean pairOf4 = false;
      boolean pairOf2 = false;
      for(int i = 0; i < nums.length; i++)
      {
         try
         {
            if(nums[i] == 2 && nums[i+1] == 2)
            {
               pairOf2 = true;
            }
            else if(nums[i] == 4 && nums[i+1] == 4)
            {
               pairOf4 = true;
            }
         }
         catch(Exception e){} 
      }
      if(pairOf2 && pairOf4)
      {
         return false;
      }
      else if(pairOf2 && !pairOf4)
      {
         return true;
      }
      else if(!pairOf2 && pairOf4)
      {
         return true;
      }
      else
      {
         return false;
      }
   }


   
   public static void main (String[] args)
   {
      System.out.println(either24(new int [] {1,2,2}));//true	    
      System.out.println(either24(new int [] {4,4,1}));// true
      System.out.println(either24(new int [] {4, 4, 1, 2, 2}));// false
      System.out.println(either24(new int [] {1, 2, 3, 4}));// false
      System.out.println(either24(new int [] {1, 2, 3, 4, 4}));// true
      System.out.println(either24(new int [] {2, 2, 3, 4}));// true
      System.out.println(either24(new int [] {1, 2, 3, 2, 2, 4}));// true 
      System.out.println(either24(new int [] {1, 2, 3, 2, 2, 4, 4}));// false
      System.out.println(either24(new int [] {1, 2}));// false 
      System.out.println(either24(new int [] {2,2}));// true 
      System.out.println(either24(new int [] {4,4}));// true 
      System.out.println(either24(new int [] {2}));// false 
      System.out.println(either24(new int [] {}));// false    
   }
}
