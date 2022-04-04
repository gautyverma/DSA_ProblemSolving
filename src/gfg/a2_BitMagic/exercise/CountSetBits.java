package gfg.a2_BitMagic.exercise;

/*
	You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

		Example 1:
		
		Input: N = 4
		Output: 5
		Explanation:
		For numbers from 1 to 4.
		For 1: 0 0 1 = 1 set bits
		For 2: 0 1 0 = 1 set bits
		For 3: 0 1 1 = 2 set bits
		For 4: 1 0 0 = 1 set bits
		Therefore, the total set bits is 5.

*/
public class CountSetBits {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(countSetBits1(n));
	}

	private static int countSetBits(int n) {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 1; i <= n; i++) {
			int res = 0;
			int m = i;
			while (m > 0) {
				m = m & (m - 1);
				res++;
			}
			total += res;
		}
		return total;
	}

	// Function to return sum of count of set bits in the integers from 1 to n.
	public static int countSetBits1(int n) {

		if (n == 0)
			return 0;
		// formula for calculation
		// Solve(n)= pow(2,x-1)*x+(n-pow(2,x)+1)+Solve(n-pow(2,x))
		// where x is the highest power of 2 such that pow(2,x)<=n

		// here we are calculating the power of 2 i.e. x
		int x = 0;
		while ((1 << x) <= n) {
			x++;
		}
		// 1<<x represents 2 raised to power of x
		// here reducing x to cover for that extra power raised
		x = x - 1;

		int bitsuptox = (1 << (x - 1)) * x;
		int setmsbofrest = n - (1 << x) + 1;
		int rest = n - (1 << x);
		return bitsuptox + setmsbofrest + countSetBits(rest);
	}
}
