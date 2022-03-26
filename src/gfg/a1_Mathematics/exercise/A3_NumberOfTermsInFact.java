package gfg.a1_Mathematics.exercise;

/*
 *  Input: N = 5
	Output: 3
	Explanation: Factorial of 5 is 120.
	Number of digits in 120 is 3 (1, 2, and 0)
*/
public class A3_NumberOfTermsInFact {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(countNum(n));
	}

	private static int countNum(int N) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 1; i <= N; i++)
			sum +=  Math.log10(i);
		
		sum = Math.floor(sum) + 1.0;
		return (int) sum;
	}
}
