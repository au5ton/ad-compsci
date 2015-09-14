public class stringQuizReview
{
   
   //left2
   public static String left2(String str)
   {
      return str.substring(2)+str.substring(0,2);
   }

   //withoutEnd
   public static String withoutEnd(String str) 
   {
      if(str.length() >=3) {
         return str.substring(1,str.length()-1);
      }
      return str;
   }

   //withoutX
   public static String withoutX(String str) 
   {
      if(str.length() < 3) {
         return str;
      }
      if(str.toLowerCase().charAt(0) == 'x') {
         str = str.substring(1);
      }
      if(str.toLowerCase().charAt(str.length()-1) == 'x') {
         str = str.substring(0,str.length()-1);
      }
   
      return str;
   }
   
   //hasBad
   public static boolean hasBad(String str) 
   {
      return true;
   }
   
   //minCat
   public static String minCat(String a, String b) 
   {
      return null;
   }

   //countHi
   public static int countHi(String str) 
   {
      return 0;
   }
   
   //repeatFront
   public String repeatFront(String str, int n) 
   {
      return null;
   }


   
   public static void main (String[] args)
   {
      ////****left2 METHOD CALLS****/////
      /*
      System.out.println(left2("Hello"));//lloHe
      System.out.println(left2("java"));//vaja
      System.out.println(left2("Hi"));//Hi
      System.out.println(left2("code"));//deco
      System.out.println(left2("cat"));//tca
      System.out.println(left2("12345"));//34512
      System.out.println(left2("Chocolate"));//ocolateCh
      System.out.println(left2("bricks"));//icksbr
      */
      
      ////****withoutEnd METHOD CALLS****/////
      /*
      System.out.println(withoutEnd("Hello"));//ell
      System.out.println(withoutEnd("java"));//av
      System.out.println(withoutEnd("coding"));//odin
      System.out.println(withoutEnd("code"));//od
      System.out.println(withoutEnd("ab"));//*empty string*
      System.out.println(withoutEnd("Chocolate!"));//hocolate
      System.out.println(withoutEnd("kitten"));//itte
      System.out.println(withoutEnd("woohoo"));//ooho
      */
      

      ////****withoutX METHOD CALLS****/////
      
      System.out.println(withoutX("xHix"));//Hi
      System.out.println(withoutX("xHi"));//Hi
      System.out.println(withoutX("Hxix"));//Hxi
      System.out.println(withoutX("xxHi"));//xHi
      System.out.println(withoutX("Hix"));//Hi
      System.out.println(withoutX("xaxbx"));//axb
      System.out.println(withoutX("Hello"));//Hello
      System.out.println(withoutX("Hexllo"));//Hexllo
      
      
      ////****hasBad METHOD CALLS****/////
      /*
      System.out.println(hasBad("badxx"));//true 
      System.out.println(hasBad("xbadxx"));//true 
      System.out.println(hasBad("xxbadxx"));//false
      System.out.println(hasBad("code"));//false   
      System.out.println(hasBad("bad"));//true
      System.out.println(hasBad("ba"));//false
      System.out.println(hasBad("xba"));//false
      System.out.println(hasBad("xbad"));//true
      System.out.println(hasBad(""));//false
      System.out.println(hasBad("badyy"));//true
      */
      
       ////****minCat METHOD CALLS****/////
      /*
      System.out.println(minCat("Hello", "Hi"));//loHi
      System.out.println(minCat("Hello", "java"));//ellojava
      System.out.println(minCat("java", "Hello"));//javaello
      System.out.println(minCat("abc", "x"));//cx
      System.out.println(minCat("abc", ""));//*empty String*
      */
      
      ////****countHi METHOD CALLS****/////
      /*
      System.out.println(countHi("abc hi ho"));//1
      System.out.println(countHi("ABChi hi"));//2
      System.out.println(countHi("hihi"));//2
      System.out.println(countHi("hiHIhi"));//2
      System.out.println(countHi("hi"));//1
      System.out.println(countHi("Hi si no HI on ahI"));//0
      System.out.println(countHi("hiho not HOHIhi"));//2
      */

      ////****repeatFront METHOD CALLS****/////
      /*
      System.out.println(repeatFront("Chocolate", 4));//ChocChoChC
      System.out.println(repeatFront("Chocolate", 3));//ChoChC
      System.out.println(repeatFront("Ice Cream", 2));//IcI
      System.out.println(repeatFront("Ice Cream", 1));//I
      System.out.println(repeatFront("Ice Cream", 0));//*empty String*
      */      

   }
    
}