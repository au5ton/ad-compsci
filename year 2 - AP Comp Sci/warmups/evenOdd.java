import java.util.Arrays;
import java.util.ArrayList;
public class evenOdd
{

    public static int[] evenOdd(int[] nums)
    {
        
        ArrayList<Integer> list = new ArrayList<Integer>();

        //Adds evens
        for(int n : nums) {
            if(n%2 == 0) {
                list.add(n);
            }
        }
        //Adds odds
        for(int n : nums) {
            if(n%2 == 1) {
                list.add(n);
            }
        }
        //Converts ArrayList to primitive array
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;

    }


    public static void main (String[] args)
    {
        System.out.println(Arrays.toString(evenOdd(new int[]{1, 0, 1, 0, 0, 1, 1})));//[2, 5, 3, 6]
        System.out.println(Arrays.toString(evenOdd(new int[]{3, 3, 2})));// [2, 1]
        System.out.println(Arrays.toString(evenOdd(new int[]{2, 2, 2})));//[1]
        System.out.println(Arrays.toString(evenOdd(new int[]{3, 2, 2})));//[]
        System.out.println(Arrays.toString(evenOdd(new int[]{1, 1, 0, 1, 0})));//[1, 2, 2, 4, 1]
        System.out.println(Arrays.toString(evenOdd(new int[]{1})));//[6, 1, 3]
        System.out.println(Arrays.toString(evenOdd(new int[]{1, 2})));//[1, 1, 1]
        System.out.println(Arrays.toString(evenOdd(new int[]{2,2})));//[2, 3, 1]
        System.out.println(Arrays.toString(evenOdd(new int[]{})));//[]
    }
}
