public class WordRunner
{
	public static void main(String[] args)
	{
      /*Look at the instructions (Word document) to see what the expected output should look like and make it happen.*/
      /*HINT: You only need to make ONE object*/
      
      Word word = new Word("hello world");
      System.out.println(word);
      System.out.println("num of vowels == "+word.getNumVowels());
      System.out.println("num of chars == "+word.getLength());
      
      word.setWord("chicken");
      System.out.println(word);
      System.out.println("num of vowels == "+word.getNumVowels());
      System.out.println("num of chars == "+word.getLength());
      
      word.setWord("alligator");
      System.out.println(word);
      System.out.println("num of vowels == "+word.getNumVowels());
      System.out.println("num of chars == "+word.getLength());
      
      word.setWord("elephant");
      System.out.println(word);
      System.out.println("num of vowels == "+word.getNumVowels());
      System.out.println("num of chars == "+word.getLength()); 
      
  	}
}