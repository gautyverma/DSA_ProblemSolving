package gfg.a20_DynamicProgramming.course;

public class a4_LongestIncreasingSubsequence {
  public static void main(String[] args) {
    int[] arr = {10, 5, 18, 7, 2, 9};
    System.out.println("----------------------------");
    System.out.println("LIS using dp app with O(n^2) :: " + lisNaive(arr));
    System.out.println("----------------------------");
    System.out.println("LIS with nlogn :: " + lisEff(arr));
    System.out.println("----------------------------");
  }

  private static int lisEff(int[] arr) {
    int n = arr.length, len = 1;
    int[] tail = new int[n];
    tail[0] = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > tail[len - 1]) {
        tail[len] = arr[i];
        len++;
      } else {
        int c = ceilIndex(tail, 0, len - 1, arr[i]);
        tail[c] = arr[i];
      }
    }
    return len;
  }

  private static int ceilIndex(int[] tail, int l, int r, int x) {
    while (l < r) {
      int m = l + (r - l) / 2;

      if (tail[m] >= x) r = m;
      else l = m + 1;
    }
    return r;
  }

  private static int lisNaive(int[] arr) {
    int[] lis = new int[arr.length];
    lis[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          lis[i] = Math.max(lis[i], lis[j] + 1);
        }
      }
    }
    int res = lis[0];
    for (int i = 1; i < arr.length; i++) {
      res = Math.max(res, lis[i]);
    }
    return res;
  }
}
