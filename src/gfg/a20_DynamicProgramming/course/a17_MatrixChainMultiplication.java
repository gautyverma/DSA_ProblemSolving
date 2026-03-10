package gfg.a20_DynamicProgramming.course;

public class a17_MatrixChainMultiplication {
  public static void main(String[] args) {
    int[] arr = {20, 10, 30, 40};
    System.out.println("Minimum number of multiplication :: " + mChain(arr, 0, arr.length - 1));
    System.out.println("Minimum number of multiplication DP sol :: " + mChainDp(arr, arr.length));
  }

  private static int mChainDp(int[] arr, int n) {
    int[][] dp = new int[n][n];
    for (int i = 0; i < n - 1; i++) {
      dp[i][i + 1] = 0;
    }
    for (int gap = 2; gap < n; gap++) {
      for (int i = 0; i + gap < n; i++) {
        int j = i + gap;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
        }
      }
    }
    return dp[0][n - 1];
  }

  private static int mChain(int[] arr, int i, int j) {
    if (i + 1 == j) return 0;
    int res = Integer.MAX_VALUE;
    for (int k = i + 1; k < j; k++) {
      res = Math.min(res, mChain(arr, i, k) + mChain(arr, k, j) + arr[i] * arr[k] * arr[j]);
    }
    return res;
  }
}
