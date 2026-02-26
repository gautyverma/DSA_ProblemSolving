package gfg.a19_BackTracking.exercise;

import java.util.*;

public class a4_UniqueSubset {
  public static void main(String[] args) {
    int[] arr = {2, 1, 2};
    System.out.println("Unique subset ::" + allSubsets(arr, arr.length));
  }

  private static List<List<Integer>> allSubsets(int[] arr, int n) {

    Arrays.sort(arr); // Step 1: sort
    List<List<Integer>> result = new ArrayList<>();
    solve(arr, 0, new ArrayList<>(), result);
    return result;
  }

  private static void solve(int[] arr, int index, List<Integer> curr, List<List<Integer>> result) {

    // Add current subset
    result.add(new ArrayList<>(curr));

    for (int i = index; i < arr.length; i++) {

      // Skip duplicates
      if (i > index && arr[i] == arr[i - 1]) continue;

      curr.add(arr[i]);
      solve(arr, i + 1, curr, result);

      // Backtrack
      curr.remove(curr.size() - 1);
    }
  }
}
