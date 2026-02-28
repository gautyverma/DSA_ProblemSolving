package gfg.a20_DynamicProgramming.course;

public class a6_MaxIncreasingSumSubsequence {
  public static void main(String[] args) {
    int[] arr = {3, 20, 4, 6, 7, 30};
    System.out.println("Max sum in increasing subsequence :: " + maxSum(arr));
  }

  private static int maxSum(int[] arr) {
    int n = arr.length;
    int[] msis = new int[n];
    msis[0] = arr[0];
    for (int i = 1; i < n; i++) {
      msis[i] = arr[i];
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          msis[i] = Math.max(msis[i], arr[i] + msis[j]);
        }
      }
    }
    int res = msis[0];
    for (int i = 1; i < arr.length; i++) {
      res = Math.max(res, msis[i]);
    }
    return res;
  }
}
