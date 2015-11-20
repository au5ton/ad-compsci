import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import static java.lang.System.*;

class InsertionSort
{
    private ArrayList<String> list;

    public InsertionSort(){
        list = new ArrayList<String>();
    }

    //modfiers
    public void add( String  word)
    {
        if(list.indexOf(word) == -1) {
            list.add(findInsertLocation(word), word);
        }
    }

    private int findInsertLocation( String word )
    {
        for(int i = 0; i < list.size(); i++) {
            //If word comes before list.get(i) alphabetically, return the index

            //For a really awesome tutorial on how String.compareTo() works, check this out:
            // https://gist.github.com/au5ton/a990176c70560eeba765
            // It'll really help you, it's practically a cheatsheet

            if(word.compareToIgnoreCase(list.get(i)) < 0) {
                return i;
            }
        }
        return list.size();
    }

    public void remove(String word)
    {
        list.remove(word);
    }

    public String toString()
    {
        return list.toString();
    }
}
