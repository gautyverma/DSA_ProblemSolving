package dataStructures_Alogs.recursion;

import java.util.HashMap;

public class Factorial {
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int n = 5;
		System.out.println(factorial(n));
	}

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} 
		if(map.get(n)==null) {
			int y = factorial(n - 1) * n;
			map.put(n, y);
		}
		return map.get(n);
	}
}
