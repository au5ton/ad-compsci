public class recursivePalindrome
{
   private static int start, end;
    
   public static boolean isPalindrome(String str/*, int start, int end*/)
   {
      //recursively check if str is a palindrome
      str = removeBlanks(str);
      str = str.toLowerCase();
      if(str.charAt(0) == str.charAt(str.length()-1)) {
         if(str.length() != 1) {
            return (true && isPalindrome(str.substring(1,str.length()-1)));
         }
         else {
            return true;
         }
      }
      return false;
   }
   
   
   public static String removeBlanks(String str)
   {
      //recursively remove the spaces in str
      if(str.indexOf(' ') != -1){
         return str.substring(0,str.indexOf(' ')) + removeBlanks(str.substring(str.indexOf(' ')+1));
      }
      return str;
   }
   
   
   public static void main (String[] args)
   {
     String[] arr = new String[] {"racecar", "A santa lived as a devil at NASA", "hello world"};
     for(String word: arr)
     {
      start  =0;
      end = word.length()-1;
      System.out.println(isPalindrome(word));

     }
   }
}