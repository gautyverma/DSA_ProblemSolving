package hackerRank.greedy;


import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] candies = new int[n];
		candies[0]=1;
		
		for(int i = 1;i<n;i++) {
			if(arr[i]>arr[i-1]) {
				candies[i] = candies[i-1]+1;
			}else {
				candies[i] = 1;
			}
		}
		
		for(int i = n-2;i>=0;i--) {
			if(arr[i]>arr[i+1] && candies[i]<= candies[i+1]) {
				candies[i] = candies[i+1]+1;
			}
		}
		
		long sum = 0;
		for (Integer ger : candies) {
			sum += ger;
		}
		System.out.println(sum);
	}
}
