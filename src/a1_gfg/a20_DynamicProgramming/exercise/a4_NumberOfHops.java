package a1_gfg.a20_DynamicProgramming.exercise;

/*
* A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top of nth step.

Examples:

Input: n = 4
Output: 7
Explanation: Below are the 7 ways to reach 4th step:
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Input: n = 2
Output: 2
Explanation: Below are the 2 ways to reach 2nd step:
1 step + 1 step
2 step
Input: n = 1
Output: 1
* */
public class a4_NumberOfHops {
  public static void main(String[] args) {
    System.out.println("number of hops (naive sol)::" + countWaysNaive(4));
    System.out.println("number of hops (naive sol)::" + countWaysDp(4));

    System.out.println("number of hops (naive sol)::" + countWaysNaive(5));
    System.out.println("number of hops (naive sol)::" + countWaysDp(5));
  }

  private static int countWaysDp(int n) {
    if (n <= 2) return n;
    if (n == 3) return 4;
    int first = 1;
    int second = 2;
    int third = 4;
    for (int i = 4; i <= n; i++) {
      int res = first + second + third;
      first = second;
      second = third;
      third = res;
    }
    return third;
  }

  private static int countWaysNaive(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 4;
    return countWaysNaive(n - 1) + countWaysNaive(n - 2) + +countWaysNaive(n - 3);
  }
}
