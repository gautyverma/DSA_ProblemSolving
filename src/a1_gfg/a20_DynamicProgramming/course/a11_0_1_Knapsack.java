package a1_gfg.a20_DynamicProgramming.course;

public class a11_0_1_Knapsack {
  public static void main(String[] args) {
    int[] val = {10, 40, 30, 50};
    int[] wt = {5, 4, 6, 3};
    int W = 10;
    System.out.println("Max value 0-1 knapsack :: " + knapsack(W, wt, val, val.length));
    System.out.println("-------------------------------");
    System.out.println("Max value 0-1 knapsack using dp :: " + knapsackDp(W, wt, val, val.length));
  }

  private static int knapsackDp(int W, int[] wt, int[] val, int n) {
    int[][] dp = new int[n + 1][W + 1];
    for (int i = 0; i <= W; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= n; i++) {
      dp[n][0] = 0;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= W; j++) {
        if (wt[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
        }
      }
    }
    return dp[n][W];
  }

  private static int knapsack(int W, int[] wt, int[] val, int n) {

    if (n == 0 || W == 0) return 0;

    if (wt[n - 1] > W) return knapsack(W, wt, val, n - 1);
    else
      return Math.max(
          knapsack(W, wt, val, n - 1), val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1));
  }
}
