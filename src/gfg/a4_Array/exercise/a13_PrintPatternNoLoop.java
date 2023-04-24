package gfg.a4_Array.exercise;

import java.util.ArrayList;
import java.util.List;

/*
Print a sequence of numbers starting with N where A[0] = N,
without using loop, in which  A[i+1] = A[i] - 5,
until A[i] > 0. After that A[i+1] = A[i] + 5  repeat it until A[i] = N.

    Example 1:

    Input: N = 16
    Output: 16 11 6 1 -4 1 6 11 16
    Explaination: The value decreases until it
    is greater than 0. After that it increases
    and stops when it becomes 16 again.
   */
public class a13_PrintPatternNoLoop {
  public static void main(String[] args) {
    //
    System.out.println(pattern(16));
  }

  static List<Integer> pattern(int N) {
    // code here
    ArrayList<Integer> list = new ArrayList<>();
    find(N, list);
    return list;
  }

  private static void find(int n, ArrayList<Integer> list) {
    if (n <= 0) {
      list.add(n);
      return;
    }
    list.add(n);
    find(n - 5, list);
    list.add(n);
  }
}
