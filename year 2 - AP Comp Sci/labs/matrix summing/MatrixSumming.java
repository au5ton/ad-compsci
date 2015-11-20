public class MatrixSumming
{   
    //load in the matrix values
    private int[][] m = {{1, 2, 3, 4, 5},
                         {6, 7, 8, 9, 0},
                         {6, 7, 1, 2, 5},
                         {6, 7, 8, 9, 0},
                         {5, 4, 3, 2, 1}}; 
    private int row;
    private int col;  
    
    
    //Complete the default constructor method
    public MatrixSumming()
    {
      row = 0;
      col = 0;
    }
    
    //Complete the constructor method
    public MatrixSumming(int r, int c)
    {
      row = r;
      col = c;
    }
  
    //Complete the sum method
    //Think about how your current position in the matrix relates to the surrounding positions
    public int sum( int r, int c )
    {
    	int sum = 0;
      int[] surround = {1,0,-1};
      for(int rr: surround)   // add/subtract from row index
      {
         for (int cc: surround)  // add/subtract from col index
         {
            if(r+rr <m.length && c+cc < m[r].length && r+rr > -1 && c+cc > -1)   //checking bounderies
            {
               sum += m[r+rr][c+cc];
            }
         }
      }
      
      return sum;

    }
    
    //Complete the code to print out the matrix
    public void printMat()
    {
    System.out.println("matrix values: ");
    for(int[] row : m)
    {
      for (int num : row)
      {
         System.out.print(num + " ");
      }
      System.out.println();
    }

    } 
		    
    //Complete the toStrng method
    public String toString()
    {
      return "The sum of " + row + ", " + col +" equals " +sum(row,col);
    }

}
