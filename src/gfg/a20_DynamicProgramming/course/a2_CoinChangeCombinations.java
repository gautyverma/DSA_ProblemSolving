package gfg.a20_DynamicProgramming.course;

public class a2_CoinChangeCombinations {
  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int sum = 4;
    System.out.println("--------------------------------------");
    System.out.println(
        "Number of combinations using naive solution :: "
            + countWaysNaive(coins, coins.length, sum));
    System.out.println("--------------------------------------");
    System.out.println("Number of combinations using dp solution :: " + countWaysDp(coins, sum));
    System.out.println("--------------------------------------");
  }

  private static int countWaysDp(int[] coins, int sum) {
    int[][] dp = new int[coins.length + 1][sum + 1];
    for (int i = 0; i <= coins.length; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= coins.length; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (coins[i - 1] <= j) {
          dp[i][j] += dp[i][j - coins[i - 1]];
        }
      }
    }
    return dp[coins.length][sum];
  }

  private static int countWaysNaive(int[] coins, int n, int sum) {
    if (sum == 0) return 1;
    if (sum < 0) return 0;
    if (n == 0) return 0;
    return countWaysNaive(coins, n, sum - coins[n - 1]) + countWaysNaive(coins, n - 1, sum);
  }
}
