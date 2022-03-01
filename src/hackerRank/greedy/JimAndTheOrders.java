package hackerRank.greedy;


import java.util.Arrays;
import java.util.Scanner;

public class JimAndTheOrders {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] order = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				order[i][j] = sc.nextInt();
			}
		}
		int[] serve = new int[n];
		int[] tempServe = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				serve[i]+=order[i][j];
				tempServe[i] = serve[i];
			}
		}
		Arrays.sort(tempServe);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(tempServe[i]==serve[j]) {
					System.out.print(j+1+" ");
					serve[j] = -1;
				}
			}
		}
		
	}
}
