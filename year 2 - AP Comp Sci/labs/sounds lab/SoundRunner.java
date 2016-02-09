import java.util.*;

public class SoundRunner
{
    public static void main(String[] args)
    {
        int[] vals = {0, 0, 0, 0, 0, 0, 0, 40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223};
        Sound fun = new Sound( vals );
        System.out.println( fun );     		//outs  0 0 0 0 0 0 0 40 2532 17 -2300 -17 -4000 2000 1048 -420 33 15 -32 2030 3223

        int count = fun.limitAmplitude(2000);
        System.out.println( count );		//outs 5

        fun.trimSilenceFromBeginning();
        System.out.println( fun ); 			//outs   40 2000 17 -2000 -17 -2000 2000 1048 -420 33 15 -32 2000 2000
    }
}
