package gfg.a20_DynamicProgramming.exercise;

public class a3_countNthStairWay {
  public static void main(String[] args) {
    System.out.println("number of ways to Nth stair :: " + countWaysNaive(4));
    //    [x +2y = n] ==> floor(n/2 + 1)
    int countWays = 4 / 2 + 1;
    System.out.println("number of ways to Nth stair using mathematics:: " + countWays);
  }

  private static int countWaysNaive(int n) {
    int[] steps = {1, 2};
    return util(n, 0, steps);
  }

  private static int util(int n, int i, int[] steps) {
    if (n == 0) return 1;
    if (n < 0) return 0;
    if (i == steps.length) return 0;
    int take = util(n - steps[i], i, steps);
    int skip = util(n, i + 1, steps);
    return take + skip;
  }
}
