package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified period from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractPeriod implements Filter {
	
	private int minfilter;
	private int maxfilter;

	/**
	 * Builds the Filter from the [min, max] range defining the period that needs to
	 * be extracted. min and max are the indexes of the first and last measurements
	 * of the array obtained by calling the getMeasurements() method of EEGModel,
	 * and represent the starting and ending point of the period to be extracted.
	 * Both indexes are included and max-min must be less than the length of the
	 * Measurements array of the EGG Model.
	 * 
	 * @param min Start of the period to be extracted.
	 * @param max End of the period to be extracted.
	 */
	public FilterExtractPeriod(int min, int max) throws Exception{
	
		if(max-min > 256) {
			throw new IllegalArgumentException("Min y max no posibles");
		} else {
			this.minfilter=(min);
			this.maxfilter=(max);
		}	
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		int index = 0;
		Measurement[] newmeasurements = new Measurement[maxfilter-minfilter];
		
		for(int i=0; i<eeg.measurements.size();i++) {
			
			if(i > (minfilter-1) && i < (maxfilter-1)) {
				newmeasurements[index]= eeg.measurements.get(i);
				index++;
			}else {
				continue;
			}
		}
	EEGModel neweeg = new EEGModel(newmeasurements);
	return neweeg;	
		
		
	}
}
