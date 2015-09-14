//Copy the code you wrote for your quiz and paste it in the appropriate methods below.
//Continue working on the methods that don't work. Use the runner to evaluate your code. 
//When you have finished copy and paste this entire class into the TEXT FIELD in the HUB.

public class stringMethodsQuiz
{

   /*makeOutWord
   Given an "out" string length 4, such as "<<>>", and a word, 
   return a new string where the word is in the middle of the out string.
   
   makeOutWord("<<>>", "Yay") --> "<<Yay>>"
   makeOutWord("<<>>", "WooHoo") --> "<<WooHoo>>"
   makeOutWord("[[]]", "word") --> "[[word]]"
   */
   public static String makeOutWord(String out, String word)
   {
      return out.substring(0,2)+word+out.substring(2);
   }
 
    /*endsLy
   Given a string, return true if it ends in "ly". 
   The given string could be empty. 
   
   endsLy("oddly") --> true
   endsLy("y") --> false
   endsLy("oddy") --> false
   endsLy("") --> false
   */
   public static boolean endsLy(String str)
   {
      if(str.length() > 2) {
         return str.substring(str.length()-2).equals("ly");
      }
      return false;
   }
 
   
   /*conCat
   Given two strings, append them together (known as "concatenation") 
   and return the result. However, if the concatenation creates a double-char, 
   then omit one of the chars, so "abc" and "cat" yields "abcat". Either String 
   could be empty.
   conCat("abc", "cat") --> "abcat"
   conCat("dog", "cat") --> "dogcat"
   conCat("abc", "") --> "abc"
   */
   public static String conCat(String a, String b)
   {
      if(a.isEmpty()) {
         return b;
      }
      if(b.isEmpty()) {
         return a;
      }
      if(a.charAt(a.length()-1)==b.charAt(0)) {
         b = b.substring(1);
      }
      return a+b;
   }
 
   /*catDog
   Return true if the string "cat" and "dog" appear the same number of times in the given string. 
   The given string may be empty.  
   
   catDog("catdog") --> true
   catDog("catcat")--> false
   catDog("1cat1cadodog") --> true
   catDog("ca") --> true
   */
   public static boolean catDog(String str)
   {
      String cat = "cat";
      String dog = "dog";
      int catCount = 0;
      int dogCount = 0;
      int tempIndex = 0;
      int index = 0;
      while(str.indexOf("cat") != -1 || str.indexOf("dog") != -1) {
         if(str.indexOf("cat") != -1) {
            tempIndex = str.indexOf("cat");
            catCount++;
            str = str.substring(0,tempIndex)+str.substring(tempIndex+cat.length()-1); //remove the found cat from the string
         }
         if(str.indexOf("dog") != -1) {
            tempIndex = str.indexOf("dog");
            dogCount++;
            str = str.substring(0,tempIndex)+str.substring(tempIndex+dog.length()-1); //remove the found dog from the string
         }
      }
      return (catCount == dogCount);
   
   }
 
 
   /*repeatEnd
   Given a string and an int N, return a string made of 
   N repetitions of the last N characters of the string. 
   You may assume that N is between 0 and the length of the string,  inclusive.
   The given string may be empty.  
   repeatEnd("Hello", 3) --> "llollollo"
   repeatEnd("Hello", 2) --> "lolo"
   repeatEnd("Hello", 1) --> "o"
   */
   public static String repeatEnd(String str, int n)
   {
      String result = "";
      String lastChars = str.substring(str.length()-n);
      for(int i = 0; i < n; i++) {
         result += lastChars;
      }
      return result;
   }  
}