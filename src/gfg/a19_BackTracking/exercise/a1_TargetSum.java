package gfg.a19_BackTracking.exercise;

import java.util.ArrayList;
import java.util.Arrays;

/*
*
* Given an array arr[] of distinct integers and a target,
* your task is to find all unique combinations in the array where the sum is equal to target.
* The same number may be chosen from the array any number of times to make target.

Note: You can return your answer in any order, but the driver code will print the combinations in sorted order only.

Examples:

Input: arr[] = [1, 2, 3], target = 5
Output: [[1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 1, 3], [1, 2, 2], [2, 3]]
Explanation: All the combination have sum of elements equals to target.
* */
public class a1_TargetSum {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    int target = 5;
    System.out.println("result :: " + targetSumComb(arr, target));
  }

  private static ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {

    Arrays.sort(arr);
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    backtrack(arr, target, 0, new ArrayList<>(), res);
    return res;
  }

  private static void backtrack(
      int[] arr,
      int target,
      int start,
      ArrayList<Integer> current,
      ArrayList<ArrayList<Integer>> result) {

    if (target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i < arr.length; i++) {

      if (arr[i] > target) break;

      current.add(arr[i]);
      backtrack(arr, target - arr[i], i, current, result);
      current.remove(current.size() - 1);
    }
  }
}
