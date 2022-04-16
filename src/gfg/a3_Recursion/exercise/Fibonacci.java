package gfg.a3_Recursion.exercise;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fibonacci(n));
	}

	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
