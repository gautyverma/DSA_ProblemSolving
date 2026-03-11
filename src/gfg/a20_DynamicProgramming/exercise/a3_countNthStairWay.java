package gfg.a20_DynamicProgramming.exercise;

public class a3_countNthStairWay {
  public static void main(String[] args) {
    System.out.println("number of ways to Nth stair :: " + countWaysNaive(4));
    //    [x +2y = n] ==> floor(n/2 + 1)
    int countWays = 3 / 2 + 1;
    System.out.println("number of ways to Nth stair using mathematics:: " + countWays);
    System.out.println("number of ways to Nth stair :: " + countWaysOrder(4));
  }

  private static int countWaysOrder(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return countWaysOrder(n - 1) + countWaysOrder(n - 2);
  }

  private static Long countWaysNaive(int n) {
    int[] steps = {1, 2};
    return util(n, 0, steps);
  }

  private static Long util(int n, int i, int[] steps) {
    if (n == 0) return 1L;
    if (n < 0) return 0L;
    if (i == steps.length) return 0L;
    Long take = util(n - steps[i], i, steps);
    Long skip = util(n, i + 1, steps);
    return take + skip;
  }
}
