package a1_gfg.a20_DynamicProgramming.exercise;

/*
* Ways to write n as sum
*
* Given a positive integer n, the task is to find the number of different ways in
* which n can be written as a sum of two or more positive integers. Return the answer with the modulo 109+7.

Examples:

Input: n = 5
Output: 6
Explanation: 1+1+1+1+1, 1+1+1+2, 1+1+3, 1+4, 2+1+2 and 2+3. So, a total of 6 ways.
Input: n = 3
Output: 2
Explanation: 1+1+1 and 1+2.  So, a total of 2 ways.
* */
public class a6_WaysNSum {
  public static void main(String[] args) {
    System.out.println("countWays - naive :: " + countWaysNaive(3));
    System.out.println("countWays - dp :: " + countWaysDp(3));
  }

  private static int countWaysDp(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      dp[0][i] = 1;
    }
    for (int sum = 1; sum <= n; sum++) {
      for (int min = n; min >= 1; min--) {
        int take = 0;
        if (sum >= min) take = dp[sum - min][min];

        int skip = 0;
        if (min + 1 <= n) skip = dp[sum][min + 1];

        dp[sum][min] = take + skip;
      }
    }
    for (int i = 0;i<=n;i++){
      for (int j =0;j<=n;j++){
        System.out.print(dp[i][j]+" ");
      }
      System.out.println();
    }
    return dp[n][1] - 1;
  }

  static int countWaysNaive(int n) {
    return solve(n, 1) - 1; // remove single number case
  }

  static int solve(int remaining, int min) {

    if (remaining == 0) return 1;

    int ways = 0;

    for (int i = min; i <= remaining; i++) {
      ways += solve(remaining - i, i);
    }

    return ways;
  }
}
