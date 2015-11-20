public class sum13
{

    public static int sum13(int[] nums)
    {
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 13) {
                sum += nums[i];
            }
            else {
                i++;
            }
        }

        return sum;
    }


    public static void main (String[] args)
    {
        System.out.println(sum13(new int[] {1,2,2,1}));//6
        System.out.println(sum13(new int[] {1,2,2,1,13}));//6
        System.out.println(sum13(new int[] {1,2,13,1,13}));//3
        System.out.println(sum13(new int[] {13, 1, 2, 13, 2, 1, 13}));//3
        System.out.println(sum13(new int[] {}));//0
        System.out.println(sum13(new int[] {13}));//0
        System.out.println(sum13(new int[] {13,13}));//0
        System.out.println(sum13(new int[] {13, 1,13}));//0
        System.out.println(sum13(new int[] {5,7,2}));//14
        System.out.println(sum13(new int[] {0}));//0

    }
}
