package es.upm.aled.lab1.measurements;

import java.awt.List;
import java.util.ArrayList;

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
		int index = 0;
			for(int i=0; i<eeg.measurements.size();i++) {
				float[] canales = new float[newChannels.length];
				for(int j=0; j<eeg.measurements.get(i).numChannels();j++) {
					if((j+1) == newChannels[index]) {
						canales[index]= eeg.measurements.get(i).getChannel(j);
						index=(index+1)%newChannels.length;
					
					}
					else { 
					continue;
					}
				
			}
			newmeasurements[i] = new Measurement(canales); //MUY CLAVE
			
				
				
		}
		EEGModel neweeg = new EEGModel(newmeasurements);
		return neweeg;
		}
	
}


