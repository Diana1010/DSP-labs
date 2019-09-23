package by.bsuir.dsp.lab;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Part1Task1b implements DatasetXY {

	@Override
	public XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();

		for (int i = 0; i < 5; i++) {
			double f = Constants.f1_b[i];
			XYSeries series = new XYSeries("f" + (i + 1) + ": " + Math.round(f * 100.0) / 100.0 + " ");

			for (int n = 0; n < Constants.N; n++) {
				series.add(n, Functions.func1(Constants.A1_a, f, n, Constants.fis1_b));
			}
			dataset.addSeries(series);
		}

		return dataset;
	}

}
