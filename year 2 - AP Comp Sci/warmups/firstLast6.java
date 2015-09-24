public class firstLast6
{
   
   public static boolean firstLast6(int[] nums) 
   {
      return (nums[0] == 6)||(nums[nums.length-1] == 6);
   }

   
   public static void main (String[] args)
   {
     System.out.println(firstLast6(new int[] {1,2,6}));//true	    
     System.out.println(firstLast6(new int[]{6, 1, 2, 3}));//true	
     System.out.println(firstLast6(new int[]{13, 2, 6, 1, 6}));//true
     System.out.println(firstLast6(new int[]{13, 2, 6, 1}));//false	
     System.out.println(firstLast6(new int[]{1, 2, 3}));//false
     System.out.println(firstLast6(new int[]{3, 6, 1}));//false
     System.out.println(firstLast6(new int[]{3, 6}));//true	
     System.out.println(firstLast6(new int[]{6}));//true	
     System.out.println(firstLast6(new int[]{3}));//false	    
   }
     
}

