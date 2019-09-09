package by.bsuir.dsp.lab;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

public class StartCharting {

	private StartCharting() {

	}

	public static JFreeChart paint(XYDataset dataset) {

		return ChartFactory.createXYLineChart("Test Chart", "n", "x(n)", dataset, PlotOrientation.VERTICAL, true, true,
				false);
	}
}
