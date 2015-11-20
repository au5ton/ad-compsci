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
