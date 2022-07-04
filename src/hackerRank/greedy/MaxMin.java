package hackerRank.greedy;


import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		for(int i = 0;i<=n-k;i++) {
			if(arr[i+k-1]-arr[i]<=min) {
				min = arr[i+k-1] - arr[i];
			}
		}
		System.out.println(min);
	}
}
