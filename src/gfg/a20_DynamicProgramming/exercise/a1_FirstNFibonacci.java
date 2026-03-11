package gfg.a20_DynamicProgramming.exercise;

import java.util.Arrays;

public class a1_FirstNFibonacci {
  public static void main(String[] args) {
    System.out.println("fibonacci :: " + Arrays.toString(fiboDp(5)));
    System.out.println("Nth fibonacci number :: " + fiboDpN(50));
  }

  private static int[] fiboDp(int n) {
    int[] arr = new int[n];
    if (n == 1) {
      arr[0] = 0;

    } else {
      arr[0] = 0;
      arr[1] = 1;
      for (int i = 2; i < n; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
      }
    }
    return arr;
  }

  private static long fiboDpN(int n) {
    long res = 0;
    if (n == 0) return 0;
    if (n == 1) {
      return 1;
    } else {
      long prev_prev = 0;
      long prev = 1;
      for (int i = 2; i <= n; i++) {
        res = prev_prev + prev;
        prev_prev = prev;
        prev = res;
      }
    }
    return res;
  }
}
