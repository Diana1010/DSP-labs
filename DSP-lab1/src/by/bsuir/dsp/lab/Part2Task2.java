package by.bsuir.dsp.lab;

import org.jfree.data.xy.XYDataset;

public class Part2Task2 implements DatasetXY {

	@Override
	public XYDataset createDataset() {
		
		return Functions.funcPart2(Math.PI / 4);
	}

}
