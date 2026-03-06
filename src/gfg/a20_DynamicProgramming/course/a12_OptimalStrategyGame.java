package gfg.a20_DynamicProgramming.course;

/*
 * Even number of coins are given
 * Two players are playing and alternatively can pick coin from either end
 * consider your turn is first as player - 1
 * */

public class a12_OptimalStrategyGame {
  public static void main(String[] args) {
    int[] arr = {20, 5, 4, 6};

    System.out.println("---------------------");
    System.out.println("Max value from recursive sol - 1 :: " + maxValRec1(arr));
    System.out.println("---------------------");
    System.out.println("Max value from recursive sol - 2 :: " + maxValRec2(arr, 0, arr.length - 1));
    System.out.println("---------------------");

    System.out.println("---------------------");
    System.out.println("Max value from dp sol :: " + maxValDp(arr, arr.length));
  }

  private static int maxValDp(int[] arr, int n) {
    int[][] dp = new int[n][n];
    for (int i = 0; i < n-1; i++) {
      dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
    }

    for (int gap = 3; gap < n; gap = gap + 2) {
      for (int i = 0; i + gap < n; i++) {
        int j = i + gap;
        dp[i][j] =
            Math.max(
                arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
      }
    }
    return dp[0][n - 1];
  }

  private static int maxValRec2(int[] arr, int i, int j) {
    if (i + 1 == j) return Math.max(arr[i], arr[j]);
    return Math.max(
        arr[i] + Math.min(maxValRec2(arr, i + 2, j), maxValRec2(arr, i + 1, j - 1)),
        arr[j] + Math.min(maxValRec2(arr, i + 1, j - 1), maxValRec2(arr, i, j - 2)));
  }

  private static int maxValRec1(int[] arr) {
    int sum = 0;
    for (int num : arr) {
      sum += num;
    }
    return recUtil1(arr, 0, arr.length - 1, sum);
  }

  private static int recUtil1(int[] arr, int i, int j, int sum) {
    if (i + 1 == j) return Math.max(arr[i], arr[j]);
    return Math.max(
        sum - recUtil1(arr, i + 1, j, sum - arr[i]), sum - recUtil1(arr, i, j - 1, sum - arr[j]));
  }
}
