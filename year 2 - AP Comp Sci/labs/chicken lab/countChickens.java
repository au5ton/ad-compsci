public class countChickens
{
	public static int countChickens(String word)
	{

      if(word.contains("chicken")) {
         if(word.indexOf("chicken") > 0) {
            return 1 + countChickens(
            word.substring(0,word.indexOf("chicken")) + word.substring(word.indexOf("chicken") + "chicken".length())
            );
         }
         return 1 + countChickens(word.substring("chicken".length()));
      }
		return 0;
	}
}