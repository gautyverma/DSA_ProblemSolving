package InfyCodingEfficient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GAUTY
 * Given an array find the combinations where sum of elements find the target element.
 * Input - arr -[3,4,5]  target - 8
 * output - [[3,5],[4,4]] -- count = 2  
 * 
 * --------------------------------------
 * Input - [2,3,5]  target - 8
 * output -[[2,2,2,2],[2,3,3],[3,5]]  -- count = 3
 */
public class GivenArrayFindTarget {
	
	public static void main(String[] args) {
	Integer[] arr = {2,3,5};
	int target = 8;
	List<Integer> list = new ArrayList<>(Arrays.asList(arr));
	combinationSum(list,target);
	}

private static void combinationSum(List<Integer> list, int target) {
	 List<List<Integer>> res = new ArrayList<List<Integer>>();

	 
	}

}
