import java.util.ArrayList;
import static java.lang.System.*;

public class RemoveAll
{
	public static void main(String args[])
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();

		ray.add("all");
		ray.add("all");
		ray.add("fun");
		ray.add("dog");
		ray.add("bat");
		ray.add("cat");
		ray.add("all");
		ray.add("dog");
		ray.add("all");
		ray.add("all");
		//out.println(ray);
		//out.println(ray.size());

		//add in a loop to remove all occurrences of all
		/*out.println("Removing all occurrences of \'all\'");
		out.println("all exists: "+ray.remove("all"));
		int spot = ray.size()-1;
		while(spot >= 0) {
		//out.println(ray);
		//out.println(spot);
		if(ray.get(spot).equals("all")) {
		out.println("index "+spot+" in array is \'all\', removing: "+ray.get(spot));
		ray.remove(spot);
	}
	spot--;
}*/

out.println(ray);
while(ray.remove("all")) {}
	out.println(ray);

	//out.println("all exists: "+ray.remove("all"));

	//out.println(ray);
	//out.println(ray.size());

}
}
