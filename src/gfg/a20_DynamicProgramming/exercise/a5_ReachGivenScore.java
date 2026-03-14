package gfg.a20_DynamicProgramming.exercise;

/*
*
* Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find the number of distinct combinations to reach the given score.

Example 1:

Input:
n = 8
Output: 1
Explanation:when n = 8,{3,5} and {5,3}
are the two possible permutations but
these represent the same combination.
Hence output is 1.
Example 2:

Input:
n = 20
Output: 4
Explanation:When n = 20, {10,10},
{5,5,5,5},{10,5,5} and {3,3,3,3,3,5}
are different possible permutations.
Hence output will be 4.
*
* */
public class a5_ReachGivenScore {
  public static void main(String[] args) {
    int n = 20;
    System.out.println(count(20));
  }

  private static int count(int sum) {
    int[] moves = {3, 5, 10};
    int res = util(moves, 0, sum);
    return res;
  }

  private static int util(int[] moves, int i, int sum) {
    if (sum == 0) return 1;
    if (sum < 0) return 0;
    if (i == moves.length) return 0;

    int take = util(moves, i, sum - moves[i]);
    int skip = util(moves, i + 1, sum);

    return take + skip;
  }
}
