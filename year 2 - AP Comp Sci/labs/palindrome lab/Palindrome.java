public class Palindrome
{
    private boolean palindrome;
    private String str;

    public Palindrome(String s)
    {
        str = s;
        palindrome = isPalindrome();
    }

    /**
    * precondition:   str is not null
    *	               palindrome is true or false
    * Postcondition: returns a string in the format:
    *			   	  String:		value of str
    *				     Palindrome:	value of palindrome
    */
    public String toString()
    {
        return "String: '"+str+"', "+
        "Palindrome: "+palindrome;
        /* to be redefined in part (a) */
    }

    /**
    *  Precondition:   str is not null
    *  Postcondition:  returns true if str is a palindrome, and false otherwise
    */
    private boolean isPalindrome()
    {
        String reversedWord = "";
        char[] rev = new char[str.length()];
        int count = 0;

        for(int i = str.length()-1; i >= 0; i--) {
            //System.out.print(i+": ");
            //System.out.println(str.charAt(i));
            rev[count] = str.charAt(i);
            count++;
        }
        //System.out.println("\n'"+new String(rev)+"'\n");

        reversedWord = new String(rev);
        reversedWord = reversedWord.toLowerCase();

        return str.toLowerCase().equals(reversedWord);
        /* to be implemented in part (b) */
    }

}
