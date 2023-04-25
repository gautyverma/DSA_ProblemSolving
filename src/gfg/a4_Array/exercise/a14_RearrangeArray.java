package gfg.a4_Array.exercise;

/*
* Given an array arr[] of size N where every element is in the range from 0 to n-1.
* Rearrange the given array so that arr[i] becomes arr[arr[i]].

    Example 1:

    Input:
    N = 2
    arr[] = {1,0}
    Output: 0 1
    Explanation:
    arr[arr[0]] = arr[1] = 0.
    arr[arr[1]] = arr[0] = 1.


    Example 2:

    Input:
    N = 5
    arr[] = {4,0,2,1,3}
    Output: 3 4 2 0 1
    Explanation:
    arr[arr[0]] = arr[4] = 3.
    arr[arr[1]] = arr[0] = 4.
    and so on.


    Your Task:

    * You don't need to read input or print anything.
    * The task is to complete the function arrange() which takes arr and
    * N as input parameters and rearranges the elements in the array in-place.



    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)
* */

import java.util.Arrays;

public class a14_RearrangeArray {
  public static void main(String[] args) {
    //
    long[] arr = {4, 0, 2, 1, 3};
    arrange(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  // Eff Solution
  static void arrange(long arr[], int n) {
    for (int i = 0; i < n; i++) {
      int x = (int) arr[i];
      int y = (int) arr[x];
      arr[i] = x + (y % n) * n;
      // encoding 2 numbers in one place. We get the current number by mod
    }
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] / n;
      // we get the ith number by dividing by n.
    }
  }

  /*
  // NavieSolution
  static void arrange(long arr[], int n) {
    // your code here
    long arrs[] = new long[n];
    for (int i = 0; i < n; i++) {
      arrs[i] = arr[(int) arr[i]];
    }
    for (int j = 0; j < n; j++) {
      arr[j] = arrs[j];
    }
  }*/

}
