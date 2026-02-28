package gfg.a20_DynamicProgramming.course;

/*
* Given two strings:

A (length n) ,B (length m)
Find: Minimum number of operations required to convert A into B
Allowed operations: Insert, Delete, Replace
Each operation costs 1.

Example
A = "horse"
B = "ros"

horse
rorse   (replace h → r)
rose    (delete r)
ros     (delete e)

* Total = 3 operations

Answer = 3
* */
public class a3_EditDistance {
  public static void main(String[] args) {
    {
      String A = "horse";
      String B = "ros";
      System.out.println("--------------------------------------");
      System.out.println(
          "Min operations using naive app :: " + edNaive(A, B, A.length(), B.length()));
      System.out.println("--------------------------------------");
      System.out.println("Min operations using dp app :: " + edDp(A, B));
      System.out.println("--------------------------------------");
    }
  }

  private static int edDp(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        else dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
      }
    }
    return dp[m][n];
  }

  private static int edNaive(String s1, String s2, int m, int n) {
    if (m == 0) return n;
    if (n == 0) return m;
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) return edNaive(s1, s2, m - 1, n - 1);
    else
      return 1
          + Math.min(
              Math.min(edNaive(s1, s2, m, n - 1), edNaive(s1, s2, m - 1, n)),
              edNaive(s1, s2, m - 1, n - 1));
  }
}
