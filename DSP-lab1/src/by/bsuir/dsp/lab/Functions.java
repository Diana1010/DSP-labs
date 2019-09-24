package by.bsuir.dsp.lab;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Functions {

	public static double func1(double A, double f, int n, double fis) {
		return A * Math.sin(2 * Math.PI * f * n / Constants.N + fis);
	}
	
	public static double func2(double A, double f, int n, double fis) {
		return A * Math.sin(2 * Math.PI * f * n / Constants.N + fis);
	}
	
	public static double func3(double A, double f, int n, double fis, int j) {
		return A * Math.sin(2 * Math.PI * f * n / Constants.N + fis + j * Math.PI/10);
	}
	
	public static XYSeriesCollection funcPart2 (double fi) {
		int K =  3*Constants.N / 4;
        FuncInterf func = n -> Math.sin(2 * Math.PI * n / Constants.N + fi);
        List<Double> list = new ArrayList<>() ;
        list.add((double)Constants.N-1);
        int k = K;
        while (k <= 2 * Constants.N)
        {
            list.add((double)k);
            k += 10;
        }

        list.sort(Double::compare);
        
        
        double[] Xi = new double[2 * Constants.N];

        for (int i = 0; i < Xi.length; i++)
        {
            Xi[i] = func.method(i);
        }

        double[] gamma1Array = new double[130];
        double[] gamma2Array = new double[130];
        double[] aArray = new double[130];
        XYSeries deltaGamma1List = new XYSeries("1");
        XYSeries deltaGamma2List = new XYSeries("2");
        XYSeries deltaAList = new XYSeries("3");
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        int j = 0;
        
        for (int i = 0; i < list.size(); i++)
        {
            while (j < list.get(i))
            {
                sum1 += Xi[j] * Xi[j];
                sum2 += Xi[j];
                sum3 += Xi[j] * Math.cos(2 * Math.PI * j / list.get(i));
                sum4 += Xi[j] * Math.sin(2 * Math.PI * j / list.get(i));
                j++;
            }

            gamma1Array[i] = Math.sqrt(sum1 / (list.get(i) + 1));
            gamma2Array[i] = Math.sqrt(sum1 / (list.get(i) + 1) - (sum2 / (list.get(i) + 1)) * (sum2 / (list.get(i) + 1)));
            aArray[i] = (2 / list.get(i)) * Math.sqrt(sum3 * sum3 + sum4 * sum4);
        
            
            if (!Double.isNaN(aArray[i]) ) {            
                deltaAList.add( list.get(i) - 768, ( 1 - aArray[i]) );
            }
            deltaGamma1List.add(list.get(i) - 768,(0.707 - gamma1Array[i]) );
            deltaGamma2List.add(list.get(i) - 768,  (0.707 - gamma2Array[i]) );
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(deltaAList);
        dataset.addSeries(deltaGamma1List);
        dataset.addSeries(deltaGamma2List);
       
        return dataset;
	}
}
