package by.bsuir.dsp.lab;

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
}
