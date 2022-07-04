package InfyCodingEfficient;

import java.util.*;

/**
 * Combinational_Sum
 * 
 * @author GAUTY Given an array find all the combinations where sum of elements
 *         find the target element. Input - arr -[3,4,5] target - 8 output -
 *         [[3,5],[4,4]] -- count = 2
 * 
 *         -------------------------------------- Input - [2,3,5] target - 8
 *         output -[[2,2,2,2],[2,3,3],[3,5]] -- count = 3
 */
public class GivenArrayFindTarget {

	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		Set<Integer> set = new HashSet<>(arr);
		arr.clear();
		arr.addAll(set);
		Collections.sort(arr);
		findNumbers(ans, arr, sum, 0, temp); // 0-> index
		return ans;

	}

	private static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index,
			ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
		if(sum<0) {
			return;
		}
		if (sum == 0) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < arr.size(); i++) {
			if (sum - arr.get(i) >= 0) {
				temp.add(arr.get(i));
				findNumbers(ans, arr, sum - arr.get(i), i, temp);
				temp.remove(arr.get(i));
			}
		}
	}

	public static void main(String[] args) {
		Integer[] arr1 = { 2, 3, 5 };
		int target = 8;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(arr1));
		ArrayList<ArrayList<Integer>> ans = combinationSum(arr, target);
		System.out.println(Arrays.deepToString(ans.toArray()));
	}

}
