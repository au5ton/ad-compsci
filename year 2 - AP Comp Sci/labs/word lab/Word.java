/***PART 1***/
/*This part of the lab is designed to review classes, objects, and methods*/
/*It does not require ArrayLists*/
public class Word
{
	private String word;
   private static String vowels = "AEIOUaeiou";   

	/*complete the default constructor method*/
   public Word()
	{
      word = "";
	}

   /*complete the constructor method*/
	public Word(String wrd)
	{
      word = wrd;
	}

   /*setWord should initialize the appropriate instane variable*/
	public void setWord(String wrd)
	{
      word = wrd;
	}
	
   /*getNumVowels returns the number of vowels in the word*/
   /*HINT: Check to see if each char in the word is contained with in the vowels string.*/
	public int getNumVowels()
	{
		int count=0;
      for(int i = 0; i < vowels.length(); i++) {
         //Loops through String to check every thing that constitutes as a vowel
         for(int j = 0; j < word.length(); j++) {
            //Checks the entire string for current vowel
            if(word.charAt(j) == vowels.charAt(i)) {
               count++;
            }
         }
      }
	}
	
	/*getLength returns the length of the word*/
   public int getLength()
	{
		return word.length();
	}

	/*toString will return the word*/
   public String toString()
	{
	   return word;
	}
}