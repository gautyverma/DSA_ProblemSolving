package gfg.a3_Recursion.exercise;

public class DigitalSum {
	public static void main(String[] args) {
		int n = 99999;
		System.out.println(digitalRoot(n));
	}

	private static int digitalRoot(int n) {
		// TODO Auto-generated method stub
		if(n<10) {
			return(n);
		}
		return digitalRoot(sumOfDigit(n));
		
		
	}

	private static int sumOfDigit(int n) {
		if (n == 0) {
			return 0;
		}
		return (n % 10 + sumOfDigit(n / 10));
	}
}
