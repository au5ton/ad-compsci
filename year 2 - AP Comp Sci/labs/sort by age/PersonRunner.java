import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class PersonRunner
{
	public static void main ( String[] args ) throws IOException
	{
	   ArrayList<Person> myPeople = new ArrayList<Person>();

		Scanner file = new Scanner(new File("person.dat"));

		int num = file.nextInt();
		file.nextLine();
		for(int i=0; i<num;i++)
		{
			int y = file.nextInt();
			int m = file.nextInt();
			int d = file.nextInt();
			String sent = file.next();
			file.nextLine();
			myPeople.add(new Person(y, m, d, sent));
		}
		Collections.sort(myPeople);

		for(Person item : myPeople)
		{
			out.println(item);
		}
	}
}