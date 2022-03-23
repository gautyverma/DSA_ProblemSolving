package gfg.a1_Mathematics.course;

public class A5_PrimeFactors {
	public static void main(String[] args) {
		int n = 84;
		printPrimeFactors(n);
		System.out.println();
		printPrimeFactors2(n);
	}

// GFG - most Efficient
	private static void printPrimeFactors2(int n) {
		if (n == 1) {
			System.out.println(1);
			return;
		}
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}
		while (n % 3 == 0) {
			System.out.print(3 + " ");
			n /= 3;
		}
		for (int i = 5; i * i <= n; i = i + 6) {
			while(n%i ==0) {
				System.out.print(i + " ");
				n /= i;
			}
			while(n%(i+2) ==0) {
				System.out.print(i+2 + " ");
				n /= (i+2);
			}
		}
		if(n>3) {
			System.out.print(n);
		}

	}

// Mine
	private static void printPrimeFactors(int n) {
		// TODO Auto-generated method stub
		int i = 1;
		while (i <= n) {
			if (n % i == 0 && A4_isPrime.isPrime(i)) {
				n /= i;
				System.out.print(i + " ");
			} else {
				i++;
			}
		}

	}
}
