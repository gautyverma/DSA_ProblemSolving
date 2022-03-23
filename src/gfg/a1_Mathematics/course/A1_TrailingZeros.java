package gfg.a1_Mathematics.course;

import java.util.Scanner;

public class A1_TrailingZeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter the number: ");
			int n = sc.nextInt();
			System.out.println("Trailing Zeros " + countZerosBetter(n));
			System.out.println("Trailing Zeros " + countZeros(n));
			System.out.println();
		}
	}

// better approach - count the number of 5's
	private static int countZerosBetter(int n) {
		// TODO Auto-generated method stub
		int res = 0;
		for (int i = 5; i <= n; i = i * 5) {
			res += n / i;
		}
		return res;
	}

// overFlow issue
	private static int countZeros(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		int fact = 1;
		for (int i = n; i > 1; i--) {
			fact *= i;
		}
		System.out.println("Factorial of n = " + fact);
		if(fact==0) {
			return -1;
		}
		while (fact % 10 == 0) {
			count++;
			fact /= 10;
		}
		return count;
	}


}
