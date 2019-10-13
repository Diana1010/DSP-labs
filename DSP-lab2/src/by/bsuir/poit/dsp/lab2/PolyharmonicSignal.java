package by.bsuir.poit.dsp.lab2;

import java.util.Random;

public class PolyharmonicSignal extends Signal {

	 double[] A, phi;
     double f;
     public double[] RestoredSignalWithoutPhase;
     public double[] SmothedSignal;

     public PolyharmonicSignal(double[] amplitudes, double freq, double[] phases, int N) 
     {
    	  super(N);
          A = amplitudes;
          f = freq;
          phi = phases;
          SourceSignal = GenerateSignal();
          sinSp = GetSineSpectrum();
          cosSp = GetCosineSpectrum();
          amplSp = GetAmplSpectrum();
          phaseSp = GetPhaseSpectrum();
          RestoredSignal = RestoreSignal();
          RestoredSignalWithoutPhase = RestoreSignalWithoutPhase();
          SmothedSignal = ParabolicSmoothing();
     }

     private double[] GenerateSignal()
     {
          double[] sign = new double[_N];
          Random rnd = new Random();
          for (int i = 0; i < _N; i++)
          {
               double tm = 0;
               for (int j = 0; j <= 30; j++)
               {
                    tm += A[rnd.nextInt(7)] * Math.cos(2 * Math.PI * f * i / _N + phi[rnd.nextInt(6)]);
               }
               sign[i] = tm;
          }
          return sign;
     }

     protected double[] RestoreSignal()
     {
          double[] values = new double[_N];
          for (int i = 0; i < _N; i++)
          {
               double val = 0;
               for (int j = 1; j < harmCount; j++)
               {
                    val += amplSp[j] * Math.cos(2 * Math.PI * i * j / _N - phaseSp[j]);
               }
               values[i] = val + amplSp[0] / 2;
          }
          return values;
     }

     protected double[] RestoreSignalWithoutPhase()
     {
          double[] values = new double[_N];
          for (int i = 0; i < _N; i++)
          {
               double val = 0;
               for (int j = 1; j < harmCount; j++)
               {
                    val += amplSp[j] * Math.cos(2 * Math.PI * i * j / _N);
               }
               values[i] = val + amplSp[0] / 2;
          }
          return values;
     }

     public double[] ParabolicSmoothing()
     {
          double[] rest = new double[_N];
          for (int i = 7; i <= rest.length - 8; i++)
          {
               rest[i] = (-3 * SourceSignal[i - 7] - 6 * SourceSignal[i - 6] - 5 * SourceSignal[i - 5] + 3 * SourceSignal[i - 4] + 21 * SourceSignal[i - 3] + 46 * SourceSignal[i - 2] + 67 * SourceSignal[i - 1] + 74 * SourceSignal[i] - 3 * SourceSignal[i + 7] - 6 * SourceSignal[i + 6] - 5 * SourceSignal[i + 5] + 3 * SourceSignal[i + 4] + 21 * SourceSignal[i + 3] + 46 * SourceSignal[i + 2] + 67 * SourceSignal[i + 1]) / 320;
          }
          return rest;
     }
}
