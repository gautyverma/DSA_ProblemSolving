package gfg.a20_DynamicProgramming.course;

public class a9_MinCoinsToMakeValue {
  public static void main(String[] args) {
    int[] coins = {9, 6, 5, 1};
    int val = 11;
    System.out.println("Min coins :: " + getMinCoins(coins, val));
    System.out.println("Min coins using DP:: " + getMinCoinsDp(coins, val));
  }

  private static int getMinCoinsDp(int[] arr, int val) {
    int[] dp = new int[val + 1];
    dp[0] = 0;
    for (int i = 1; i <= val; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    for (int value = 1; value <= val; value++) {
      for (int coin = 0; coin < arr.length; coin++) {
        if (arr[coin] <= value) {
          int subRes = dp[value - arr[coin]];
          if (subRes != Integer.MAX_VALUE) {
            dp[value] = Math.min(dp[value], subRes + 1);
          }
        }
      }
    }
    return dp[val];
  }

  private static int getMinCoins(int[] coins, int val) {
    if (val == 0) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= val) {
        int subRes = getMinCoins(coins, val - coins[i]);
        if (subRes != Integer.MAX_VALUE) {
          res = Math.min(res, subRes + 1);
        }
      }
    }
    return res;
  }
}
