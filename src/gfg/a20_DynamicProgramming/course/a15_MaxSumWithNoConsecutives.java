package gfg.a20_DynamicProgramming.course;

public class a15_MaxSumWithNoConsecutives {
  public static void main(String[] args) {
    int[] arr = {10, 5, 15, 20, 2, 30};
    System.out.println("Max sum naive sol :: " + maxSumNaive(arr, arr.length));
    System.out.println("------------------------");
    System.out.println("Max sum dp sol :: " + maxSumDp(arr, arr.length));
    System.out.println("------------------------");
    System.out.println("Max sum space optimized dp sol :: " + maxSumDpSpace(arr, arr.length));
  }

  private static int maxSumDpSpace(int[] arr, int n) {
    if (n == 1) return arr[0];
    int prev_prev = arr[0];
    int prev = Math.max(arr[0], arr[1]);
    int res = prev;
    for (int i = 3; i <= n; i++) {
      res = Math.max(prev, prev_prev + arr[i - 1]);
      prev_prev = prev;
      prev = res;
    }
    return res;
  }

  private static int maxSumDp(int[] arr, int n) {
    if (n == 1) {
      return arr[0];
    }
    int[] dp = new int[n + 1];
    dp[1] = arr[0];
    dp[2] = Math.max(arr[0], arr[1]);
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
    }
    return dp[n];
  }

  private static int maxSumNaive(int[] arr, int n) {
    if (n == 1) return arr[0];
    else if (n == 2) return Math.max(arr[0], arr[1]);
    else return Math.max(maxSumNaive(arr, n - 1), maxSumNaive(arr, n - 2) + arr[n - 1]);
  }
}
