package by.bsuir.dsp.lab;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Part1Task2 implements DatasetXY {

	@Override
	public XYDataset createDataset() {


         XYSeries series = new XYSeries("Test");
         for (int n = 0; n < Constants.N; n++)
         {
             double sum = 0;
             for (int i = 0; i < 5; i++)
             {
                 sum += Functions.func2(Constants.A1_2, Constants.f1_2[i], n, Constants.fis1_2[i]);
                 
             }
             		series.add(n,sum/3); /// What is it?
             		
         }

		return new XYSeriesCollection(series);
		
		
		
		
	}
}
