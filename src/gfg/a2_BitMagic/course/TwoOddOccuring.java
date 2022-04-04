package gfg.a2_BitMagic.course;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an array in which two integer is occuring odd times, find that number.
*/
public class TwoOddOccuring {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 4, 1 };

		// Navie Approach
		System.out.println(Arrays.toString(navie(arr)));

		// Efficient Approach
		System.out.println(Arrays.toString(Eff(arr)));
	}

	private static int[] Eff(int[] arr) {
		// TODO Auto-generated method stub
		int xor = 0, res1 = 0, res2 = 0;
		for (int ger : arr) {
			xor ^= ger;
		}
		int sn = xor & (~(xor - 1));

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & sn) != 0) {
				res1 ^= arr[i];
			} else {
				res2 ^= arr[i];
			}
		}
		int[] res = new int[2];
		res[0] = res1;
		res[1] = res2;
		return (res);
	}

// navie - Complexity - O(n^2)
	private static int[] navie(int[] arr) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		int res[] = new int[2];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					count++;
				}
			}
			if (count % 2 != 0) {
				set.add(arr[i]);
			}

		}
		for (Integer ger : set) {
			res[index] = ger;
			index++;
		}
		return res;
	}
}
