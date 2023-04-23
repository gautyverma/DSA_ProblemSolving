package gfg.a4_Array.exercise;
/*
Given a number n the task is to find the minimum number
which is divisible by all numbers from 1 to n. Print the answer modulo (10^9+7).


    Example 1:

    Input:
    n = 3
    Output:
    6
    Explanation:
    When n = 3 then the minimum number
    that is divisible by all the number
    till 3 is 6.
    Example 2:

    Input:
    n = 4
    Output:
    12
    Explanation:
    When n = 4 then the minimum number
    that is divisible by all the number
    till 4 is 12.
*/
public class a11_NumerGame {
  public static void main(String[] args) {
    //
    System.out.println(numGame(3L));
  }

  static Long numGame(Long n) {
    // code here
    long res = 1L;
    long mod = (long) (1e9 + 7);
    for (long i = 1; i <= n; i++) {
      res = lcm(res, i);
      res = res % mod;
    }
    return res;
  }

  private static Long lcm(Long a, Long b) {
    return (a * b) / gcd(a, b);
  }

  private static Long gcd(Long a, Long b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }
}
