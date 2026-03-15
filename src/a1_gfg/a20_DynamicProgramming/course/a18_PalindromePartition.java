package a1_gfg.a20_DynamicProgramming.course;

public class a18_PalindromePartition {
  public static void main(String[] args) {
    String str = "GEEK";
    System.out.println(
        "Min cuts required to make palindrome (naive sol):: " + palPart(str, 0, str.length() - 1));
    System.out.println("Min cuts required to make palindrome (dp sol):: " + palPartDp(str));
  }

  private static int palPartDp(String str) {
    int n = str.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = 0;
    }
    for (int gap = 1; gap < n; gap++) {
      for (int i = 0; i + gap < n; i++) {
        int j = i + gap;
        if (isPalindrome_Recursive(str, i, j)) dp[i][j] = 0;
        else {
          dp[i][j] = Integer.MAX_VALUE;
          for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
          }
        }
      }
    }
    return dp[0][n - 1];
  }

  private static int palPart(String str, int i, int j) {
    if (isPalindrome_Recursive(str, i, j)) return 0;
    int res = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      res = Math.min(res, 1 + palPart(str, i, k) + palPart(str, k + 1, j));
    }
    return res;
  }

  private static boolean isPalindrome_Recursive(String str, int start, int end) {
    if (start >= end) {
      return true;
    }
    return (str.charAt(start) == str.charAt(end)
        && isPalindrome_Recursive(str, start + 1, end - 1));
  }
}
