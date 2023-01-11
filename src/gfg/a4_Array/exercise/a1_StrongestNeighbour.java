package gfg.a4_Array.exercise;
/*
Given an array arr[] of n positive integers.
The task is to find the maximum for every adjacent pairs in the array.

        Example 1:

        Input:
        n = 6
        arr[] = {1,2,2,3,4,5}
        Output: 2 2 3 4 5
        Explanation: Maximum of arr[0] and arr[1]
        is 2, that of arr[1] and arr[2] is 2, ...
        and so on. For last two elements, maximum
        is 5.
        */
public class a1_StrongestNeighbour {
  public static void main(String[] args) {

    int[] arr = {1, 2, 2, 3, 4, 5};
    int[] arr1 = {5, 5};
    strongestNeigbour(arr1.length, arr1);
  }

  private static void strongestNeigbour(int n, int[] arr) {
    for (int i = 1; i < n; i++) {
      System.out.print(Math.max(arr[i - 1], arr[i]) + " ");
    }
  }
}
