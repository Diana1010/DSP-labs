package by.bsuir.poit.dsp.lab2.datasets;

import org.jfree.data.xy.XYDataset;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import by.bsuir.poit.dsp.lab2.HarmonicSignal;
import by.bsuir.poit.dsp.lab2.PolyharmonicSignal;
import by.bsuir.poit.dsp.lab2.Signal;

public class PolyhAmplitude implements DatasetXY {


	
	@Override
	public XYDataset createDataset(int freq) {
		int  N = 256;
		double[] A =  { 1, 3, 4, 10, 11, 14, 17 };
        double[] ph =  { Math.PI / 6, Math.PI / 4, Math.PI / 3, Math.PI / 2, 3 * Math.PI / 4, Math.PI};

        PolyharmonicSignal signal = new PolyharmonicSignal(A, freq, ph, N);
	        
			XYSeriesCollection dataset = new XYSeriesCollection();
		
				XYSeries series = new XYSeries("Amplitude");

				for (int i = 0; i < N/2 -1; i++) {
					series.add(i, signal.amplSp[i]);
				}
				dataset.addSeries(series);
			

			return dataset;
	}

}
