public class booleanLogic
{


   //cigarParty
   public static boolean cigarParty(int cigars, boolean isWeekend) 
   {
      return (isWeekend && cigars >= 40) || (cigars >= 40 && cigars <= 60);
   }
   
   //caughtSpeeding
   public static int caughtSpeeding(int speed, boolean isBirthday) 
   {
      if(isBirthday)
         speed -= 5;
      if(speed <= 60)
         return 0;
      if(speed > 60 && speed <= 80)
         return 1;
      return 2;
   }
   
   //dateFashion
   public static int dateFashion(int you, int date)  
   {
   
      if(you <= 2 || date <= 2)
         return 0;
      if(you >= 8 || date >= 8)
         return 2;
      return 1;
   }

   //loneSum
   public static int loneSum(int a, int b, int c) 
   {
      if(a == b)
         return c;
      if(a == c)
         return b;
      if(b == c)
         return a;
      
      return a+b+c;
   }

   public static int round10(int num) {
      if(num % 10 >= 5)
         return (int)Math.floor((double)num / 10.0) * 10;
      return (int)Math.ceil((double)num / 10.0) * 10;
   }

   //roundSum
   public static int roundSum(int a, int b, int c)
   {
      return round10(a)+round10(b)+round10(c);
   }

   //evenlySpaced
   public static boolean evenlySpaced(int a, int b, int c)
   {
   
      int large = Math.max(a,b);
      large = Math.max(large,c);
      
      int small = Math.min(a,b);
      small = Math.min(small,c);
      
      if(a < large && a > small) {
         return (large - a == a - small);
      }
      else if(b < large && b > small) {
         return (large - b == b - small);
      }
      else if(c < large && c > small) {
      return (large - c == c - small);
      }
      else {
         return false;
      }
   }
        
     
   public static void main (String[] args)
   {
      ////****cigarParty METHOD CALLS****/////
      /*
      System.out.println(cigarParty(30,false));//false
      System.out.println(cigarParty(50,false));//true
      System.out.println(cigarParty(70,true));//true
      System.out.println(cigarParty(30,true));//false
      System.out.println(cigarParty(50,true));//true
      System.out.println(cigarParty(60,false));//true
      System.out.println(cigarParty(61,false));//false


      ////****caughtSpeeding METHOD CALLS****/////
      /*
      System.out.println(caughtSpeeding(60, false));//0
      System.out.println(caughtSpeeding(65, false));//1
      System.out.println(caughtSpeeding(65, true));//0
      System.out.println(caughtSpeeding(80, false));//1
      System.out.println(caughtSpeeding(85, false));//2
      System.out.println(caughtSpeeding(85, true));//1
      System.out.println(caughtSpeeding(70, false));//1
      System.out.println(caughtSpeeding(75, false));//1
      System.out.println(caughtSpeeding(75, true));//1


      */

      ////****dateFashion METHOD CALLS****/////
      /*
      System.out.println(dateFashion(5,10));//2
      System.out.println(dateFashion(5,2));//0
      System.out.println(dateFashion(5,5));//1
      System.out.println(dateFashion(3,3));//1
      System.out.println(dateFashion(10,2));//0
      System.out.println(dateFashion(2,9));//0
      System.out.println(dateFashion(9,0));//2
      System.out.println(dateFashion(10,5));//2
      */
   	    
      
      ////****loneSum METHOD CALLS****/////
      /*
      System.out.println(loneSum(1, 2, 3));//6 
      System.out.println(loneSum(3, 2, 3));//2 
      System.out.println(loneSum(3, 3, 3));//0
      System.out.println(loneSum(9, 2, 2));//9
      System.out.println(loneSum(2, 2, 9));//9
      System.out.println(loneSum(2, 9, 2));//9
      System.out.println(loneSum(2, 9, 3));//14   
      */

       ////****roundSum METHOD CALLS****/////
      /*
      System.out.println(roundSum(16, 17, 18));//60
      System.out.println(roundSum(12, 13, 14));//30
      System.out.println(roundSum(6, 4, 4));//10
      System.out.println(roundSum(4, 6, 5));//20
      System.out.println(roundSum(4, 4, 6));//10
      System.out.println(roundSum(9, 4, 4));//10
      System.out.println(roundSum(0, 0, 1));//0
      System.out.println(roundSum(10, 10, 19));//40
      System.out.println(roundSum(20, 30, 40));//90
      System.out.println(roundSum(16, 17, 18));//60
      */
	    
      ////****evenlySpaced METHOD CALLS****/////
      /*
      System.out.println(evenlySpaced(2, 4, 6));//true
      System.out.println(evenlySpaced(4, 6 ,2));//true
      System.out.println(evenlySpaced(4, 6, 3));//false
      System.out.println(evenlySpaced(6, 2, 4));//true
      System.out.println(evenlySpaced(6, 2, 8));//false
      System.out.println(evenlySpaced(9, 10, 11));//true
      System.out.println(evenlySpaced(10, 9, 9));//false
      */        

   }
    
}