public class allStar
{

   public static String allStar(String str) 
   {
      if(str.length() > 1) {
         return str.charAt(0) + "*" + allStar(str.substring(1));
      }
      return str;
   }
   
   public static void main (String[] args)
   {
      System.out.println( allStar("hello"));// "h*e*l*l*o"	    
      System.out.println(allStar("abc"));// "a*b*c"		    
      System.out.println(allStar("ab"));// "a*b"		    
      System.out.println(allStar("a") );// "a"		    
      System.out.println(allStar("") );// ""	    
      System.out.println(allStar("3.14"));// "3*.*1*4"  
      System.out.println(allStar("Chocolate"));// "C*h*o*c*o*l*a*t*e"	 
      System.out.println(allStar("1234") );// "1*2*3*4"
   }
}


            
