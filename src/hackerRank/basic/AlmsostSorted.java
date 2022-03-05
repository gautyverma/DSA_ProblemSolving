package hackerRank.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlmsostSorted {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		if (alreadySorted(arr)) {
			System.out.println("yes");
		} else {
			if (findSwap(arr) == -1) {
				findReverse(arr);
			}
		}

	}

	private static boolean alreadySorted(int[] arr) {
		int n = arr.length;
		boolean sortedFlag = false;
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				sortedFlag = true;
				continue;
			} else {
				sortedFlag = false;
				break;
			}
		}
		return sortedFlag;
	}

	private static int findSwap(int[] arr) {
		// TODO Auto-generated method stub
		int count = 0, start = -1, end = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				count++;
				if (count == 1) {
					start = i;
					end = i + 1;
				} else {
					if (count == 2) {
						end = i + 1;
					} else {
						return -1;
					}
				}
			}
		}
		if ((end != arr.length - 1) && (arr[start] < arr[end + 1])) {
			System.out.println("yes");
			System.out.println("swap " + (start + 1) + " " + (end + 1));
			return 1;
		} else if ((end == arr.length - 1) && (start == (end - 1))) {
			System.out.println("yes");
			System.out.println("swap " + (start + 1) + " " + (end + 1));
			return 1;
		}
		return -1;
	}

	private static int findReverse(int[] arr) {
		// TODO Auto-generated method stub

		int start = -1, end = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				if (start == -1) {
					start = i;
				} else {
					System.out.println("no");
					return -1;
				}
				while (arr[i] > arr[i + 1]) {
					end = i + 1;
					i++;
				}
				if ((start == 0 || arr[start - 1] < arr[end]) && (end == arr.length - 1 || arr[start] < arr[end + 1])) {
					continue;
				} else {
					System.out.println("no");
					return -1;
				}
			}
		}
		System.out.println("yes");
		System.out.println("reverse " + (start + 1) + " " + (end + 1));
		return 1;
	}

}
