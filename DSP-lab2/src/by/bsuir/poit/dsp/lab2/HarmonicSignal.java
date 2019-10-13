package by.bsuir.poit.dsp.lab2;

public class HarmonicSignal extends Signal {

	 private double _A, _f;
     
     public HarmonicSignal(double amplitude, double freq, int N) 
     {
    	 super(N);
          _A = amplitude;
          _f = freq;

          SourceSignal = GenerateSignal();
          sinSp = GetSineSpectrum();
          cosSp = GetCosineSpectrum();
          amplSp = GetAmplSpectrum();
          phaseSp = GetPhaseSpectrum();
          RestoredSignal = RestoreSignal();
     }

     protected double[] GenerateSignal()
     {
          double[] sign = new double[_N];
          for (int i = 0; i < _N; i++)
          {
               sign[i] = _A * Math.cos(2 * Math.PI * _f * i / _N);
          }
          return sign;
     }

     protected double[] RestoreSignal()
     {
          double[] values = new double[_N];
          for (int i = 0; i < _N; i++)
          {
               double val = 0;
               for (int j = 0; j < harmCount; j++)
               {
                    val += amplSp[j] * Math.cos(2 * Math.PI * i * j / _N - phaseSp[j]);
               }
               values[i] = val;
          }
          return values;
     }
}
