package by.bsuir.poit.dsp.lab2.datasets;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import by.bsuir.poit.dsp.lab2.HarmonicSignal;
import by.bsuir.poit.dsp.lab2.Signal;

public class Phase implements DatasetXY {


	@Override
	public XYDataset createDataset(int freq) {
		 int  N = 256;
			
	        Signal signal = new HarmonicSignal(10, freq, N);
	        
			XYSeriesCollection dataset = new XYSeriesCollection();
		
				XYSeries series = new XYSeries("Phase");

				for (int i = 0; i < N/2 -1; i++) {
					series.add(i, signal.phaseSp[i]);
				}
				dataset.addSeries(series);
			

			return dataset;
	}

}
