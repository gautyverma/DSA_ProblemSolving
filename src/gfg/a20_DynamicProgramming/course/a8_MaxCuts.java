package gfg.a20_DynamicProgramming.course;

public class a8_MaxCuts {
  public static void main(String[] args) {
    int n = 23, a = 12, b = 11, c = 13;
    System.out.println("Max number of cuts naive :: " + maxCutsNaive(n, a, b, c));
    System.out.println("Max number of cuts dp :: " + maxCutsDp(5, 2, 4, 3));
  }

  private static int maxCutsDp(int n, int a, int b, int c) {
    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      dp[i] = -1;
      if (i - a >= 0) dp[i] = Math.max(dp[i], dp[i - a]);
      if (i - b >= 0) dp[i] = Math.max(dp[i], dp[i - b]);
      if (i - c >= 0) dp[i] = Math.max(dp[i], dp[i - c]);
      if (dp[i] != -1) {
        dp[i]++;
      }
    }
    return dp[n];
  }

  private static int maxCutsNaive(int n, int a, int b, int c) {
    if (n < 0) return -1;
    if (n == 0) return 0;
    int res =
        Math.max(
            Math.max(maxCutsNaive(n - a, a, b, c), maxCutsNaive(n - b, a, b, c)),
            maxCutsNaive(n - c, a, b, c));
    if (res == -1) {
      return res;
    } else return res + 1;
  }
}
