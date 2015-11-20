import java.util.*;
import static java.lang.System.*;

public class Words
{
	private ArrayList<Word> words;

	/*Complete the default constructor method*/
	public Words()
	{
		words = new ArrayList<Word>();
	}

	/*Complete the constructor method*/
	public Words(String wordList)
	{
		words = new ArrayList<Word>();
		setWords(wordList);
	}

	/*setWords should initialize the appropriate instance variable*/
	public void setWords(String wordList)
	{
		words.clear();
		String[] wordRay = wordList.split(" ");
		for(String wordStr : wordRay) {
			words.add(new Word(wordStr));
		}
	}

	/*countWordsWithXChars should return the number of words in the list that contain size characters*/
	public int countWordsWithXChars(int size)
	{
		int count=0;

		for(Word word : words) {
			if(word.getLength() == size) {
				count++;
			}
		}

		return count;
	}

	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{
		int sum = 0;

		ArrayList<Word> removed = new ArrayList<Word>();

		int spot = words.size()-1;
		while(spot >= 0) {
			if(words.get(spot).getLength() == size) {
				removed.add(words.get(spot));
				words.remove(spot);
			}
			spot--;
		}

		for(Word word : removed) {
			sum += word.getNumVowels();
		}

		//System.out.println(removed);

		return sum;
	}

	/*countWordsWithXVowels should return the number of words in the list that contain numVowels vowels*/
	public int countWordsWithXVowels(int numVowels)
	{
		int count=0;
		for(Word word: words) {
			if(word.getNumVowels() == numVowels) {
				//System.out.println("    "+word+" has "+numVowels+" vowels");
				count++;
			}
			else {
				//System.out.println("    "+word+" doesn\'t have "+numVowels+" vowels");
			}
		}
		return count;
	}

	/*toString will print out the list*/
	public String toString()
	{
		return words.toString();
	}
}
