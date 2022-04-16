package gfg.a3_Recursion.exercise;

import java.util.Arrays;

public class LuckyNumber {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(isLucky(n));
	}

	private static boolean isLucky(int n) {
		// TODO Auto-generated method stub
		boolean ans = check(n, 2);
		return ans;

	}

	public static boolean check(int n, int counter) {

		if (counter > n)
			return true;
		if (n % counter == 0)
			return false;

		return check(n - (n / counter), counter + 1);

	}
}
