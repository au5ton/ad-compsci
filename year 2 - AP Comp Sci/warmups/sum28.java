public class sum28
{

    public static boolean sum28(int[] nums)
    {

        int sum = 0;
        for(int x : nums) {
            if(x == 2) {
                sum += x;
            }
        }
        return (sum==8);

    }


    public static void main (String[] args)
    {
        System.out.println(sum28(new int[] {1,2,2,1}));//false
        System.out.println(sum28(new int[] {1,3}));//false
        System.out.println(sum28(new int[] {2}));//false
        System.out.println(sum28(new int[] {}));//false
        System.out.println(sum28(new int[] {8}));//false
        System.out.println(sum28(new int[] {2,2,2,2}));//true
        System.out.println(sum28(new int[] {2,6,7,2,12,22,2,9,11,2}));//true
        System.out.println(sum28(new int[] {2,2,13,2,7,8,2,2}));//true


    }
}
