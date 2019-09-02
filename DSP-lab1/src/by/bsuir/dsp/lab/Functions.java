package by.bsuir.dsp.lab;

public class Functions {
	
	public static double func1(int A, int f, int n, double fis) {
		 return A * Math.sin(2 * Math.PI * f * n / Constants.N + fis);
	}
}
