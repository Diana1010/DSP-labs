package by.bsuir.dsp.lab;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Part1Task1 implements DatasetXY {

	@Override
	public XYDataset createDataset() {

		XYSeriesCollection dataset = new XYSeriesCollection();

		for (int i = 0; i < 5; i++) {
			double fi = Constants.fis1_a[i];
			XYSeries series = new XYSeries("φ" + (i + 1) + ": " + Math.round(fi * 100.0) / 100.0 + " ");

			for (int n = 0; n < Constants.N; n++) {
				series.add(n, Functions.func1(Constants.A1_a, Constants.f1_a, n, fi));
			}
			dataset.addSeries(series);
		}

		return dataset;
	}

}
