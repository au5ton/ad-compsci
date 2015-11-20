public class doubleChar
{

    public static String doubleChar(String str)
    {
        String end = "";

        for(int i = 0; i < str.length(); i++) {
            end += str.substring(i,i+1);
            end += str.substring(i,i+1);
        }
        return end;

    }

    static public void main (String[] args)
    {
        System.out.println(doubleChar("The"));//TThhee
        System.out.println(doubleChar("AAbb"));//AAAAbbbb
        System.out.println(doubleChar("Hi-There"));//HHii--TThheerree
        System.out.println(doubleChar("Word!"));//WWoorrdd!!
        System.out.println(doubleChar("!!"));//!!!!
        System.out.println(doubleChar(""));//*empty string*
        System.out.println(doubleChar("The"));//TThhee
        System.out.println(doubleChar("a"));//aa
    }

}
