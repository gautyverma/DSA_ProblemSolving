package hackerRank.greedy;


import java.util.Scanner;

public class SherlockAndTheBeast {
	public static void main(String[] args) {
		int t = 1;
		int n = 11;

		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
//			int n = sc.nextInt();
			print(n);

		}
	}

	private static void print(int n) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		if (n < 3) {
			System.out.println(-1);
		} else if (n % 3 == 0) {

			for (int i = 0; i < n; i++) {
				sb.append('5');
			}
			System.out.println(sb);
		} else {
			int a = 5;
			while (n - a > 0) {
				if ((n - a) % 3 != 0) {
					a += 5;
				} else
					break;
			}
			if (n - a >= 0) {
				for (int i = 0; i < n - a; i++) {
					sb.append('5');
				}
				for (int i = 0; i < a; i++) {
					sb.append('3');
				}
				System.out.println(sb);
			} else {
				System.out.println(-1);
			}

		}

	}
}
