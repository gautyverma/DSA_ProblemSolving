package hackerRank.greedy;


import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	int[] arr = new int[n];
	
	for(int i = 0;i<n;i++) {
		arr[i] = sc.nextInt();
	}

//		int[] arr = { 1, 15, 5, 111, 200, 1000, 10 };
//		int k = 50;
//		int[] arr = { 1,2,4,3 };
//		int k = 7;
		System.out.println(maxToys(arr, k));
	}

	private static int maxToys(int[] arr, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int sum = 0, count = 0, tempK = k;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < tempK) {
				sum += arr[i];
				count++;
				tempK -= arr[i];
			}
		}
		return count;
	}
}
