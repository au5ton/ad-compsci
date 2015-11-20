import java.util.*;

public class SkyViewRunner 
{
    public static void main(String[] args) 
    {
    		double[] list = {.3,.7,.8,.4,1.4,1.1,.2,.5,.1,1.6,.6,.9};
        SkyView sv = new SkyView(4,3,list);
        System.out.println( sv );
        System.out.println( sv.getAverage(1,2,0,1) );
        System.out.println( sv.getAverage(0,3,0,2) );
        System.out.println( sv.getAverage(0,1,0,1) );
        System.out.println();
        
        list = new double[]{.3,.7,.8,.4,1.4,1.1};
        sv = new SkyView(3,2,list);
        System.out.println( sv );
        
        /* - expected output
          0.3 0.7 0.8
					1.1 1.4 0.4
					0.2 0.5 0.1
					0.9 0.6 1.6
					
					0.8
					0.7166666666666668
					0.875
					
					0.3 0.7
					0.4 0.8
					1.4 1.1	
					*/
    }
}
