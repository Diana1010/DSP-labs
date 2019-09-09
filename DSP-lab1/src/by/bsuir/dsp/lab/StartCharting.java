package by.bsuir.dsp.lab;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class StartCharting {

	public static JFreeChart paint(XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "n", "x(n)", dataset, PlotOrientation.VERTICAL,
				true, true, false);

//		ChartPanel cp = new ChartPanel(chart);
//		cp.setPreferredSize(new Dimension(200, 100));
		return chart;
	}

	public static XYDataset createDataset() {

		XYSeriesCollection dataset = new XYSeriesCollection();

		for (int i = 0; i < 5; i++) {
			double fi = Constants.fis[i];
			XYSeries series = new XYSeries("φ" + (i + 1) + ": " + Math.round(fi * 100.0) / 100.0 + " ");

			for (int n = 0; n < Constants.N; n++) {
				series.add(n, Functions.func1(Constants.A1_1, Constants.f_1, n, fi));
			}
			dataset.addSeries(series);
		}

		return dataset;
	}
}
