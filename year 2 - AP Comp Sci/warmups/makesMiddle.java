import java.util.Arrays;

public class makesMiddle
{

   public static int[] makeMiddle(int[] nums)
   {
      if(nums.length > 2) {
          int[] result = { nums[(nums.length/2)-1], nums[nums.length/2] };
         return result;
      }
      else {
         return nums;
      }

   }



   static public void main (String[] args)
   {
     System.out.println(Arrays.toString(makeMiddle(new int[]{1, 2, 3, 4})));//{2, 3}
     System.out.println(Arrays.toString(makeMiddle(new int[]{7, 1, 2, 3, 4, 9})));//{2, 3}
     System.out.println(Arrays.toString(makeMiddle(new int[]{1, 2})));//{1, 2}
     System.out.println(Arrays.toString(makeMiddle(new int[]{5, 2, 4, 7})));//{2, 3}
     System.out.println(Arrays.toString(makeMiddle(new int[]{9, 0, 4, 3, 9, 1})));//{4, 3}
   }
}
