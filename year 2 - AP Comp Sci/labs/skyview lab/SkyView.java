
/**
 * Write a description of class SkyView here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkyView
{
    // instance variables - replace the example below with your own
    private double[][] view;

    /**
     * Constructor for objects of class SkyView
     */
    public SkyView(int numRows, int numCols, double[] scanned)
    {
        view = new double[numRows][numCols];
        int n = 0;
        for(int r = 0; r < view.length; r++) {
            if(r % 2 == 0) {
                for(int c = 0; c < view[c].length; c++) {
                    view[r][c] = scanned[n];
                    n++;
                }
            }
            else {
                for(int c = view[r].length-1; c >= 0; c--) {
                    view[r][c] = scanned[n];
                    n++;
                }
            }
        }
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol) {
        double sum = 0.0;
        double count = 0.0;
        for(int r = startRow; r <= endRow; r++) {
            for(int c = startCol; c <= endCol; c++) {
                sum += view[r][c];
                count++;
            }
        }
        return sum / count;
    }
    
    public String toString() {
      
      String result = "";
    
      for(int r = 0; r < view.length; r++) {
         for(int c = 0; c < view[r].length; c++) {
            result += view[r][c]+" ";
         }
         result += "\n";
      }
      return result;
    }
}
