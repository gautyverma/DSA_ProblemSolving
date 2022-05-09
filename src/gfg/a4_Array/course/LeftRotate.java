package gfg.a4_Array.course;

import java.util.ArrayList;
import java.util.Arrays;

public class LeftRotate {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(leftRotate(arr, 4)));

		System.out.println(Arrays.toString(eff_leftRotate(arr, 4)));
	}

	private static int[] eff_leftRotate(int[] arr, int d) {
		// TODO Auto-generated method stub
		System.out.println("Efficient Approach");
		arr = reverse(arr, 0, d - 1);
		arr = reverse(arr, d, arr.length - 1);
		arr = reverse(arr, 0, arr.length - 1);

		return arr;
	}

	private static int[] reverse(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int low = i, high = j;
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			
			low++;
			high--;
		}
		return arr;
	}

	private static int[] leftRotate(int[] arr, int d) {
		// TODO Auto-generated method stub
		System.out.println("Self - ");
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < d; i++) {
			list.add(arr[i]);
		}

		for (int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}

		int index = 0;
		for (int i = arr.length - d; i < arr.length; i++) {
			arr[i] = list.get(index);
			index++;
		}

		return arr;
	}
}
