package gfg.a20_DynamicProgramming.course;

public class a10_MinJumpsToReachEnd {
  public static void main(String[] args) {
    int arr[] = {3, 4, 2, 1, 2, 1};
    System.out.println("Min jumps naive sol :: " + minJumpsNaive(arr, arr.length));
    System.out.println("--------------------------");
    System.out.println("Min jumps naive sol :: " + minJumpsDp(arr, arr.length));
  }

  private static int minJumpsDp(int[] arr, int n) {
    int[] dp = new int[n];
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] + j >= i) {
          if (dp[j] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], dp[j] + 1);
          }
        }
      }
    }
    return dp[n - 1];
  }

  private static int minJumpsNaive(int[] arr, int n) {

    if (n == 1) return 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i <= n - 2; i++) {
      if (i + arr[i] >= n - 1) {
        int subRes = minJumpsNaive(arr, i + 1);
        if (subRes != Integer.MAX_VALUE) res = Math.min(res, subRes + 1);
      }
    }
    return res;
  }
}
