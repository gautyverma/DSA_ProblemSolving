package hackerRank.greedy;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PermutingTwoArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int p = 0; p < q; p++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);

			Integer[] b = new Integer[n];
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}
			Arrays.sort(b, Collections.reverseOrder());
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (a[i] + b[i] >= k) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
