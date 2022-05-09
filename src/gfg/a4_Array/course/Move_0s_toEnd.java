package gfg.a4_Array.course;

import java.util.Arrays;

public class Move_0s_toEnd {
	public static void main(String[] args) {
		int[] arr = { 8, 5, 0, 10, 0, 20 };
		System.out.println(Arrays.toString(navie_move0s(arr)));
		System.out.println(Arrays.toString(eff_move0s(arr)));

	}

	private static int[] eff_move0s(int[] arr) {
		System.out.println("----eff Solution---");
		int count = 0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]!=0) {
				int temp = arr[count];
				arr[count] = arr[i];
				arr[i] = temp;
				
				count++;

			}
		}
		return arr;
	}

	private static int[] navie_move0s(int[] arr) {
		System.out.println("----Navie Solution----");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {

						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;

						break;

					}
				}
			}
		}
		return arr;
	}
}
