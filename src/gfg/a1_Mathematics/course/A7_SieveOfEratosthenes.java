package gfg.a1_Mathematics.course;

import java.util.Arrays;

/*
 * find small or equal prime numbers for given n.
*/
public class A7_SieveOfEratosthenes {
	public static void main(String[] args) {
		int n = 31;
		printPrime(n);
	}

	private static void printPrime(int n) {
		// TODO Auto-generated method stub
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				
				for (int j = 2 * i; j <= n; j=j+i) {
					isPrime[j] = false;
				}
			}
		}
		for(int i =2 ;i<=n;i++) {
			if(isPrime[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
