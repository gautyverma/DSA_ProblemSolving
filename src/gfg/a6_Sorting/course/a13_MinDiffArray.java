package gfg.a6_Sorting.course;

import java.util.Arrays;

/*
 * Find min difference in array
 * Solution -
 *   1. Sort the array
 *   2. compute diff b/w adjacent elements
 *   3. return minimum of it
 * */
public class a13_MinDiffArray {
  public static void main(String[] args) {
    Integer[] arr = {1, 8, 12, 5, 18};
    System.out.println("Minimum difference : " + getMinDiff(arr));
  }

  private static Integer getMinDiff(Integer[] arr) {
    Integer res = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i++) {

      res = Math.min(res, Math.abs(arr[i - 1] - arr[i]));
    }
    return res;
  }
}
