import java.util.*;

public class PigLatinConverterList
{
    private String myLine;

    public PigLatinConverterList(String str)
    {
        myLine = str;
        pigLatin();
    }

    /**
    *Precondition: ch may be an upper or lower-case alphabetic character
    *Parameter - ch a single-character string
    *Return - true if ch is a vowel, false otherwise
    */
    public boolean isVowel(String ch)
    {
        /* should have been implemented in part (a) of original PigLatinConverter Lab; copy it over */

        if(ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")){
            return	true;
        }
        return	false;

    }

    /**
    *Precondition: word is not null and may begin with a vowel
    *              or consonant. You may use isVowel from part a.
    *Parameter � word, the word to be converted to Pig Latin
    *Return - the Pig Latin form of word
    */
    public String toPig(String word)
    {
        /* should have been implemented in part (b) of original PigLatinConverter Lab; copy it over */

        if(isVowel(Character.toString(word.charAt(0)))){
            //first letter	is	a vowel
            return word+"yay";
        }
        else {
            //first letter	is	a consonant
            return	word.substring(1,word.length())+Character.toString(word.charAt(0))+"ay";
        }

    }

    /**	Private helper method
    * Precondition:	myLine contains at least one word.
    *			Words are separated by exactly one space.
    *			There is no punctuation in myLine.
    * Postcondition:	myLine is unchanged.
    * @return a list of words in myLine
    */
    private ArrayList<String> getLineWords()
    {
        /* to be implemented in part (a) */
        String[] wordsInLine = myLine.split(" ");
        return new ArrayList<String>(Arrays.asList(wordsInLine));
    }

    /**
    * Mutator method
    * Precondition:	myLine contains at least one word.
    *			Words are separated by exactly one space.
    *			There is no punctuation in myLine.
    * Postcondition:	myLine has been converted to Pig Latin.
    *			The Pig Latin words are separated by one space.
    */
    public void pigLatin()
    {

        /* to be implemented in part (b) */
        ArrayList<String> list = getLineWords();
        myLine = "";
        for(int i = 0; i < list.size(); i++) {
            myLine += toPig(list.get(i))+" ";
        }
    }

    public String toString()
    {
        return myLine;
    }


}
