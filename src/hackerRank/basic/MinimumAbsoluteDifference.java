package hackerRank.basic;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
	public static void main(String[] args) {
		int[] arr = { -2, 2, 4 };
		System.out.println(minAbs(arr));
	}
	private static int minAbs(int[] arr) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			 min = Math.min(arr[i]-arr[i+1], min);
		}
		return min;
	}
}
