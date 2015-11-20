import java.util.Arrays;

public class MatrixSumming
{   
   //load in the matrix values
   private int[][] m = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {6, 7, 1, 2, 5}, {6, 7, 8, 9, 0}, {5, 4, 3, 2, 1} };; 
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
      try {
         sum += m[r][c];
      }
      catch(Exception e) {}
      try {
         sum += m[r+1][c];
      }
      catch(Exception e) {}
      try {
         sum += m[r+1][c-1];
      }
      catch(Exception e) {}
      try {
         sum += m[r+1][c+1];
      }
      catch(Exception e) {}
      try {
         sum += m[r-1][c];
      }
      catch(Exception e) {}
      try {
         sum += m[r-1][c-1];
      }
      catch(Exception e) {}
      try {
         sum += m[r-1][c+1];
      }
      catch(Exception e) {}
      try {
         sum += m[r][c+1];
      }
      catch(Exception e) {}
      try {
         sum += m[r][c-1];
      }
      catch(Exception e) {}
      return sum;
   }
   
   //Complete the code to print out the matrix
   public void printMat()
   {
      /*String[] arr = new String[m.length];
      for(int i = 0; i < m.length; i++) {
         arr[i] = Arrays.toString(m[i]);
      }
      System.out.println(Arrays.toString(arr));*/
      
      
      
      for(int[] row : m) {
         for(int col : row) {
            System.out.print(col+" ");
         }
         System.out.println();
      }
      
   } 
	    
   //Complete the toStrng method
   public String toString()
   {
      return "The sum of "+row+","+col+" is "+sum(row,col); //The sum of 2,2 is 58.
   }

}
