package by.bsuir.dsp.lab;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Part1Task3 implements DatasetXY {

	@Override
	public XYDataset createDataset() {

		XYSeriesCollection dataset = new XYSeriesCollection();

		for (int i = 0; i < 5; i++) {
			double f = Constants.A1_c[i];
			XYSeries series = new XYSeries("A" + (i + 1) + ": " + Math.round(f * 100.0) / 100.0 + " ");

			for (int n = 0; n < Constants.N; n++) {
				series.add(n, Functions.func1(f, Constants.f1_c, n, Constants.fis1_c));
			}
			dataset.addSeries(series);
		}

		return dataset;
	}

}
