public class PigLatinConverter
{
/**
*Precondition:	ch	may be an upper or lower-case	alphabetic character
*Parameter - ch a	single-character string
*Return - true	if	ch	is	a vowel,	false	otherwise
*/
	public boolean	isVowel(String	ch)
	{ 
	  /* to be implemented in part (a) */
	  
	  if(ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")){
	  return	true;
	  }
	  return	false;
	  
	}

/**
*Precondition:	word is not	null and	may begin with	a vowel 
*					or	consonant. You	may use isVowel from	part a.
*Parameter – word, the word to be converted to Pig	Latin
*Return - the Pig	Latin	form of word
*/
	public String toPig(String	word)
	{ 
		/*	to	be	implemented	in	part (b)	*/
		
		if(isVowel(Character.toString(word.charAt(0)))){
			//first letter	is	a vowel
			return word+"yay";
		}
		else {
			//first letter	is	a consonant
			  return	word.substring(1,word.length())+Character.toString(word.charAt(0))+"ay";
		}
		
	}

/**
	* Precondition:	myLine contains at least one word.
	*			Words	are separated by exactly one space.
	*			There	is	no	punctuation	in	myLine.
	*			You may use	toPig	from part b.
* Postcondition: myLine	has been	converted to Pig Latin.
		*			 Words are separated	by	one space.
* Return	– a string that contains the converted	words	

*/
	public String convertLine(String	myLine)
	{
      String[] wordsInLine = myLine.split(" ");
      String[] converted = new String[wordsInLine.length];
      String result = "";
      for(int i = 0; i < wordsInLine.length; i++) {
         converted[i] = toPig(wordsInLine[i]);
      }
      for(int i = 0; i < converted.length; i++) {
         result += (converted[i] + " ");
      }
      
      return result;
	}
	
	
}

