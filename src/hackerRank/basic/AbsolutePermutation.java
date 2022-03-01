package hackerRank.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbsolutePermutation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = 1;
//		int t = sc.nextInt();

		for (int j = 0; j < t; j++) {

			// String[] split = sc.nextLine().split(" ");
			// int n = Integer.parseInt(split[0]);
			// int k = Math.abs(Integer.parseInt(split[1]));

//			int n = sc.nextInt();
//			int k = sc.nextInt();
			int n = 7;
			int k = 3;

			long[] arrValue = new long[n];

			for (int i = 0; i < n; i++) {
				arrValue[i] = i + 1;
			}
			if (k == 0) {
				for (int i = 0; i < n; i++) {
					System.out.print(arrValue[i] + " ");
				}
			} else if (k > n || k> n/2) {
				System.out.println("-1");
			} else  {
				long tempIndex = 1;
				int point = 0;
				boolean flag = false;
				for (int i = 0; i < n; i++) {
					if (Math.abs(tempIndex - arrValue[i]) == k) {
						point = i;
						flag = true;
						break;
					}
				}

				if (flag) {
					List<Long> resList = new ArrayList<>();
					for (int i = point; i < n; i++) {
						resList.add(arrValue[i]);
					}
					for (int i = 0; i < point; i++) {
						resList.add(arrValue[i]);
					}
					for (Long obj : resList) {
						System.out.print(obj + " ");
					}
				} else {
					System.out.println("-1");
				}

			}
			System.out.println();
		}
	}
}