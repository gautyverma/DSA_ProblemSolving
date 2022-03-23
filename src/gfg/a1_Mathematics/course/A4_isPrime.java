package gfg.a1_Mathematics.course;

public class A4_isPrime {
	public static void main(String[] args) {
		int n = 131;
		System.out.println(isPrime(n));
	}

	public static boolean isPrime(int n) {
		// TODO Auto-generated method stub
		if (n == 1)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}
