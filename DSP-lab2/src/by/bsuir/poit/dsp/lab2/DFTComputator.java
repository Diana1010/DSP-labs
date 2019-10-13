package by.bsuir.poit.dsp.lab2;

import java.util.List;

public class DFTComputator {

	static void GetAmplitudeAndPhase(List<Double> xi, int j)
    {
         int N = xi.size();

         double[] sinValues = new double[N];
         double[] cosValues = new double[N]; //remove and use only one array

         for (int i = 0; i < N; i++)
         {
              sinValues[i] = Math.sin(2 * Math.PI * j * i / N);
         }
         for (int i = 0; i < N; i++)
         {
              cosValues[i] = Math.cos(2 * Math.PI * j * i / N);
         }

         double Acj = 0.0;
         double Asj = 0.0;
         double Aj = 0.0;
         double phi = 0.0;

         double cosSum = 0.0;
         for(int i = 0; i < N; i++)
         {
              cosSum += xi.get(i) * cosValues[i];
         }
         Acj = 2 * cosSum / N;

         double sinSum = 0.0;
         for (int i = 0; i < N; i++)
         {
              sinSum += xi.get(i) * sinValues[i];
         }
         Asj = 2 * sinSum / N;

         Aj = Math.sqrt(Acj * Acj + Asj * Asj);

         phi = Math.atan(Asj / Acj);
    }
}
