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
      setWord("");
	}

   /*complete the constructor method*/
	public Word(String wrd)
	{
      setWord(wrd);
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
      
      for(int i = 0; i < word.length(); i++) {
         //Checks the entire string for current vowel
         if(isVowel(word.charAt(i))) {
            count++;
         }
      }
      
      return count;
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
   
   public boolean isVowel(String ch)
   { 
     return (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u"));
   }
   public boolean isVowel(char ch)
   { 
     return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
   }
}