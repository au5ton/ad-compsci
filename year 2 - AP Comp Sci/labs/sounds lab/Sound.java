public class Sound
{
	/** the array of values in this sound; guaranteed not to be  null */
	private int[] samples;

	//Complete the constructor method
	public Sound( int[] vals )
	{
		samples = vals;
	}


	/** Changes those values in this sound that have an amplitude greater than  limit.
	*	Values greater than  limit are changed to  limit.
	*	Values less than  -limit are changed to  -limit.
	*	@param limit the amplitude limit
	*	Precondition:  limit =  0
	*	@return the number of values in this sound that this method changed  */
	//PART A
	public int limitAmplitude(int limit)
	{
		int count = 0;
		for(int i = 0; i < samples.length; i++) {
			if(samples[i] > 0) {
				if(samples[i] > limit) {
					samples[i] = limit;
					count++;
				}
			}
			else if(samples [i] < 0) {
				if(samples[i] < (-limit)) {
					samples[i] = (-limit);
					count++;
				}
			}
		}
		return count;
	}



	/** Removes all silence from the beginning of this sound.
	*	Silence is represented by a value of 0.
	*	Precondition:  samples contains at least one nonzero value
	*	Postcondition: the length of  samples reflects the removal of starting silence  */
	//PART B
	public void trimSilenceFromBeginning()
	{

		int indexOffset = 0;
		boolean endOfSilence = false;
		int i = 0;
		while(!endOfSilence) {
			if(samples[i] != 0) {
				endOfSilence = true;
				indexOffset = i;
				//break;
			}
			else {
				i++; indexOffset = i;
			}
		}
		int[] result = new int[samples.length - indexOffset];
		for(int j = 0; j < result.length; j++) {
			result[j] = samples[j+indexOffset];
		}

		samples = result;

	}

	//Should return all items in the array separated by a single space
	public String toString()
	{
		String s = "";
		for(int bit : samples) {
			s += (bit+" ");
		}
		return s;
	}
}
