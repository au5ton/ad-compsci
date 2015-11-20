public class sumDouble
{

    public static int sumDouble(int a, int b)
    {
        if(a==b)
        return 2*(a+b);
        return a+b;
    }
    

    static public void main (String[] args)
    {
        System.out.println(sumDouble(1, 2));//3
        System.out.println(sumDouble(3, 2)); //5
        System.out.println(sumDouble(2, 2)); //8
        System.out.println(sumDouble(-1, 0)); //-1
        System.out.println(sumDouble(3, 3)); //12
        System.out.println(sumDouble(0, 0)); //0
        System.out.println(sumDouble(0, 1)); //1
        System.out.println(sumDouble(3, 4)); //7
    }

}
