import java.util.Arrays;

public class AtCounter
{
   private String[][] atMat;

   public AtCounter(int rows, int cols)
   {
   	//size the matrix
      atMat = new String[rows][cols];
      //use nested loops to randomly load the matrix
      for(int r = 0; r < atMat.length; r++) {
         for(int c = 0; c < atMat[r].length; c++) {
            if(Math.random() > 0.50) {
               atMat[r][c] = "@";
            }
            else {
               atMat[r][c] = "-";
            }
         }
      }
      //you will need to use Math.random()
   }

   public int countAts(int r, int c)
   {
      /*
        if ( r and c are in bounds and current spot is a @ )
     mark spot as visited
     bump up current count by one
     4 recursive calls up down left right
      */  
      if(r > 0 && r < atMat.length && c > 0 && c < atMat[r].length && atMat[r][c].equals("@")) {
         atMat[r][c] = "-";
         return 1 + countAts(r+1,c) + countAts(r-1,c) + countAts(r,c+1) + countAts(r,c-1);
      }
      return 0; 
   }
       
	/*
	 *this method will return all values in the matrix
	 *this method should return a view of the matrix
	 *that looks like a matrix
	 */
   public String toString()
   {
      String result = "";
      for(String[] row : atMat) {
         result += (Arrays.toString(row)+"\n");
      }
      return result;
   }
}