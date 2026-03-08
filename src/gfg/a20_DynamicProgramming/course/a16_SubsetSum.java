package gfg.a20_DynamicProgramming.course;

import java.util.ArrayList;

public class a16_SubsetSum {
  public static void main(String[] args) {
    Integer[] arr = {10, 20, 15};
    System.out.println(
        "Number of subset wih given sum (most naive sol) :: " + subSetSumMostNaive(arr, 35));
    System.out.println("-------------------------------------------------");
    System.out.println(
        "Number of subset wih given sum (naive sol) :: " + subSetSumNaive(arr, arr.length, 35));
    System.out.println("-------------------------------------------------");
    System.out.println(
        "Number of subset wih given sum (Dp sol) :: " + subSetDp(arr, arr.length, 35));
    System.out.println("-------------------------------------------------");
  }

  private static int subSetDp(Integer[] arr, int n, int sum) {
    int[][] dp = new int[n + 1][sum + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }
    for (int j = 1; j <= sum; j++) {
      dp[0][j] = 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (j < arr[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
        }
      }
    }
    return dp[n][sum];
  }

  private static int subSetSumNaive(Integer[] arr, int n, int sum) {
    if (n == 0) return sum == 0 ? 1 : 0;
    return subSetSumNaive(arr, n - 1, sum) + subSetSumNaive(arr, n - 1, sum - arr[n - 1]);
  }

  private static int subSetSumMostNaive(Integer[] arr, int sum) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    subSetUtil(arr, arr.length, new ArrayList<Integer>(), res);
    System.out.println(res);
    int count = 0;
    for (ArrayList<Integer> ss : res) {
      int temp = 0;
      for (Integer num : ss) {
        temp += num;
      }
      if (temp == sum) {
        count++;
      }
    }
    return count;
  }

  private static void subSetUtil(
      Integer[] arr, int n, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
    if (n == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    subSetUtil(arr, n - 1, list, res);
    list.add(arr[n - 1]);
    subSetUtil(arr, n - 1, list, res);
    // backtrack
    list.remove(list.size() - 1);
  }
}
