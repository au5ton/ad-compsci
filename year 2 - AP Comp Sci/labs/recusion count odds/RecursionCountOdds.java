public class RecursionCountOdds
{
   public static int countOddDigits(int num)
   {
      if(num > 0) {
         //If the last digit is odd
         if((num % 10) % 2 == 1) {
            return 1 + countOddDigits(num / 10);
         }
         else {
            return countOddDigits(num / 10);
         }
      }
      return 0;
   }
}