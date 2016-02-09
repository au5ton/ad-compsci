public class triangle
{
   
  public static int triangle(int rows) 
  {
   if(rows > 0)
         return rows + triangle(--rows);
     return 0;
  }

   public static void main (String[] args)
   {
     System.out.println(triangle(0));//0
     System.out.println(triangle(1));//1 
     System.out.println(triangle(2));//3
     System.out.println(triangle(3));//6 
     System.out.println(triangle(4));//10
     System.out.println(triangle(5));//15
     System.out.println(triangle(6));//21
     System.out.println(triangle(7));//28
       
   }
}
    
