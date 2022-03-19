package hackerRank.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubArrays {
	private static List<List<Integer>> res = new ArrayList<>();

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3};
		possibleSubArrays(arr, 0, 0);

		for (List<Integer> ger : res) {
			for (int i = 0; i < ger.size(); i++) {
				System.out.print(ger.get(i) + " ");
			}
			System.out.println();
		}
	}

	private static void possibleSubArrays(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (end == arr.length) {
			return;
		} else if (start > end) {
			possibleSubArrays(arr, 0, end + 1);
		} else {
			List<Integer> temp = new ArrayList<>();
			for (int i = start; i <= end; i++) {
				temp.add(arr[i]);
			}
			res.add(temp);
			possibleSubArrays(arr, start + 1, end);
		}
		return;
	}
}
