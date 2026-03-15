package a1_gfg.a20_DynamicProgramming.course;

public class a14_CountBst_n_keys {
  public static void main(String[] args) {
    System.out.println("Number of distinct bst's are :: " + countBst(5));
  }

  private static int countBst(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] = 0;
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }
}
