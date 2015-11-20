public class bigDiff
{

    public static int bigDiff(int[] nums)
    {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            largest = Math.max(largest,nums[i]);
            smallest = Math.min(smallest,nums[i]);
        }
        return largest - smallest;
    }


    public static void main (String[] args)
    {
        System.out.println(bigDiff(new int[] {10, 3, 5, 6}));//7
        System.out.println(bigDiff(new int[] {7, 2, 10, 9}));//8
        System.out.println(bigDiff(new int[] {10,0}));//10
        System.out.println(bigDiff(new int[] {2, 10, 7, 2}));//8
        System.out.println(bigDiff(new int[] {2,10}));//8
        System.out.println(bigDiff(new int[] {2,2}));//0
        System.out.println(bigDiff(new int[] {2}));//0


    }
}
