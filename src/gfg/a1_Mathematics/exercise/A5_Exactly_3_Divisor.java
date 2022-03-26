package gfg.a1_Mathematics.exercise;

/*
 Given a positive integer value N. The task is to find how many numbers less 
 than or equal to N have numbers of divisors exactly equal to 3.


Example 1:

Input:
N = 6
Output: 1
Explanation: The only number less than 6 with 
3 divisors is 4.


Example 2:

Input:
N = 10
Output: 2
Explanation: 4 and 9 have 3 divisors.

*/
public class A5_Exactly_3_Divisor {
	public static void main(String[] args) {
		System.out.println(exactly3Divisors(6));
	}

	public static int exactly3Divisors(int N) {
		// Your code here
		int count = 0;
		for (int i = N; i >= 1; i--) {
			if (divisorsEff1(i)) {
				count++;
			}
		}
		return count;
	}

	// 1- Efficient Approach
	private static boolean divisorsEff1(int n) {
//		System.out.print("Effective_1 Approach - ");

		int count=0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
//				System.out.print(i + " ");
				count++;
				if (i != n / i) {
//					System.out.print(n / i + " ");
					count++;
				}
			}

		}
		if(count==3) {
			return true;
		}
		return false;
	}
}
