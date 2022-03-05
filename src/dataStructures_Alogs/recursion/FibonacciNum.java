package dataStructures_Alogs.recursion;

import java.util.HashMap;

public class FibonacciNum {
	static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
public static void main(String[] args) {
	int n = 8;
	for(int i = 0;i<n;i++) {
		System.out.print(fibo(i)+" ");
	}
}
private static int fibo(int n) {
	// TODO Auto-generated method stub
	if(n <= 1) {
		return 1;
	}
	if(memo.get(n)==null) {
		int value = fibo(n-1)+fibo(n-2);
		memo.put(n, value);
	}
	return memo.get(n);
}
}
