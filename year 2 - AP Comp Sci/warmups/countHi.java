public class countHi
{
   
  public static int countHi(String a) 
  {
   if(a.indexOf("hi") != -1)
         return 1 + countHi(a.substring(a.indexOf("hi")+"hi".length()));
     return 0;

  }

   public static void main (String[] args)
   {
     System.out.println(countHi("xxhixx"));//1
     System.out.println(countHi("xhixhix"));//2
     System.out.println(countHi("hi"));//1
     System.out.println(countHi("h"));//0 
     System.out.println(countHi(""));//0
     System.out.println(countHi("hihih"));//2
     System.out.println(countHi("ihihihihih"));//4  
       
   }
}
    
 