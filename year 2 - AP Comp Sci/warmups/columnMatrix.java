public class columnMatrix
{
   private static int[][] mat = {{12,5,7,90,3},{45,6,23,1,9},{89,34,7,10,2},{8,3,78,35,28},{89,34,7,0,2}};
  
   public static int columnMatrix(int row, int col)
   {
          if(row < mat.length && row >= 0 && col < mat[row].length && col >= 0 && mat[row][col] != 0) {
            int place = mat[row][col];
            mat[row][col] = 0;
            return place + columnMatrix(row+1,col) + columnMatrix(row-1,col);
          }
          return 0;
   }
   
   public static void main (String[] args)
  {
     //run each line independently
     //System.out.println(columnMatrix(4,4));//44
     //System.out.println(columnMatrix(2,2)); //122
     //System.out.println(columnMatrix(3,2));//122
     //System.out.println(columnMatrix(0,3));//136
     //System.out.println(columnMatrix(-9,4)); //0
     //System.out.println(columnMatrix(9,4));//0
      
  }
}