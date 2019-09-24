package by.bsuir.dsp.lab;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Part1Task4 implements DatasetXY{ 
	@Override
	public XYDataset createDataset() {

		 FuncInterf funA =  (x) -> -5 * x + 50;
		 FuncInterf funcPhase = (x) -> -1 * x + 5;
		 FuncInterf funcFreq = (x) -> -20 * x + 30;
         
		
		 XYSeries series = new XYSeries("Полигармонический сигнал");
		 for (int i = 0; i < Constants.N; i++) {
         
			 double x = i/ (double)Constants.N;
	         double ampl = funA.method(x);        
	         double phase = funcPhase.method(x);
	         double freq = funcFreq.method(x);
		
	         double y = ampl * Math.sin(2 * Math.PI * freq * x + phase);
		
	         series.add(i,y/5); /// What is it?
	             		
	         }

		return new XYSeriesCollection(series);
	}
}
