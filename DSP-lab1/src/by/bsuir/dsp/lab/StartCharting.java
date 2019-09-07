package by.bsuir.dsp.lab;
import java.awt.Dimension;
import java.awt.FlowLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class StartCharting {
	  
	public static ChartPanel paint() {

                JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                        "n", "x(n)", createDataset(), PlotOrientation.VERTICAL, true, true,
                        false);

                ChartPanel cp = new ChartPanel(chart);
                cp.setPreferredSize(new Dimension(200, 100));
                return cp;
            }
	  

    public static XYDataset  createDataset() {
    	

    	XYSeriesCollection dataset = new XYSeriesCollection( );  
    	
    	for (int i = 0; i < 5; i++)
        {
            double fi = Constants.fis[i];
            XYSeries series = new XYSeries( "φ" + (i + 1) + ": " + Math.round(fi * 100.0) /100.0 + " " );         
           
            for (int n = 0; n < Constants.N; n++)
            {
            	 series.add( n, Functions.func1(Constants.A1_1, Constants.f_1, n, fi)  );           
            }
            dataset.addSeries( series);
        }
       


        return dataset;
    }
}
