import static java.lang.System.*;

public class Person implements Comparable<Person>
{
   private int myYear;
   private int myMonth;
   private int myDay;
   private String myName;

   public Person( int y, int m, int d, String n)
   {
      myYear = y;
      myMonth = m;
      myDay = d;
      myName = n;
   }

   public int compareTo( Person other )
   {
      
      if(this.myYear > other.myYear) {
         return -1;
      }
      else if(this.myYear < other.myYear) {
         return 1;
      }
      else {
         if(this.myMonth > other.myMonth) {
            return -1;
         }
         else if(this.myMonth < other.myMonth) {
            return 1;
         }
         else {
            if(this.myDay > other.myDay) {
               return -1;
            }
            else if(this.myDay < other.myDay) {
               return 1;
            }
            else {
               if(this.myName.compareTo(other.myName) > 0) {
                  return -1;
               }
               else if(this.myName.compareTo(other.myName) < 0) {
                  return 1;
               }
               else {
                  return 0;
               }
            }
         }
      }
      
      //return 0;
   }

   public String toString( )
   {
      return myName;
   }
}