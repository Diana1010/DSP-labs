package by.bsuir.poit.dsp.lab2.datasets;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import by.bsuir.poit.dsp.lab2.HarmonicSignal;
import by.bsuir.poit.dsp.lab2.PolyharmonicSignal;
import by.bsuir.poit.dsp.lab2.Signal;

public class Filter implements DatasetXY {


	@Override
	public XYDataset createDataset(int freq) {
		
		int  N = 256;
		double[] A =  { 1, 3, 5, 8, 10, 12, 16 };
        double[] ph =  { Math.PI / 6, Math.PI / 4, Math.PI / 3, Math.PI / 2, 3 * Math.PI / 4, Math.PI};

        PolyharmonicSignal signal = new PolyharmonicSignal(A, freq, ph, N);
        
		XYSeriesCollection dataset = new XYSeriesCollection();
	
			XYSeries seriesSignal = new XYSeries("Signal");
			XYSeries seriesLFSSignal = new XYSeries("LFSSignal");
		

			for (int i = 0; i < N; i++) {
				seriesSignal.add(i, signal.SourceSignal[i]);
				seriesLFSSignal.add(i, signal.SmothedSignal[i]);
				
			}
			dataset.addSeries(seriesSignal);
			dataset.addSeries(seriesLFSSignal);
		

		return dataset;
	}
}
