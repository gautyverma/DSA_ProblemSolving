package gfg.a1_Mathematics.course;

public class A3_LCM {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		System.out.println("Iterative Approach - " + lcm_1(a, b));
		System.out.println("Efficient Approach - " + lcm2(a, b));
	}

	/*
	 * product(a*b) = gcd(a,b) * lcm(a,b)
	 * 
	 * lcm(a,b) = (a*b)/gcd(a,b)
	 */

	// Euclidean - gcd
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// Efficient solution of lcm
	private static int lcm2(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	// Iteratve Approach
	private static int lcm_1(int a, int b) {
		// TODO Auto-generated method stub
		int max = Math.max(a, b);
		while (true) {
			if (max % a == 0 && max % b == 0) {
				break;
			}
			max++;
		}
		return max;
	}
}
