package gfg.a4_Array.course;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };
		System.out.println("Original Array" + Arrays.toString(arr));
		System.out.println("Reverse Array" + Arrays.toString(reversigArray(arr)));

	}

	private static int[] reversigArray(int[] arr) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			arr[low] = arr[low]+arr[high];
			arr[high] = arr[low]-arr[high];
			arr[low] = arr[low] - arr[high];
			low++;
			high--;
		}
		return arr;
	}
}
