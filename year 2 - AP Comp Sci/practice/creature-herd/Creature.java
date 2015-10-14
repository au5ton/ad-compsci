public class Creature implements Comparable
{
	private int size;

   /*Complete the default constructor method*/
	public Creature() 
   {
      size = 0;
	}
   
   /*Complete the constructor method*/
	public Creature(int girth) 
   {
      setSize(girth);
	}
   
   /*Complete the set method*/
	public void setSize(int girth)
	{
		size = girth;
	}

	/*
	 * method isBig should return true if size > 75
	 * method isBig should return false if size <= 75
	*/
	public boolean isBig()
	{
		//change the return to match the comments above
		return (size > 75);
	}
   
   /*
	 * method equals compares the sizes of the current Creature to obj
	 * returns true if the sizes are equal and false otherwise
	*/

	public boolean equals(Object obj)
	{
		//change the return to match the comments above
		return (Integer.parseInt(obj.toString()) == size);
	}

	public int compareTo(Object obj)
	{
		//change the return to match the comments above
      return (size-Integer.parseInt(obj.toString()));
	}
   
   /*Complete the toString method
     return the size of the Creature*/
	public String toString() {
		//change the return to match the comments above
      return Integer.toString(size);
	}
}