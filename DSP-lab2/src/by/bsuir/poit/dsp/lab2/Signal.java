package by.bsuir.poit.dsp.lab2;

public class Signal {
	
	 public double[] SourceSignal;
     public double[] RestoredSignal;

     public int harmCount;

     public double[] sinSp, cosSp;
     public double[] amplSp;
	public double[] phaseSp;

     protected int _N;

     public Signal(int N)
     {
          _N = N;
          harmCount = _N / 2 - 1;
     }

     protected double[] GetSineSpectrum()
     {
          double[] values = new double[harmCount];
          for (int j = 0; j < harmCount; j++)
          {
               double val = 0;
               for (int i = 0; i < _N; i++)
               {
                    val += SourceSignal[i] * Math.sin(2 * Math.PI * i * j / _N);
               }
               values[j] = 2 * val / _N;
          }
          return values;
     }

    protected double[] GetCosineSpectrum()
     {
          double[] values = new double[harmCount];
          for (int j = 0; j < harmCount; j++)
          {
               double val = 0;
               for (int i = 0; i < _N; i++)
               {
                    val += SourceSignal[i] * Math.cos(2 * Math.PI * i * j / _N);
               }
               values[j] = 2 * val / _N;
          }
          return values;
     }

     protected double[] GetAmplSpectrum()
     {
          double[] values = new double[harmCount];
          for (int j = 0; j < harmCount; j++)
          {
               values[j] = Math.sqrt(Math.pow(sinSp[j], 2) + Math.pow(cosSp[j], 2));
          }
          return values;
     }

     protected double[] GetPhaseSpectrum()
     {
          double[] values = new double[harmCount];
          for (int j = 0; j < harmCount; j++)
          {
               values[j] = Math.atan(sinSp[j] / cosSp[j]);
          }
          return values;
     }
}
