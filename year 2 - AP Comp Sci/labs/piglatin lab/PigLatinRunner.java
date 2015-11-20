public class PigLatinRunner
{
    public static void main (String[] args)
    {
        PigLatinConverter line = new PigLatinConverter();
        System.out.println(line.convertLine("I will do great on the AP Computer Science exam"));
        System.out.println(line.convertLine("String methods are easy"));
        System.out.println(line.convertLine("apples bananas"));
        System.out.println(line.convertLine("Reagan"));
    }
}
