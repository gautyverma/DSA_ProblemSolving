package gfg.a4_Array.exercise;

/*
Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.

        Note: If at any instance, there are no more subarrays of size greater than or equal to K,
        then reverse the last subarray (irrespective of its size).
        You shouldn't return any array, modify the given array in-place.

        Example 1:

        Input:
        N = 5, K = 3
        arr[] = {1,2,3,4,5}
        Output: 3 2 1 5 4
        Explanation: First group consists of elements
        1, 2, 3. Second group consists of 4,5.
        */

import java.util.Arrays;
import java.util.List;

public class a2_ReverseArrayInGroups {
  public static void main(String[] args) {
    //
    Integer[] arr = {1, 2, 3, 4, 5};
    Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    List<Integer> list = Arrays.asList(arr);
    reverseInGroups(list, arr.length, 3);
    System.out.println();
    //    reverseArrayInGroup(Arrays.asList(arr1), arr1.length, 3);
  }

  public static void reverseInGroups(List<Integer> arr, int n, int k) {
    // code here
    int i = 0;
    int j = k - 1;
    while (j < n) {
      solve(i, j, arr);
      j = j + k;
      i = i + k;
    }
    if (j >= n && i < n) solve(i, n - 1, arr);

    for (Integer var : arr) {
      System.out.print(var + " ");
    }
  }

  public static void solve(int i, int j, List<Integer> arr) {

    while (i < j) {
      int temp = arr.get(i);
      int temp2 = arr.get(j);
      arr.set(i, temp2);
      arr.set(j, temp);
      i++;
      j--;
    }
    return;
  }
}
