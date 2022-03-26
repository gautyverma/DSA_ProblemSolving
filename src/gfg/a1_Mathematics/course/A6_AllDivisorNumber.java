package gfg.a1_Mathematics.course;

public class A6_AllDivisorNumber {
	public static void main(String[] args) {
		int n = 30;
		divisorsNavie(n);
		System.out.println();
		divisorsEff1(n);
		System.out.println();
		divisorsEff2(n);
		

	}

	// 2- Efficient Approach(2) - sorted
	private static void divisorsEff2(int n) {
		System.out.print("Effective_2 Approach - ");
		int i;
		for (i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
//		i--;
		for (; i >= 1; i--) {
			if (n % i == 0) {
				System.out.print(n / i + " ");
			}
		}
	}

	// 1- Efficient Approach
	private static void divisorsEff1(int n) {
		System.out.print("Effective_1 Approach - ");
		
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != n / i) {
					System.out.print(n / i + " ");
				}
			}

		}
	}

	// Navie Approach
	private static void divisorsNavie(int n) {
		System.out.print("Navie Approach - ");
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}

		}

	}

//
}
