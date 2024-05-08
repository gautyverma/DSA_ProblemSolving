package gfg.a6_Sorting.course;

import java.util.Arrays;
import java.util.Map;

/*
 * Pick m packets from array such that they have minimum difference
 * Solution -
 *  1. Sort the arr
 *  2. Take subArray index to calculate outer index value difference.
 * */
public class a14_ChocolateDistributionProblem {
  public static void main(String[] args) {
    Integer[] arr = {7, 3, 2, 4, 9, 12, 56};
    int m = 3;
    System.out.println("Min diff while distribution : " + minDiffDist(arr, m));
  }

  private static int minDiffDist(Integer[] arr, int m) {
    if (m > arr.length) {
      return -1;
    }
    Arrays.sort(arr);
    int res = arr[m - 1] - arr[0];
    for (int i = 1; i + m - 1 < arr.length; i++) {
      res = Math.min(res, arr[i + m - 1] - arr[i]);
    }
    return res;
  }
}
