package gfg.a1_Mathematics.course;

public class A2_GCD {
	public static void main(String[] args) {
		int a = 15;
		int b = 10;
		System.out.println("Iterative Approach  - "+gcd_1(a, b));
		System.out.println("Euclidean Algorithm - "+gcd_2(a, b));
		System.out.println("Euclidean Algorithm optimized - "+gcd_3(a, b));
	}

// Euclidean Algorithm - optimized
	private static int gcd_3(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd_3(b,a%b);
	}
// Euclidean Algorithm
	private static int gcd_2(int a, int b) {
		// TODO Auto-generated method stub
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

	// Iterative Appraoch - basic
	private static int gcd_1(int a, int b) {
		// TODO Auto-generated method stub
		int min = Math.min(a, b);
		for (int i = min; i >= 2; i--) {
			if (b % i == 0 && a % i == 0) {
				return i;
			}
		}
		return 1;
	}
}
