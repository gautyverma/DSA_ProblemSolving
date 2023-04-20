package gfg.a4_Array.exercise;

import java.util.Arrays;

/*
*Given an array A[] of N positive integers.
* The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.
*
* Example 2:

    Input:
    N = 9
    A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
    Output:
    6
    Explanation:
    In the given array A[1] < A[7]
    satisfying the required
    condition(A[i] < A[j]) thus giving
    the maximum difference of j - i
    which is 6(7-1).


Your Task:
The task is to complete the function maxIndexDiff() which finds and returns maximum index difference.
Printing the output will be handled by driver code. Return 0 in case no such index is found.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 109

* */
public class a4_MaximumIndex {
  public static void main(String[] args) {
    //
    int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
    System.out.println(maxIndexDiffNavieSol(arr, arr.length));
    System.out.println(maxIndexDiffEffSol(arr, arr.length));
  }

  static int maxIndexDiffNavieSol(int arr[], int N) {
    System.out.println("<---- Naive Solution --->");
    int currMax = 0;
    for (int i = 0; i < N; i++) {
      int tempMax = 0;
      for (int j = i; j < N; j++) {
        if (arr[i] <= arr[j]) {
          tempMax = j - i;
        }
      }
      currMax = Math.max(currMax, tempMax);
    }
    return currMax;
  }

  static int maxIndexDiffEffSol(int arr[], int N) {
    System.out.println("<---- Efficient Solution --->");
    int[] lMin = new int[N];
    int[] rMax = new int[N];
    lMin[0] = arr[0];
    rMax[N - 1] = arr[N - 1];
    for (int i = 1; i < N; i++) {
      lMin[i] = Math.min(lMin[i - 1], arr[i]);
    }
    System.out.println(Arrays.toString(lMin));

    for (int i = N - 2; i >= 0; i--) {
      rMax[i] = Math.max(rMax[i + 1], arr[i]);
    }
    System.out.println(Arrays.toString(rMax));

    int maxDiff = 0, i = 0, j = 0;
    while (i < N && j < N) {
      if (lMin[i] <= rMax[j]) {
        maxDiff = Math.max(j - i, maxDiff);
        j++;
      } else {
        i++;
      }
    }
    return maxDiff;
  }
}
