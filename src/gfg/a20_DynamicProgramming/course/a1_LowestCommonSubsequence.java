package gfg.a20_DynamicProgramming.course;

import java.util.Arrays;

public class a1_LowestCommonSubsequence {
  static int dp[][];

  public static void main(String[] args) {
    String s1 = "AXYZ";
    String s2 = "BAZ";
    System.out.println("-------------------------");
    System.out.println("Naive approach :: " + lcsNaive(s1, s2, s1.length(), s2.length()));
    System.out.println("-------------------------");

    dp = new int[s1.length() + 1][s2.length() + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    System.out.println("Using DP - memo based :: " + lcsMemo(s1, s2, s1.length(), s2.length()));
    System.out.println("-------------------------");
    System.out.println("Using DP - table based :: " + lcsTabular(s1, s2));
  }

  public static int lcsTabular(String A, String B) {

    int n = A.length();
    int m = B.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][m];
  }

  private static int lcsMemo(String s1, String s2, int n, int m) {
    if (n == 0 || m == 0) return 0;
    if (dp[n][m] != -1) {
      return dp[n][m];
    }

    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      dp[n][m] = 1 + lcsNaive(s1, s2, n - 1, m - 1);
    } else {
      dp[n][m] = Math.max(lcsNaive(s1, s2, n, m - 1), lcsNaive(s1, s2, n - 1, m));
    }
    return dp[n][m];
  }

  private static int lcsNaive(String s1, String s2, int n, int m) {
    // base condition
    if (n == 0 || m == 0) return 0;
    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      return 1 + lcsNaive(s1, s2, n - 1, m - 1);
    } else {
      return Math.max(lcsNaive(s1, s2, n, m - 1), lcsNaive(s1, s2, n - 1, m));
    }
  }
}
