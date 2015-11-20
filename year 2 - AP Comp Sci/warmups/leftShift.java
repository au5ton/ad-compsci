import java.util.Arrays;
public class leftShift
{

    public static int[] leftShift(int[] nums)
    {
        if(nums.length >= 2) {
            int[] first = new int[nums.length-1];
            for(int i = 0; i < first.length; i++) {
                first[i] = nums[i+1];
            }

            int[] result = new int[first.length+1];
            for(int i = 0; i < result.length; i++) {
                if(i < result.length-1) {
                    result[i] = first[i];
                }
                else {
                    result[i] = nums[0];
                }
            }
            return result;

        }
        else {
            return nums;
        }
    }


    public static void main (String[] args)
    {
        System.out.println(Arrays.toString(leftShift(new int[]{6, 2, 5, 3})));//[2, 5, 3, 6]
        System.out.println(Arrays.toString(leftShift(new int[]{1, 2})));// [2, 1]
        System.out.println(Arrays.toString(leftShift(new int[]{1})));//[1]
        System.out.println(Arrays.toString(leftShift(new int[]{})));//[]
        System.out.println(Arrays.toString(leftShift(new int[]{1, 1, 2, 2, 4})));//[1, 2, 2, 4, 1]
        System.out.println(Arrays.toString(leftShift(new int[]{3, 6, 1})));//[6, 1, 3]
        System.out.println(Arrays.toString(leftShift(new int[]{1, 1, 1})));//[1, 1, 1]
        System.out.println(Arrays.toString(leftShift(new int[]{1, 2, 3})));//[2, 3, 1]
    }
}
