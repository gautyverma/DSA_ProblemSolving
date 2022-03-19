package hackerRank.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfSubArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		combination(arr);
	}

	private static void combination(int[] arr) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> temp = new ArrayList<Integer>();
		combinationUtil(0, 1, arr, temp, list);

		for (List<Integer> ger : list) {
			for (int i = 0; i < ger.size(); i++) {
				System.out.print(ger.get(i) + " ");
			}
			System.out.println();
		}
	}

	private static void combinationUtil(int start, int end, int[] arr, List<Integer> temp,
			List<List<Integer>> list) {
		
		for (int j = 0; j < arr.length; j++) {
			end = j+1;
			while (true) {
				List<Integer> tempNew = new ArrayList<Integer>();
				
				if (end == arr.length) {
					break;
				}
				
				for (int i = j; i <= end; i++) {
					tempNew.add(arr[i]);
				}
				list.add(tempNew);
				end++;
			}
		}
		return;
	}
}
