public class diff21
{

    public static int diff21(int n)
    {
        if(n>21)
        return 2*Math.abs(21-n);
        return Math.abs(21-n);
    }


    static public void main (String[] args)
    {
        System.out.println(diff21(19));//2
        System.out.println(diff21(10)); //11
        System.out.println(diff21(21)); //0
        System.out.println(diff21(22)); //2
        System.out.println(diff21(25)); //8
        System.out.println(diff21(30)); //18
        System.out.println(diff21(0)); //21
        System.out.println(diff21(1)); //20
        System.out.println(diff21(2)); //19
        System.out.println(diff21(-1)); //22
        System.out.println(diff21(-2)); //23
        System.out.println(diff21(50)); //58
    }

}
