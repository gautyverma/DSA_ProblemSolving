package hackerRank.basic;

import java.util.Scanner;

public class Three_3DSurfaceArea {
	
//	0|0|0|0|0|0| -  make the boundry of zeros's compare with 4 faces as two face will have 2*W*H
	 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] arr = new int[H + 2][W + 2];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int sa = 0;
		sa = 2*W*H;
		for (int i = 1; i < H + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				
				sa += (arr[i][j] > arr[i - 1][j] ? arr[i][j] - arr[i - 1][j] : 0);
				sa += (arr[i][j] > arr[i + 1][j] ? arr[i][j] - arr[i + 1][j] : 0);
				sa += (arr[i][j] > arr[i][j - 1] ? arr[i][j] - arr[i][j - 1] : 0);
				sa += (arr[i][j] > arr[i][j + 1] ? arr[i][j] - arr[i][j + 1] : 0);
			}
		}

		System.out.println(sa);

	}
}