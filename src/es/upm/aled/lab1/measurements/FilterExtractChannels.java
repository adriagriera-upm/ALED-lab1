package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {

	private int[] newChannels;
	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		this.newChannels=validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] newmeasurements = new Measurement[eeg.measurements.size()];
		int contador = 0;
		for(int i=0; i<eeg.measurements.size();i++) {
			for(int j=0; j<eeg.measurements.get(i).numChannels();j++) {
				if(j == newChannels[contador]) {
					float[] channels = new float[newChannels.length];
					channels[contador]= eeg.measurements.get(i).getChannel(j);
					contador++;
					//TODO encontrar la forma de crear diferentes channels por cada iteraión
				}
				else { 
					continue;
				}
			
			}
		//TODO rellenar
		
		}
		EEGModel neweeg = new EEGModel(newmeasurements);
		return neweeg;
	}

}
