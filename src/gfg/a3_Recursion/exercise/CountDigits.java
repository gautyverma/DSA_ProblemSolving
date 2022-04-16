package gfg.a3_Recursion.exercise;

public class CountDigits {
	public static void main(String[] args) {
		int n = 4513;
		System.out.println(countDigits(n));
	}

	private static int countDigits(int n) {
		if (n < 10) {
			return 0;
		}
		return (1 + countDigits(n / 10));
	}
}
