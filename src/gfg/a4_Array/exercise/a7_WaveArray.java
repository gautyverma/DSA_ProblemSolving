package gfg.a4_Array.exercise;

import java.util.Arrays;

/*
* Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
* In other words, arrange the elements into a sequence such that
* arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....

If there are multiple solutions, find the lexicographically smallest one.

Note:The given array is sorted in ascending order, and you don't need to return
anything to make changes in the original array itself.

    Example 1:

    Input:
    n = 5
    arr[] = {1,2,3,4,5}
    Output: 2 1 4 3 5
    Explanation: Array elements after
    sorting it in wave form are
    2 1 4 3 5.
    Example 2:

    Input:
    n = 6
    arr[] = {2,4,7,8,9,10}
    Output: 4 2 8 7 10 9
    Explanation: Array elements after
    sorting it in wave form are
    4 2 8 7 10 9.
* */
public class a7_WaveArray {
  public static void main(String[] args) {
    //
    int arr[] = {1, 2, 3, 4, 5};
    convertToWave(arr.length, arr);
    System.out.println(Arrays.toString(arr));

    int arr1[] = {2, 4, 7, 8, 9, 10};
    convertToWave(arr1.length, arr1);
    System.out.println(Arrays.toString(arr1));
  }

  public static void convertToWave(int n, int[] a) {
    // code here
    int i = 0;
    while (i < n - 1) {
      // swap arr[i] & arr[i+1]
      a[i] = a[i] + a[i + 1];
      a[i + 1] = a[i] - a[i + 1];
      a[i] = a[i] - a[i + 1];

      i += 2;
    }
  }
}
