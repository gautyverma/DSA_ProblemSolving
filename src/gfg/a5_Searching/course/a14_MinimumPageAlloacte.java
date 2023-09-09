package gfg.a5_Searching.course;

public class a14_MinimumPageAlloacte {
  public static void main(String[] args) {
    int[] arr = {10, 5, 30, 1, 2, 5, 10, 10};
    System.out.println("Naive Solution : " + navMinPage(arr, arr.length, 3));
  }

  private static int navMinPage(int[] arr, int n, int k) {
    if (k == 1) {
      return sumFunc(arr, 0, n - 1);
    }
    if (n == 1) {
      return arr[0];
    }
    int res = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      res = Math.min(res, Math.max(navMinPage(arr, i, k - 1), sumFunc(arr, i, n - 1)));
    }
    return res;
  }

  private static int sumFunc(int[] arr, int start, int end) {
    int res = 0;
    for (int i = start; i <= end; i++) {
      res += arr[i];
    }
    return res;
  }
}
